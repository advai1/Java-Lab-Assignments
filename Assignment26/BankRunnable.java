package Assignment26;

class Account {
    int balance = 1000;

    synchronized void deposit(int amt) {
        balance += amt;
        System.out.println("Deposited " + amt + " | Balance: " + balance);
    }

    synchronized void withdraw(int amt) {
        if (balance >= amt) {
            balance -= amt;
            System.out.println("Withdrawn " + amt + " | Balance: " + balance);
        } else {
            System.out.println("Withdraw " + amt + " failed: insufficient balance");
        }
    }
}

class DepositTask implements Runnable {
    Account acc;
    DepositTask(Account acc) { this.acc = acc; }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            acc.deposit(500);
            try { Thread.sleep(200); } catch (InterruptedException e) { }
        }
    }
}

class WithdrawTask implements Runnable {
    Account acc;
    WithdrawTask(Account acc) { this.acc = acc; }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            acc.withdraw(700);
            try { Thread.sleep(200); } catch (InterruptedException e) { }
        }
    }
}

public class BankRunnable {
    public static void main(String[] args) {
        Account acc = new Account();
        new Thread(new DepositTask(acc)).start();
        new Thread(new WithdrawTask(acc)).start();
    }
}