package GuestLecture;

class PaymentThread extends Thread {

    public void run() {
        System.out.println("[Payment Status] processing customer's payment");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            System.out.println("[ERROR] Payment interrupted.");
        }
        System.out.println("[Payment Status] completed.");
    }
}

class PackingThread extends Thread {
    public void run() {
        System.out.println("[Packing Status] packing the order");
        try {
            Thread.sleep(4000);
        }
        catch (InterruptedException e) {
            System.out.println("[ERROR] Packing interrupted.");
        }
        System.out.println("[Packing Status] completed.");
    }
}

class DeliveryThread extends Thread {
    public void run() {
        System.out.println("[Delivery Status] preparing order for delivery");
        try {
            Thread.sleep(8000);
        }
        catch (InterruptedException e) {
            System.out.println("[ERROR] Delivery interrupted.");
        }
        System.out.println("[Delivery Status] completed.");
    }
}
public class OnlineShoppingThreads {
    public static void main(String[] args) {

        PaymentThread payment = new PaymentThread();
        PackingThread packing = new PackingThread();
        DeliveryThread delivery = new DeliveryThread();

        payment.start();
        packing.start();
        delivery.start();

    }
}
