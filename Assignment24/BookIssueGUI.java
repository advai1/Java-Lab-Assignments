package Assignment24;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookIssueGUI extends JFrame implements ActionListener {
    JTextField tfId = new JTextField(10), tfName = new JTextField(10),
               tfIssue = new JTextField(10), tfReturn = new JTextField(10);
    JButton btnAdd = new JButton("Issue Book"), btnView = new JButton("View All"),
            btnDelete = new JButton("Delete Record");
    JTextArea area = new JTextArea(10, 40);
    Connection con;

    BookIssueGUI() {
        setTitle("Book Issue Tracking System");
        setLayout(new FlowLayout());
        add(new JLabel("Book ID:"));                   add(tfId);
        add(new JLabel("Student Name:"));              add(tfName);
        add(new JLabel("Issue Date (yyyy-mm-dd):"));   add(tfIssue);
        add(new JLabel("Return Date (yyyy-mm-dd):"));  add(tfReturn);
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

        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnAdd) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO book_issue VALUES (?,?,?,?)");
                ps.setInt(1, Integer.parseInt(tfId.getText()));
                ps.setString(2, tfName.getText());
                ps.setDate(3, Date.valueOf(tfIssue.getText()));
                ps.setDate(4, Date.valueOf(tfReturn.getText()));
                ps.executeUpdate();
                area.setText("Record added successfully.");
            } else if (e.getSource() == btnView) {
                ResultSet rs = con.createStatement().executeQuery("SELECT * FROM book_issue");
                area.setText("");
                while (rs.next())
                    area.append(rs.getInt(1) + " | " + rs.getString(2) + " | "
                              + rs.getDate(3) + " | " + rs.getDate(4) + "\n");
            } else if (e.getSource() == btnDelete) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM book_issue WHERE book_id=?");
                ps.setInt(1, Integer.parseInt(tfId.getText()));
                int n = ps.executeUpdate();
                area.setText(n > 0 ? "Record deleted." : "Record not found.");
            }
        } catch (Exception ex) {
            area.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new BookIssueGUI();
    }
}