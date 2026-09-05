package Assignment14;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        double balance = 5000.0;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter withdrawal amount: ");
        try {
            double amount = sc.nextDouble();
            if (amount > balance) {
                throw new Exception("Insufficient Balance!");
            }
            if (amount <= 0) {
                throw new Exception("Invalid amount entered!");
            }
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: Rs." + balance);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally{
            sc.close();
        }
    }
}