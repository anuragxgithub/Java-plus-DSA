public class P17_GG {
    public static void main(String[] args) {
        printPattern(5);
    }
    static void printPattern(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = n; col >= (n-row+1); col--) {
                System.out.print((char)('A'+col-1)+" ");
            }
            System.out.println();
        }
    }
}
//        E
//        E D
//        E D C
//        E D C B
//        E D C B A