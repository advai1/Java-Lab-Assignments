package Assignment3;

public class Calculator {

    static int calculationCount = 0;

    public int add(int a, int b) {
        calculationCount++;
        return a + b;
    }


    public double add(double a, double b) {
        calculationCount++;
        return a + b;
    }

    public static void main(String[] args) {

        Calculator myCalc = new Calculator();

        // Integer addition
        int intResult = myCalc.add(10, 5);
        System.out.println("10 + 5 = " + intResult);

        //Decimal addition
        double decimalResult = myCalc.add(4.5, 3.2);
        System.out.println("4.5 + 3.2 = " + decimalResult);


        int anotherIntResult = myCalc.add(100, 250);
        System.out.println("100 + 250 = " + anotherIntResult);

        System.out.println("Total calculations performed: " + Calculator.calculationCount);
    }
}
