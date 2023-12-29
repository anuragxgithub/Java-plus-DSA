public class P11_GG {
    public static void main(String[] args) {
        printPattern(5);
    }
    static void printPattern(int n) {
        int num = 1;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
}
//        for input 5
//        1
//        2 3
//        4 5 6
//        7 8 9 10
//        11 12 13 14 15