public class P14_GG {
    public static void main(String[] args) {
        printPattern(6);
    }
    static void printPattern(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print((char)('A' + row - 1)); // Type casting
            }
            System.out.println();
        }
        //<-----------OR------------>//
        for (int row = 0; row < n; row++) {
            char ch = (char)('A'+row);  // because we want to print the rows every time
            for (int col = 0; col <= row; col++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
//            A
//            BB
//            CCC
//            DDDD
//            EEEEE
//            FFFFFF

