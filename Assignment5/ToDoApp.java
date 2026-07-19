package Assignment5;

import java.util.Scanner;
import java.util.ArrayList;

public class ToDoApp {

    public static void main(String[] args) {
        ArrayList<String> ToDoList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        System.out.println("To-Do List Initialized.");

        while (running) {

            System.out.println("Select Task");
            System.out.println("(1) Add Task    (2) Delete Task    (3) View List    (4) Exit");
            String choice = input.nextLine();

            switch (choice) {
                
                case "1":
                    System.out.print("Enter task: ");
                    ToDoList.add(input.nextLine());
                    System.out.println("Task added.");
                    break;

                case "2":
                    System.out.print("Enter task no.: ");
                    int toDelete = input.nextInt();
                    input.nextLine(); // for the leftover enter key!

                    if (toDelete > 0 && toDelete <= ToDoList.size()) {  // Check if the no. is valid
                        ToDoList.remove(toDelete - 1);
                        System.out.println("Task deleted.");
                    }
                    else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case "3":
                    StringBuffer sb = new StringBuffer();
                    sb.append("===Your List===>\n");
                    for (int i = 0; i < ToDoList.size(); i++){
                        sb.append((i+1) + ". " + ToDoList.get(i) + "\n");   //adds each task as a formatted string into buffer
                    }
                    sb.append("===============>");
                    System.out.println(sb);                                 //prints all the buffer content, i.e. all tasks
                    break;

                case "4":
                    running = false;
                    System.out.println("---Exited App---");
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
        input.close();
        
    }
}
