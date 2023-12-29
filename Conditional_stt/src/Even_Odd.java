import java.util.InputMismatchException;
import java.util.Scanner;
public class Even_Odd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        try {
            int num = sc.nextInt();
            if (num % 2 == 0) {
                System.out.println("Even number");
            } else {
                System.out.println("Odd number");
            }
        } catch(InputMismatchException e) {
            System.out.println("Invalid input. Enter a valid number");
        }
        sc.close();
    }
}
