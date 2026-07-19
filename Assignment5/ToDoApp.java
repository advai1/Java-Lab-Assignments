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
            System.out.println("(1) Add Task    (2) View List   (3) Exit");
            String choice = input.nextLine();

            switch (choice) {
                
                case "1":
                    System.out.print("Enter task: ");
                    ToDoList.add(input.nextLine());
                    System.out.println("Task added.");
                    break;

                case "2":
                    StringBuffer sb = new StringBuffer();
                    sb.append("<---Your List--->");
                    for (int i = 0; i < ToDoList.size(); i++){
                        sb.append((i+1) + ". " + ToDoList.get(i) + "\n");   //adds each task as a formatted string into buffer
                    }
                    System.out.println(sb);                                 //prints all the buffer content, i.e. all tasks
                    break;

                case "3":
                    running = false;
                    System.out.println("---Exited App---");
                    break;

                default:
                    System.out.println("Invalid Choice!")
                    break;
            }
        }
        input.close();
        
    }
}
