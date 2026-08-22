package Aug22;
import java.io.File;
import java.io.IOException;

public class fileHandling{
    public static void main(String[] args) {
        try {
            File myObj = new File("file123.txt"); // Create File object
            if (myObj.createNewFile()) {           // Try to create the file
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); // Print error details
            }
    }
}
