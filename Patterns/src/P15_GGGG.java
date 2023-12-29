public class P15_GGGG {
    public static void main(String[] args) {
        printPattern(5);
    }
    static void printPattern(int n){
        for (int row = 1; row <= n; row++) {
            for (int spaces = 1; spaces <= (n-row); spaces++) {
                System.out.print(" ");
            }
            for (char col = 'A'; col <= ('A'+row-1); col++) {
                System.out.print(col);
            }
            for (int c = row; c > 1; c--) {
                System.out.print((char)('A'+c-2));
            }
            System.out.println();
        }
    }
}
//             A
//            ABA
//           ABCBA
//          ABCDCBA
//         ABCDEDCBA
