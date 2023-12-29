import java.util.Scanner;

public class P3 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row: ");
        int n = sc.nextInt();
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
//        1
//        12
//        123
//        1234
//        12345