package Assignment6;


interface VehicleMove {
    void move();
}

class Vehicle {
    private String brand;
    private String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    //Inner Class
    class DetailsPrinter {
        public void displayDetails() {
            System.out.println("=== Vehicle Info ===");
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("====================");
        }
    }
}

public class anonVehicle {
    public static void main(String[] args) {

        Vehicle myCar = new Vehicle("Tata", "Tiago");

        Vehicle.DetailsPrinter printer = myCar.new DetailsPrinter();
        printer.displayDetails();


        VehicleMove forward = new VehicleMove() {
            public void move() {
                System.out.println("*Vehicle starts moving forward*");
            }
        };

        forward.move();
    }
}