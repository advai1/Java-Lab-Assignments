package Assignment6;


interface DeliveryStatus {
    void updateStatus(String message);
}


class FoodOrder {
    private String restaurantName;
    private String customerName;

    public FoodOrder(String restaurantName, String customerName) {
        this.restaurantName = restaurantName;
        this.customerName = customerName;
    }

    //Inner Class for specific order
    class OrderDetails {
        private String itemName;
        private double amount;

        public OrderDetails(String itemName, double amount) {
            this.itemName = itemName;
            this.amount = amount;
        }

        public void displayOrder() {
            System.out.println("=== Order Info ===");
            System.out.println("Customer: " + customerName);
            System.out.println("Restaurant: " + restaurantName);
            System.out.println("Item: " + itemName);
            System.out.println("Total Amount: Rs." + amount);
            System.out.println("==================");
        }
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        
        // Instantiate outer class
        FoodOrder myOrder = new FoodOrder("Burger King", "Advait");
        
        // Instantiate inner class
        FoodOrder.OrderDetails details = myOrder.new OrderDetails("Whopper Meal", 399.99);
        details.displayOrder();
        
        System.out.println();
        

        DeliveryStatus tracker = new DeliveryStatus() {
            public void updateStatus(String message) {
                System.out.println("Status: " + message);
            }
        };
        
        tracker.updateStatus("Order is being prepared.");
        tracker.updateStatus("Driver has picked up the order.");
        tracker.updateStatus("Driver is on the way.");
        tracker.updateStatus("Order delivered successfully!");
    }
}