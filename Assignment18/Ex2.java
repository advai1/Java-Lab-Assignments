package Assignment18;
import javax.swing.*;

public class Ex2 {
    static double balance = 0.0;
    public static void main(String[] args) {
        JFrame f = new JFrame("Bank Calculator");
        f.setSize(350, 250);
        f.setLayout(null);
        
        f.add(new JLabel("Amount:")).setBounds(20, 20, 80, 25);
        JTextField amt = new JTextField(); amt.setBounds(100, 20, 100, 25); f.add(amt);
        
        JLabel balLabel = new JLabel("Balance: 0.0"); balLabel.setBounds(100, 100, 150, 25); f.add(balLabel);
        
        JButton depBtn = new JButton("Deposit"); depBtn.setBounds(20, 60, 90, 25); f.add(depBtn);
        JButton widBtn = new JButton("Withdraw"); widBtn.setBounds(130, 60, 100, 25); f.add(widBtn);
        
        depBtn.addActionListener(e -> {
            balance += Double.parseDouble(amt.getText());
            balLabel.setText("Balance: " + balance);
        });
        
        widBtn.addActionListener(e -> {
            balance -= Double.parseDouble(amt.getText());
            balLabel.setText("Balance: " + balance);
        });
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}