public class X {
    public static void main(String[] args) {
        printPattern(5);
    }
    static void printPattern(int n) {
        for (int row = n; row > 1; row--) {
            for (int spaces = 1; spaces <= (n-row); spaces++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2*row-1); col++) {
                if(col==1 || col == (2*row-1)) { // border border ka sirf print hoga isse
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int row = 1; row <= n; row++) {
            for (int spaces = 1; spaces <= (n-row); spaces++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= (2*row-1); col++) {
                if(col==1 || col == (2*row-1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}