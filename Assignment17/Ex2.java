package Assignment17;
import javax.swing.*;
import java.awt.event.*;

public class Ex2 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Employee Registration");
        f.setSize(350, 300);
        f.setLayout(null);
        
        JTextField id = new JTextField(); id.setBounds(100, 20, 150, 25);
        JTextField name = new JTextField(); name.setBounds(100, 60, 150, 25);
        JTextField dept = new JTextField(); dept.setBounds(100, 100, 150, 25);
        JTextField salary = new JTextField(); salary.setBounds(100, 140, 150, 25);
        
        f.add(new JLabel("ID:")).setBounds(20, 20, 80, 25); f.add(id);
        f.add(new JLabel("Name:")).setBounds(20, 60, 80, 25); f.add(name);
        f.add(new JLabel("Dept:")).setBounds(20, 100, 80, 25); f.add(dept);
        f.add(new JLabel("Salary:")).setBounds(20, 140, 80, 25); f.add(salary);
        
        JButton submit = new JButton("Submit");
        submit.setBounds(100, 190, 100, 25);
        f.add(submit);
        
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String info = "ID: " + id.getText() + "\nName: " + name.getText() + 
                              "\nDept: " + dept.getText() + "\nSalary: " + salary.getText();
                JOptionPane.showMessageDialog(f, info, "Employee Details", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}