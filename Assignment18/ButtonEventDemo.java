package Assignment18;

import javax.swing.*;
import java.awt.event.*;

public class ButtonEventDemo {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Click Event");

        JButton button = new JButton("Click Me");
        button.setBounds(100,50,120,40);

        JLabel label = new JLabel();
        label.setBounds(60,110,250,30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                label.setText("Button Clicked Successfully");
            }
        });
        frame.add(button);
        frame.add(label);

        frame.setSize(350, 220);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
