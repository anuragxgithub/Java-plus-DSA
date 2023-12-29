public class P10_GG {
    public static void main(String[] args) {
        //user se inout lelo rows ka.
        printPattern(5);
    }
    static void printPattern(int n) {
        for (int row = 1; row <= n; row++) {
            for (int c = 1; c <= row; c++) {
                System.out.print(c+" ");
            }
            for (int spaces = 1; spaces <= (n - row) * 2; spaces++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
//        1                 1
//        1 2             2 1
//        1 2 3         3 2 1
//        1 2 3 4     4 3 2 1
//        1 2 3 4 5 5 4 3 2 1