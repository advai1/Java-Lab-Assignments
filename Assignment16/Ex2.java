package Assignment16;
import java.util.Scanner;

class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age for Driving License: ");
        
        try {
            int age = sc.nextInt();
            if (age < 18) {
                throw new UnderAgeException("Applicant must be 18 or older.");
            }
            System.out.println("You are eligible for a driving license.");
        } catch (UnderAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        sc.close();
    }
}