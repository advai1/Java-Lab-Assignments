package Assignment10;

abstract class Payment {
    abstract void pay(double amount);
}

class CreditCardPayment extends Payment {
    String cardNo;

    CreditCardPayment(String cardNo) {
        this.cardNo = cardNo;
    }

    void pay(double amount) {
        double processingFee = amount * 0.02;
        double totalAmount = amount + processingFee;
        
        System.out.println("Credit Card: " + cardNo);
        System.out.printf("Base Amount:    Rs.%.2f\n",amount);
        System.out.printf("Processing Fee: Rs.%.2f\n",processingFee);
        System.out.printf("Total Charged:  Rs.%.2f\n\n", totalAmount);
    }
}

class UPIPayment extends Payment {
    String upiId;

    UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    void pay(double amount) {
        System.out.println("UPI ID: " + upiId);
        System.out.printf("Total Charged:  Rs.%.2f\n\n", amount);
    }
}

public class AbstractPayment {
    public static void main(String[] args) {
        Payment card = new CreditCardPayment("4532-1688-2657-1234");
        card.pay(2599.99);

        Payment upi = new UPIPayment("adv1122@jvbank");
        upi.pay(345.5);
    }
}
