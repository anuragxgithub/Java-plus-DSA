import java.util.Scanner;

public class P4_GG {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row: ");
        int n = sc.nextInt();
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(row);
            }
            System.out.println();
        }
    }
}
//        1
//        22
//        333
//        4444
//        55555