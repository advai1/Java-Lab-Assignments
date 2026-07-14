package Assignment4;

import java.util.Scanner;                           //Scanner class for input

public class exercise2{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("--- Employee Payroll System ---\n");

        //String inputs
        System.out.print("Enter Employee ID: ");
        String empIDString = input.nextLine();
        System.out.print("Enter Basic Salary: ");
        String salaryString = input.nextLine();
        System.out.print("Enter Bonus Amount: ");
        String bonusString = input.nextLine();

        //Wrappers
        Integer empID = Integer.valueOf(empIDString);
        Double basicSalary = Double.valueOf(salaryString);
        Double bonus = Double.valueOf(bonusString);

        //Salary Validation
        if (basicSalary <= 0) {
            System.out.println("\n!ERROR: Invalid salary value! Basic salary must be greater than 0.");
        }
        else {
            //Calculate Net Salary
            Double netSalary = basicSalary + bonus;

            //Display Payroll
            System.out.println("\n _______________________________");
            System.out.println("|-------Payroll Details---------|");
            System.out.println("|Employee ID  :" + empID + "\t\t|");
            System.out.println("|Basic Salary :Rs." + basicSalary + "\t|");
            System.out.println("|Bonus        :Rs." + bonus + "\t|");
            System.out.println("|-------------------------------|");
            System.out.println("|Net Salary   :Rs." + netSalary+ "\t|");
            System.out.println("|_______________________________|");
        }

        //Close Scanner
        input.close();
    }
}