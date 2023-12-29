//NOTE: if you know the concept you can easily code this. EasyPeasy!.
//NOTE: whenever our base condition hits that means we can conclude that we found our one of the answers.
//Not Solved  Yet. ⭐⭐
public class Two_Queens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0, 0,2) + " different times we can place the queens.");
    }

    static int queens(boolean[][] board, int row, int col, int queensLeft) {
        if (queensLeft == 0) { //base condition b/z after the last row we can't put more queens.
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        //placing the queen and checking for every row and column.
        for (int i = row; i < board.length; i++) {
            for (int j = col; j < board.length; j++) {
                if (isSafe(board, i, j)) {
                    board[i][j] = true;
                    if(j<board.length-1) {
                        count += queens(board, i,j+1, queensLeft - 1);
                    } else {
                        count += queens(board, i+1, 0, queensLeft - 1);
                    }
                    board[i][j] = false; // undoing what we've done previously after the work is done (backtracking)
                }
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
