package Assignment8;

class Vehicle {
    String company;
    String model;
    String licenseNo;

    Vehicle(String company, String model, String licenseNo) {
        this.company = company;
        this.model = model;
        this.licenseNo = licenseNo;
    }

    void showVehicleInfo() {
        System.out.println("Vehicle: " + company + " " + model);
        System.out.println("License No.: " + licenseNo);
    }
}

class CarInsurance extends Vehicle {
    String policyNumber;
    double premiumAmount;

    CarInsurance(String company, String model, String licenseNo, String policyNumber, double premiumAmount) {
        super(company, model, licenseNo); 
        this.policyNumber = policyNumber;
        this.premiumAmount = premiumAmount;
    }

    void showInsuranceInfo() {
        super.showVehicleInfo(); 
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Premium Amount: Rs." + premiumAmount);
    }
}

public class InsuranceMain {
    public static void main(String[] args) {
        CarInsurance insurance = new CarInsurance("Tata", "Nexon", "MH01QW7891", "POL12345", 5000);
        insurance.showInsuranceInfo();
    }
}
