public class P_4 {
    public static void main(String[] args) {
        int rowEntered = 5;
        printPattern(rowEntered, 1, 1, rowEntered);
    }
    static void printPattern(int r, int c, int spaces, int rowEntered) {
        if(r<0) {           //base condition
            return;
        }
        if(spaces <= rowEntered-r) {
            System.out.print(" ");
            printPattern(r,c,spaces+1, rowEntered);
        } else if(c <= (2*r)-1) {
            System.out.print("*");
            printPattern(r, c+1, spaces, rowEntered);
        } else {
            System.out.println();
            printPattern(r-1, 1, 1,rowEntered);
        }
    }
}
