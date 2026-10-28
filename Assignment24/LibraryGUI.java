package Assignment24;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class LibraryGUI extends JFrame implements ActionListener {
    JTextField tfId = new JTextField(10), tfTitle = new JTextField(10), tfAuthor = new JTextField(10);
    JButton btnAdd = new JButton("Add"), btnView = new JButton("View"), btnDelete = new JButton("Delete");
    JTextArea area = new JTextArea(10, 35);
    Connection con;

    LibraryGUI() {
        setTitle("Library Management System");
        setLayout(new FlowLayout());
        add(new JLabel("Book ID:"));  add(tfId);
        add(new JLabel("Title:"));    add(tfTitle);
        add(new JLabel("Author:"));   add(tfAuthor);
        add(btnAdd); add(btnView); add(btnDelete);
        add(new JScrollPane(area));

        btnAdd.addActionListener(this);
        btnView.addActionListener(this);
        btnDelete.addActionListener(this);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
        } catch (Exception e) {
            area.setText("Connection error: " + e.getMessage());
        }

        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnAdd) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO book VALUES (?,?,?)");
                ps.setInt(1, Integer.parseInt(tfId.getText()));
                ps.setString(2, tfTitle.getText());
                ps.setString(3, tfAuthor.getText());
                ps.executeUpdate();
                area.setText("Book added successfully.");
            } else if (e.getSource() == btnView) {
                ResultSet rs = con.createStatement().executeQuery("SELECT * FROM book");
                area.setText("");
                while (rs.next())
                    area.append(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + "\n");
            } else if (e.getSource() == btnDelete) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM book WHERE book_id=?");
                ps.setInt(1, Integer.parseInt(tfId.getText()));
                int n = ps.executeUpdate();
                area.setText(n > 0 ? "Book deleted." : "Book not found.");
            }
        } catch (Exception ex) {
            area.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}