import java.util.Scanner;
public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        System.out.println(isOdd(n));
    }
    static boolean isOdd(int n) {
        return (n&1)==1; //True when odd and false when true
    }
}