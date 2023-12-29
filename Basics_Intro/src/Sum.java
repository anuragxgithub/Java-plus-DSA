//Sum of two numbers
import java.util.Scanner;
public class Sum {
    public static void main(String[] args) {
        Scanner inputt = new Scanner(System.in); // The variable of Scanner(here inputt) is used in future to take input
        System.out.println("Enter the first number : ");
        int num1 = inputt.nextInt();
        System.out.println("Enter the second number : ");
        int num2 = inputt.nextInt();
        int sum = num1+num2;
        System.out.println("The sum of given two numbers is : " + sum);

        System.out.println("Enter your age: ");
        int x = inputt.nextInt();
        System.out.println("Your age is : " + x);
    }

}