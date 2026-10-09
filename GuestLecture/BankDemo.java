package GuestLecture;

class Account {
    int balance = 1000;

    synchronized void deposit(int amt) {
        balance += amt;
        System.out.println("Deposited " + amt + " | Balance: " + balance);
    }

    synchronized void withdraw(int amt) {
        if (balance >= amt) {
            balance -= amt;
            System.out.println("Withdrew " + amt + " | Balance: " + balance);
        } else {
            System.out.println("Insufficient balance for " + amt + " | Balance: " + balance);
        }
    }
}

class DepositThread extends Thread {
    Account acc;
    DepositThread(Account acc) { this.acc = acc; }

    public void run() {
        for (int i = 0; i < 3; i++) acc.deposit(500);
    }
}

class WithdrawThread extends Thread {
    Account acc;
    WithdrawThread(Account acc) { this.acc = acc; }

    public void run() {
        for (int i = 0; i < 3; i++) acc.withdraw(700);
    }
}

public class BankDemo {
    public static void main(String[] args) throws InterruptedException {
        Account acc = new Account();

        DepositThread t1 = new DepositThread(acc);
        WithdrawThread t2 = new WithdrawThread(acc);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Balance: " + acc.balance);
    }
}