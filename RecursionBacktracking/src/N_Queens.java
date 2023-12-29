//NOTE: if you know the concept you can easily code this. EasyPeasy!.
//NOTE: whenever our base condition hits that means we can conclude that we found our one of the answers⭐
//For loop can be reduced in queens method by taking one more argument that is col and adding condition
//you can see this in NKnights problem.
public class N_Queens {
    public static void main(String[] args) {
        int n = 4;   //size of board
        boolean[][] board = new boolean[n][n];   //by default all false (0).
        System.out.println(queens(board, 0) + " different times we can place the queens.");
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) { //base condition b/z after the last row we can't put more queens.
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        //placing the queen and checking for every row and column.
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row , col)) {
                board[row][col] = true;     //placing queen
                count += queens(board, row+1);
                board[row][col] = false; // undoing what we've done previously after the work is done (backtracking) basically removing queen
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //checking vertical up
        for (int i = row-1; i >= 0; i--) {
            if(board[i][col]) {
                return false;
            }
        }
        //checking left diagonal  (r and c both decrease by 1 at every cell)
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }
        //checking right diagonal  (r decrease and c increase by 1 at every cell)
        int maxRight = Math.min(row, board.length-1-col);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]) {
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean element : arr) {
                if(element) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
