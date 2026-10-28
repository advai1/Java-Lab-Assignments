package Assignment28;
import java.rmi.*;

public class CalcClient {
    public static void main(String[] args) throws Exception {
        Calculator c = (Calculator) Naming.lookup("rmi://localhost:1099/CalcService");
        System.out.println("10 + 5 = " + c.add(10, 5));
        System.out.println("10 - 5 = " + c.subtract(10, 5));
        System.out.println("10 * 5 = " + c.multiply(10, 5));
    }
}