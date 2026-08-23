package Assignment15;
import java.util.Scanner;

public class Ex2 {
    static void verifyPin(int pin) throws Exception {
        if (pin != 1234) {
            throw new Exception("Invalid PIN entered.");
        }
        System.out.println("PIN verified.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 4-digit ATM PIN: ");
        
        try {
            int pin = sc.nextInt();
            verifyPin(pin);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Verification process completed.");
            sc.close();
        }
    }
}