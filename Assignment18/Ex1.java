package Assignment18;
import javax.swing.*;
import java.awt.event.*;

public class Ex1 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator");
        f.setSize(300, 200);
        f.setLayout(null);
        
        JTextField n1 = new JTextField(); n1.setBounds(50, 20, 80, 25);
        JTextField n2 = new JTextField(); n2.setBounds(150, 20, 80, 25);
        f.add(n1); f.add(n2);
        
        JLabel res = new JLabel("Result: "); res.setBounds(50, 100, 150, 25); f.add(res);
        
        JButton addBtn = new JButton("+"); addBtn.setBounds(50, 60, 50, 25); f.add(addBtn);
        JButton subBtn = new JButton("-"); subBtn.setBounds(150, 60, 50, 25); f.add(subBtn);
        
        addBtn.addActionListener(e -> res.setText("Result: " + (Integer.parseInt(n1.getText()) + Integer.parseInt(n2.getText()))));
        subBtn.addActionListener(e -> res.setText("Result: " + (Integer.parseInt(n1.getText()) - Integer.parseInt(n2.getText()))));
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}