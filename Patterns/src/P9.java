public class P9 {
    public static void main(String[] args) {
        printPattern(6);
    }
    static void printPattern(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = row; col >= 1; col--) {
                if(col%2==0) {
                    System.out.print(0);
                } else {
                    System.out.print(1);
                }
            }
            System.out.println();
        }
    }
}
//        1
//        01
//        101
//        0101
//        10101
//        010101
