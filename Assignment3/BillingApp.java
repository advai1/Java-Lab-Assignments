package Assignment3;

public class BillingApp {

    static int totalOrdersCount = 0;
    static double totalRevenue = 0.0;
    double taxRate = 5.0;

    //Track total orders
    private void trackOrder(double billAmount) {
        totalOrdersCount++;
        totalRevenue += billAmount;
    }

    // 1. DINE-IN: Base food cost + service charge
    public double calculateBill(double foodCost) {
        double tax = foodCost * (taxRate / 100);
        double total = foodCost + tax;
        
        trackOrder(total);
        return total;
    }

    // 2. TAKEAWAY: Base food cost + tax rate + small packaging fee
    public double calculateBill(double foodCost, double packagingFee) {
        double tax = foodCost * (taxRate / 100);
        double total = foodCost + tax + packagingFee;
        
        trackOrder(total);
        return total;
    }

    // 3. DELIVERY: Base food cost + tax rate + flat delivery fee + tip
    public double calculateBill(double foodCost, double packagingFee, double deliveryFee) {
        taxRate = 18.0;
        double tax = foodCost * (taxRate / 100);
        double total = foodCost + tax + packagingFee + deliveryFee;
        
        trackOrder(total);
        return total;
    }

    public static void main(String[] args) {
        BillingApp app = new BillingApp();

        System.out.println("--- Processing Restaurant Orders ---\n");

        // Order 1: Dine-in (Rs.500 food)
        double dineInBill = app.calculateBill(500.00, 8.0, 5.00);
        System.out.printf("Dine-in Order Total: Rs.%.2f%n", dineInBill);

        // Order 2: Takeaway (Rs.399.00 food, Rs.4.50 packaging fee)
        double takeawayBill = app.calculateBill(399.00, 4.50);
        System.out.printf("Takeaway Order Total: Rs.%.2f%n", takeawayBill);

        // Order 3: Delivery (Rs.399 food, Rs.4.50 packaging fee, Rs.43.5 delivery fee)
        double deliveryBill = app.calculateBill(399.00, 4.50, 70.85);
        System.out.printf("Delivery Order Total: Rs.%.2f%n", deliveryBill);

        System.out.println("\n=====================================");
        System.out.println("--- Daily Summary Dashboard ---");
        System.out.println("Total Orders Processed: " + totalOrdersCount);
        System.out.printf("Total Revenue Generated: Rs.%.2f%n", totalRevenue);
    }

}
