package Assignment7;

interface ProductInfo {
    void displayDetails();
}

class BaseProduct {
    String name;
    double price;
    
    public BaseProduct(String name, double price){
        this.name = name;
        this.price = price;
    }
}


class Electronics extends BaseProduct implements ProductInfo {
    int warrantyMonths;
    
    public Electronics(String name, double price, int warrantyMonths){
        super(name, price);
        this.warrantyMonths = warrantyMonths;
    }
    public void displayDetails(){
        System.out.printf("Electronics: %s | Price: Rs.%.2f | Warranty: %d months%n", name, price, warrantyMonths);
    }
}

class Clothing extends BaseProduct implements ProductInfo {
    String size;
    
    public Clothing(String name, double price, String size){
        super(name, price);
        this.size = size;
    }
    public void displayDetails(){
        System.out.printf("Clothing: %s | Price: Rs.%.2f | Size: %s%n", name, price, size);
    }
}

class Grocery extends BaseProduct implements ProductInfo {
    String expirationDate;
    
    public Grocery(String name, double price, String expirationDate){
        super(name, price);
        this.expirationDate = expirationDate;
    }
    public void displayDetails(){
        System.out.printf("Grocery: %s | Price: Rs.%.2f | Expires: %s%n", name, price, expirationDate);
    }
}


public class ECommerceApp {
    public static void main(String[] args) {
        
        Electronics myLaptop = new Electronics("Laptop", 79500, 24);
        Clothing myJacket = new Clothing("Denim Jacket", 2799.99, "Medium");
        Grocery myMilk = new Grocery("Whole Milk", 28.5, "1/8/26");

        System.out.println("=== E-Commerce Product System ===");
        myLaptop.displayDetails();
        myJacket.displayDetails();
        myMilk.displayDetails();
    }
}