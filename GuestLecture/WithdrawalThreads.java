package GuestLecture;

class BankAccount {
    int balance = 5000;

    public synchronized void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew Rs." + amount
                    + ". Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + ": Not enough balance.");
        }
    }
}

class WithdrawalTask extends Thread {
    BankAccount acc;
    int amount;

    WithdrawalTask(BankAccount acc, String name, int amount) {
        super(name);
        this.acc = acc;
        this.amount = amount;
    }

    public void run() {
        acc.withdraw(amount);
    }
}

public class WithdrawalThreads {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        WithdrawalTask c1 = new WithdrawalTask(account, "Customer 1", 2000);
        WithdrawalTask c2 = new WithdrawalTask(account, "Customer 2", 2500);
        WithdrawalTask c3 = new WithdrawalTask(account, "Customer 3", 1500);

        c1.start();
        c2.start();
        c3.start();

        c1.join();
        c2.join();
        c3.join();

        System.out.println("Final Balance: " + account.balance);
    }
}