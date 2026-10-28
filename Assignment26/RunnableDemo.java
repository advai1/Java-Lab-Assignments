package Assignment26;

class PrintNumbers implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task 1 - Number: " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

class PrintLetters implements Runnable {
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Task 2 - Letter: " + c);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintNumbers());
        Thread t2 = new Thread(new PrintLetters());
        t1.start();
        t2.start();
    }
}