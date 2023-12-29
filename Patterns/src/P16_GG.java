public class P16_GG {
    public static void main(String[] args) {
        printPattern(5);
    }
    static void printPattern(int n) {
        for (int row = n; row >= 1; row--) {
            for (int col = row; col <= n; col++) {  // n will be 5,4,3,2,1
                System.out.print((char)('A'+col-1));
            }
            System.out.println();
        }
    }
}
//            E
//            DE
//            CDE
//            BCDE
//            ABCDE