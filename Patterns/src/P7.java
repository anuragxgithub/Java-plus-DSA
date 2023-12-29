// DIAMOND
public class P7 {
    public static void main(String[] args) {
        //input no of rows here.
        printDiamond(5);
    }
    static void printDiamond(int n){
        for (int row = 1; row <= n; row++) {
            for (int spaces = 1; spaces <= (n-row); spaces++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (row); col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int row = n; row >= 1; row--) {
            for (int spaces = 1; spaces <= (n-row); spaces++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (row); col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
