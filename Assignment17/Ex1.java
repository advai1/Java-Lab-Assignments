package Assignment17;
import javax.swing.*;

public class Ex1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration");
        frame.setSize(300, 200);
        frame.setLayout(null);
        
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 25);
        frame.add(nameLabel);
        
        JTextField nameText = new JTextField();
        nameText.setBounds(100, 20, 150, 25);
        frame.add(nameText);
        
        JButton btn = new JButton("Register");
        btn.setBounds(100, 80, 100, 25);
        frame.add(btn);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}