// ****
// ***
// **
// *
public class P_1 {
    public static void main(String[] args) {
        printPattern(4,1);
    }
    static void printPattern(int row , int col) {
        if(row<1) {
            return;
        }
        if(col<=row) {
            System.out.print("*");
            printPattern(row,col+1);
        } else {
            System.out.println();
            printPattern(row-1, 1);
        }
    }
}
//The program uses a constant amount of memory for each recursive call, as it only stores the values of row and col.
//Since the program makes n*(n+1))/2 calls, the space complexity will be O(n^2).
//Overall, the time complexity of the program is O(n^2), and the space complexity is O(n^2).