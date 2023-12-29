// Prime number
import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        boolean result = isPrime(num);
        System.out.println(result);
    }
    static boolean isPrime(int n) {
        if (n<=1) {
            return false;
        }
        int i = 2;
        while(i*i <= n) {
            if(n%i == 0) {
                return false;
            }
            i++;
        }
        return i * i > n;  // Return true if correct and false if not correct, u can also write it using if else but it would be lil bit lengthy
    }
}
