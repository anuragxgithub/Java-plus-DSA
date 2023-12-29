// PYRAMID
import java.util.Scanner;
public class P5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the rows: ");
        int n = sc.nextInt();
        printPyramid(n);
    }
    static void printPyramid(int n){
        for (int row = 1; row <= n; row++) {
            for (int spaces = 1; spaces <= (n - row); spaces++) {
                System.out.print("  ");
            }
                for (int col = 1; col <= (2 * row - 1); col++) {
                    System.out.print("*"+ " ");
            }
            System.out.println();
        }
    }
}
