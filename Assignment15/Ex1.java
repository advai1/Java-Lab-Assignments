package Assignment15;
import java.util.Scanner;

public class Ex1 {
    static void checkPassword(String pwd) throws Exception {
        if (!pwd.equals("admin123")) {
            throw new Exception("Incorrect password.");
        }
        System.out.println("Login successful.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String pwd = sc.nextLine();
        
        try {
            checkPassword(pwd);
        } catch (Exception e) {
            System.out.println("Login Failed: " + e.getMessage());
        } finally {
            System.out.println("Login process terminated.");
            sc.close();
        }
    }
}