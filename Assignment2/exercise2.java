package Assignment2;

//========== Mobile Phone Inventory System ==========

class MobilePhone {

    String brand;
    String model;
    double price;

    
    MobilePhone() {                                                 //Default Constructor
        brand = "Unknown";
        model = "Unknown";
        price = 0.0;
        System.out.println("---Default Constructor called.---");
    }
   
    MobilePhone(String b, String m, double p) {                     //Parameterized Constructor
        brand = b;
        model = m;
        price = p;
        System.out.println("---Parameterized Constructor called.---");
    }
    
    MobilePhone(MobilePhone otherPhone) {                           //Copy Constructor
        brand = otherPhone.brand;
        model = otherPhone.model;
        price = otherPhone.price;
        System.out.println("---Copy Constructor called.---");
    }

    void displayDetails() {
        System.out.println("Brand: " + brand + " | Model: " + model + " | Price: Rs." + price);
        System.out.println("=================================================");
    }
}


public class exercise2 {
    public static void main(String[] args) {
        
        System.out.println("--- Mobile Phone Inventory System ---\n");

        //using the Default Constructor
        MobilePhone phone1 = new MobilePhone();
        phone1.displayDetails();

        //using the Parameterized Constructor
        MobilePhone phone2 = new MobilePhone("Samsung", "Galaxy S24", 60000);
        phone2.displayDetails();

        //using the Copy Constructor
        MobilePhone phone3 = new MobilePhone(phone2);
        phone3.displayDetails();
    }
}