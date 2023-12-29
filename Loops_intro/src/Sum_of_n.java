import java.util.Scanner;
// Sum of n natural number
public class Sum_of_n {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 1; i<=num; i++) {
            sum = sum+i;
        }
        System.out.println("Sum is: "+sum);
    }
}
