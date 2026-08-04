package Assignment9;

class BankAccount {
    final String accountNumber;
    double balance;

    BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.printf("Amount Deposited: Rs.%.2f\n", amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Amount Withdrawn: Rs.%.2f\n", amount);
        } else {
            System.out.printf("ALERT!\nWithdrawal Failed: Insufficient funds for Amount Rs.%.2f.\n", amount);
        }
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Current Balance: Rs.%.2f\n\n", balance);
    }
}

public class finalBankAcc {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("AB-1234-QWER-878787", 5000.00);
        
        System.out.println("Account Details:");
        account.displayAccountDetails();
        
        account.deposit(1500.50);
        account.displayAccountDetails();
        
        account.withdraw(2000);
        account.displayAccountDetails();

        account.withdraw(10000);
        account.displayAccountDetails();
    }
}
