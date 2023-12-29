public class Swastik {
    public static void main(String[] args) {
        //for odd numbers only obvious
        printPattern(11);
    }
    static void printPattern(int n) {
        int mid = (n+1)/2;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if(row==1 && col>mid || col==1 && row<mid || col==mid && row<=n || row==mid && col<=n || col==n && row>mid || row==n && col<mid) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
