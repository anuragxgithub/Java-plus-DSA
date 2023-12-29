// *
// **
// ***
// ****
public class P_2 {
    public static void main(String[] args) {
        int rowEntered = 4;
        printPattern(1,1, rowEntered); // Use this method b/z you understand it well also it is the best way
        method2(4,1);
    }
    static void printPattern(int row , int col, int rowEntered) {
        if(row>rowEntered) {
            return;
        }
        if(col<=row) {
            System.out.print("*");
            printPattern(row,col+1, rowEntered);
        } else {
            System.out.println();
            printPattern(row+1, 1, rowEntered);
        }
    }
//---------------------------------------------------------------------------------------------------------------------//
    //THE OTHER APPROACH COULD BE USE OF FN CALLS WHEN THEY ARE GETTING REMOVED FROM STACK ONE BY ONE
    //Use debugger to understand 🌟🌟
    static void method2(int row, int col) {
        if(row == 0) {
            return;
        }
        if(col<= row) {
            method2(row,col+1);
            System.out.print("*");
        } else {
            method2(row-1, 1);
            System.out.println();
        }
    }
}

//The program uses a constant amount of memory for each recursive call, as it only stores the values of row and col.
//Since the program makes n*(n+1))/2 calls, the space complexity will be O(n^2).
//Overall, the time complexity of the program is O(n^2), and the space complexity is O(n^2).