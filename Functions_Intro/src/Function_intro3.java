import java.util.*;
// Integer type function
public class Function_intro3 {
    public static void main(String[] args) {
        int num1, num2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        num2 = sc.nextInt();
        int ans = jod(num1, num2); // here num1 & num2 are ARGUMENTS
        System.out.println("Sum is : "+ans);
    }
    public static int jod(int x, int y) {
        int sum = x+y;
        return sum;
    }
}
