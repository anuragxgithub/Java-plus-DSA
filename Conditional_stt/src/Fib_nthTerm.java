import java.util.Scanner;
public class Fib_nthTerm {
    public static void main(String[] args) {
        int a = 0; // 1st term
        int b = 1; // 2nd term
        int c = 1;             // or 0 but i did 1 b/z if user enter 2nd term then 1 will be printed
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the term:");
        int n = in.nextInt();
        int count = 3; // b/z two terms are already taken

        while (count <= n) {
            c = a+b;
            a=b;
            b=c;
            count++;
        }
        System.out.println(n + "th term of fibonacci series is: "+c);
    }
}
