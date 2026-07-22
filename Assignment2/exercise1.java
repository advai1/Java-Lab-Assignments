package Assignment2;

//========== Student Record ==========

class Student{
    String name;
    int rollNo;

    Student() {                             //Default Constructor
        name = "Default";
        rollNo = 0;
        System.out.println("Default Constructor called.");
    }
    
    Student(String n, int r) {              //Parameterized Constructor
         name = n;
         rollNo = r;
         System.out.println("Parameterized COnstructor called.");
    } 

    void display(){
        System.out.println("Name: "+ name + ", Roll No.: " + rollNo);
    }
}

public class exercise1{
    public static void main(String[] args){
        Student student1 = new Student();
        student1.display();
        Student student2 = new Student("Advait", 23);
        student2.display();
    }
}