package Assignment7;

interface Shape {
    
    void calculateArea();
}

class Circle implements Shape {
    double radius;
    double area;
    
    public Circle(double radius){
        this.radius = radius;
    }
    public void calculateArea(){
        area = Math.PI * radius * radius;
        System.out.printf("Area of Circle = %.2f sq units%n", area);
    };
}

class Rectangle implements Shape {
    double length, breadth;
    double area;
    
    public Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public void calculateArea(){
        area = length * breadth;
        System.out.printf("Area of Rectangle = %.2f sq units%n", area);
    };
}

public class ShapeApp {
    public static void main(String[] args) {
        

        Circle myCircle = new Circle(5.0);
        Rectangle myRectangle = new Rectangle(4.0, 6.0);

        myCircle.calculateArea();
        myRectangle.calculateArea();
    }
}
