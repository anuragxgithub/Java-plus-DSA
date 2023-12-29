import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Keep taking input from the user till user enters X or x
        Scanner sc = new Scanner(System.in);
        float result = 0;
        System.out.println("WELCOME TO CALCULATOR : Enter x or X to exit");
        while (true) {
            System.out.print("Enter the operator: ");
            char op = sc.next().trim().charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%') {
                // Input two numbers
                System.out.print("Enter two numbers : ");
                float num1 = sc.nextFloat();
                float num2 = sc.nextFloat();
                if (op == '+') {
                    result = num1+num2;
                }
                if (op == '-') {
                    result = num1-num2;
                }
                if (op == '*') {
                    result = num1*num2;
                }
                if (op == '/') {
                    if (num2 != 0) {
                        result = num1/num2;
                    }
                }
                if (op == '%') {
                    result = num1 % num2;
                }
            } else if (op == 'x' || op == 'X') {
                System.out.println("Thanks for using :)");
                break;
            } else {
                System.out.println("Invalid operator");
            }
            System.out.println("Answer is: " + result);
        }

    }
}
