package Assignment3;


class calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        calculator calc = new calculator();


        int sumTwoInts = calc.add(15, 25);
        System.out.println("Sum of two integers (15 + 25) = " + sumTwoInts);


        double sumTwoFloats = calc.add(12.5,4.3);
        System.out.println("Sum of two floating-point numbers (12.5 + 4.3) = " + sumTwoFloats);

        int sumThreeInts = calc.add(10, 20, 30);
        System.out.println("Sum of three integers (10 + 20 + 30) = " + sumThreeInts);
    }
}