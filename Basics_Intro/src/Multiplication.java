import java.util.Scanner;
public class Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float x, y;
        System.out.println("Enter the two numbers : ");
        x = sc.nextFloat();
        y = sc.nextFloat();
        float multi = x*y;
        System.out.println("Product is : " + multi);

        System.out.print("Enter your accurate weight : ");
        float z = sc.nextFloat();
        System.out.println("Your weight is : " + z);
    }
}
