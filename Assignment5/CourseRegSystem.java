package Assignment5;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegSystem {

    public static void main(String[] args) {

        ArrayList<String> registeredCourses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        
        while (choice != 4) {
            System.out.println("\n=== Student Course Registration System ===");
            System.out.println("1. Add a Course");
            System.out.println("2. Remove a Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Exit");

            System.out.print("Select (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Add a Course
                    System.out.print("Enter the name of the course to add: ");
                    String toAdd = scanner.nextLine();
                    
                    if (registeredCourses.contains(toAdd)) {
                        System.out.println("You are already registered for " + toAdd + ".");
                    }
                    else {
                        registeredCourses.add(toAdd);
                        System.out.println("Successfully added: " + toAdd);
                    }
                    break;

                case 2:
                    // Remove a Course
                    System.out.print("Enter the name of the course to remove: ");
                    String toRemove = scanner.nextLine();
                    
                    
                    if (registeredCourses.remove(toRemove)) {                   // remove() returns true if the item was found and removed
                        System.out.println("Successfully removed: " + toRemove);
                    } else {
                        System.out.println("Error! Cannot find course " + toRemove + ".");
                    }
                    break;

                case 3:
                    // Display Registered Courses
                    if (registeredCourses.isEmpty()) {
                        System.out.println("You have not registered for any courses yet.");
                    }
                    else {
                        StringBuffer displayBuffer = new StringBuffer();
                        displayBuffer.append("\n--- Registered Courses ---\n");
                        
                        for (int i = 0; i < registeredCourses.size(); i++) {
                            
                            displayBuffer.append((i + 1))
                                         .append(". ")
                                         .append(registeredCourses.get(i))
                                         .append("\n");
                        }
                        
                        System.out.print(displayBuffer.toString());
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("=x= Exited System =x=");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
    }
}
