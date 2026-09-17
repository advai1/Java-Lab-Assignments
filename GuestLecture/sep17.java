package GuestLecture;
import java.util.Scanner;

public class sep17 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // -----------Eligibility for Blood Donation
        // System.out.println("Enter age: ");
        // int n = sc.nextInt();
        // if (n>=18){
        //     System.out.println("Eligible to donate blood.");
        // }
        // else{
        //     System.out.println("Not eligible to donate blood.");
        // }
        // 

        // -----------Check Palindrome Number
        // System.out.print("Enter a number: ");
        // int n = sc.nextInt();
        // int n2 =  n;
        // int rev = 0;
        // while (n2 > 0){
        //     rev = rev*10 + n2%10;
        //     n2 = n2/10;
        // }
        // if (n == rev) System.out.println(n+" is a palindrome.");
        // else System.out.println(n+" is not a palindrome.");
        // sc.close();

        //------------Print first ten natural nums
        // for (int i=1; i<=10; i++){
        //     System.out.print(i+" ");
        // }

        //------------Fibonacci Series
        // System.out.print("Enter a number: ");
        // int n = sc.nextInt();
        // int fib[] = new int[n];
        // fib[0] = 0;
        // fib[1] = 1;

        // for (int i=2; i<n; i++){
        //     fib[i] = fib[i-1] + fib[i-2];
        // }
        // for (int i=0; i<n; i++){
        //     System.out.print(fib[i]+" ");
        // }

        //-------------First 20 numbers from 60 to 100
        //-------------case 1: num should be numeric
        //-------------case 2: div by 5
        //-------------case 3: reverse order
        // int count = 0;
        // for (int i=60; i<=100 && count <=20; i++){
        //     System.out.print(i+" ");
        //     count++;
        // }
        // System.out.println();
        // count = 0;
        // for (int i=60; i<=100 && count <=20; i++){
        //     if (i%5 == 00){
        //         System.out.print(i+" ");
        //         count++;
        //     }
        // }
        // System.out.println();
        // count = 0;
        // for (int i=100; i>=60 && count <=20; i--){
        //     if (i%5 == 00){
        //         System.out.print(i+" ");
        //         count++;
        //     }
        // }

        //-----------print golden numbers from 4000 to 4030
        // for (int i=4000; i<=4030; i++){
        //     if (i%4==0) System.out.print(i+" ");
        // }

        //-----------print angstorm nums in the range 1 to 500
        // for (int i=0; i<=500; i++){
        //     int n = i;
        //     int sum = 0;
        //     int digits = 1;
        //     if (n > 9) digits++;
        //     if (n > 99) digits++;

        //     while (n > 0){
        //         sum += Math.pow(n%10, digits);
        //         n /= 10;
        //     }
        //     if (i == sum) System.out.print(i+" ");
        // }

        



        sc.close();
    }
}
