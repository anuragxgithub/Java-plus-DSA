public class P13_GG {
    public static void main(String[] args) {
        printPattern(5);
    }
    static void printPattern(int n) {
        for (int row = 1; row <= n; row++) {
            for (char col = 'A'; col <= ('A'+n-row); col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
//            ABCDE
//            ABCD
//            ABC
//            AB
//            A