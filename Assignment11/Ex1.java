package Assignment11;

interface Printable {
    void printDetails();
}

class Student implements Printable {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void printDetails() {
        System.out.println("Student Name: " + name + ", Roll No: " + rollNo);
    }
}

class Employee implements Printable {
    String name;
    int empId;

    Employee(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    public void printDetails() {
        System.out.println("Employee Name: " + name + ", Emp ID: " + empId);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Printable s = new Student("Advait", 101);
        Printable e = new Employee("Ramesh", 5001);
        s.printDetails();
        e.printDetails();
    }
}