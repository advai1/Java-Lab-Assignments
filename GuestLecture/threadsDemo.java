package GuestLecture;

// class Restaurant {
//     String res_name;
//     String location;
//     double price;

//     Restaurant(){
//         this.res_name = "Unknown";
//         this.location = "Unknown";
//         this.price = 0;
//     }

//     Restaurant(String name, String loc, double price){
//         this.res_name = name;
//         this.location = loc;
//         this.price = price;
//     }
// }

class Counter extends Thread {
    private String name;

    Counter(String name){
        this.name = name;
    }

    public void run() {
        for (int i=0; i<=5; i++){
            System.out.println(name + " prints " + i);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println(name + " was interrupted: " + e.getMessage());
            }
        }
    }
}

public class threadsDemo {
    public static void main(String[] args) {
        //Restaurant r1 = new Restaurant();
        //Restaurant r2 = new Restaurant("Raaga Imperio", "Ravet", 500);

        Counter c1 = new Counter("Counter 1");
        Counter c2 = new Counter("Counter 2");
        Counter c3 = new Counter("Counter 3");
        c1.run();
        c2.run();
        c3.run();
    }
}
