package Assignment10;

abstract class FoodOrder {
    double orderAmount;

    FoodOrder(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {
    DineInOrder(double orderAmount) {
        super(orderAmount);
    }

    void calculateBill() {
        double serviceCharge = orderAmount * 0.1;
        double totalBill = orderAmount + serviceCharge;
        
        System.out.printf("Base Amount:           Rs.%.2f\n", orderAmount);
        System.out.printf("Service Charge (10%%):  Rs.%.2f\n", serviceCharge);
        System.out.printf("Dine-In Total:         Rs.%.2f\n\n", totalBill);
    }
}

class TakeAwayOrder extends FoodOrder {
    TakeAwayOrder(double orderAmount) {
        super(orderAmount);
    }

    void calculateBill() {
        double packagingFee = 15.00;
        double totalBill = orderAmount + packagingFee;
        
        System.out.printf("Base Amount:     Rs.%.2f\n", orderAmount);
        System.out.printf("Packaging Fee:   Rs.%.2f\n", packagingFee);
        System.out.printf("Take-Away Total: Rs.%.2f\n\n", totalBill);
    }
}

public class AbstractFoodOrder {
    public static void main(String[] args) {
        FoodOrder tableOne = new DineInOrder(700);
        tableOne.calculateBill();

        FoodOrder pickupOne = new TakeAwayOrder(480.14);
        pickupOne.calculateBill();
    }
}