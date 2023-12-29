//INVERTED PYRAMID
public class P6 {
    public static void main(String[] args) {
        //Enter number of rows
        printPattern(5);
    }
    static void printPattern(int n){
        for (int row = n; row >= 1; row--) {
            for (int spaces = 1; spaces <= (n-row) ; spaces++) {
                System.out.print(" ");
            }
                for (int col = 1; col <= (2*row-1); col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
