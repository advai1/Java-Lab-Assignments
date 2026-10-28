package Assignment28;
import java.rmi.*;
import java.rmi.registry.*;

public class ConverterServer {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost:1099/ConverterService", new ConverterImpl());
        System.out.println("Temperature Converter RMI Server is running...");
    }
}