package Assignment8;

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }
}

class Manager extends Employee {
    String department;

    Manager(int id, String name, String department) {
        super(id, name); 
        this.department = department;
    }

    void display() {
        super.display(); 
        System.out.println("Managing Department: " + department);
    }
}

public class EmpandMan {
    public static void main(String[] args) {
        Manager mgr = new Manager(101, "Advait Dhanawade", "IT");
        mgr.display();
    }
}
