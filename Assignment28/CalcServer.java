package Assignment28;
import java.rmi.*;
import java.rmi.registry.*;

public class CalcServer {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost:1099/CalcService", new CalculatorImpl());
        System.out.println("Calculator RMI Server is running...");
    }
}