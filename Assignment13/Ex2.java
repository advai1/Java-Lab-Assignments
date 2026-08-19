package Assignment13;
import java.io.*;

public class Ex2 {
    public static void main(String[] args) {
        String filename = "patient.txt";
        
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Patient ID: P123\nName: Rekha\nAge: 45\nDiagnosis: Mouth Cancer");
        } catch (IOException e) {
            System.out.println("Error writing.");
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Patient Details:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading.");
        }
    }
}