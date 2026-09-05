package Assignment16;
import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        
        try {
            int age = sc.nextInt();
            if (age < 18) {
                throw new InvalidAgeException("Age is below 18. Not eligible to vote.");
            }
            System.out.println("You are eligible to vote.");
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally{
            sc.close();
        } 
    }
}