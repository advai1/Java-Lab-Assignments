package Assignment14;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter product quantity: ");
        try {
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                throw new Exception("Quantity must be greater than zero.");
            }
            System.out.println("Order placed for " + quantity + " items.");
        } catch (Exception e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }finally{
            sc.close();
        }
    }
}