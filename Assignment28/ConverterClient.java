package Assignment28;
import java.rmi.*;
import java.util.Scanner;

public class ConverterClient {
    public static void main(String[] args) throws Exception {
        Converter c = (Converter) Naming.lookup("rmi://localhost:1099/ConverterService");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double cel = sc.nextDouble();
        System.out.println("Fahrenheit: " + c.celsiusToFahrenheit(cel));

        System.out.print("Enter temperature in Fahrenheit: ");
        double fah = sc.nextDouble();
        System.out.println("Celsius: " + c.fahrenheitToCelsius(fah));

        sc.close();
    }
}