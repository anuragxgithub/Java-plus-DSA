public class P20 {
    public static void main(String[] args) {
        printPattern(5);
    }
    static void printPattern(int n) {
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= n; col++) {
                if(row==1 || col==1 || row==n || col==n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
