package Assignment11;

interface Switchable {
    void turnOn();
}

class Light implements Switchable {
    public void turnOn() {
        System.out.println("Light is now ON.");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan is now spinning.");
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Switchable myLight = new Light();
        Switchable myFan = new Fan();
        
        myLight.turnOn();
        myFan.turnOn();
    }
}