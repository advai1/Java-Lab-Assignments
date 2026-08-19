package Assignment13;
import java.io.*;

public class Ex1 {
    public static void main(String[] args) {
        String filename = "employee.txt";
        
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("EmpID: 101, Name: Advait, Dept: CSE");
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Reading from file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}