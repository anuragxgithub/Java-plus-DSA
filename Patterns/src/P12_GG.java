// NOTE WHILE SOLVING LETTERS PATTERN IMAGINE OF NUMBERS FIRST
import java.util.Scanner;
public class P12_GG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the rows: ");
        int n = sc.nextInt();
        printPattern(n);
    }
    static void printPattern(int n) {
        for (int row = 0; row < n; row++) {   // OR (char row = 65; row<= 65+n; row++)
            for (char col = 'A'; col <= 'A'+row; col++){ // OR (char col = 65; col<=row; col++)
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
//        A
//        A B
//        A B C
//        A B C D
//        A B C D E