public class NKnights {
    public static void main(String[] args) {
        int n = 4;   //size of board
        int knights = 4;
        boolean[][] board = new boolean[n][n];
        knights(board, 0,0, knights);
    }

    static void knights(boolean[][] board, int row, int col, int knightsLeft) {
        if (knightsLeft == 0) {
            display(board);
            System.out.println();
            return;
        }
        if (row == board.length - 1 && col == board.length) {
            //just skip or return nothing when the col go out of index for last row just end there now no need to increase the row.
            return;
        }

        if (col == board.length) {
            // increment the row now
            knights(board, row+1, 0, knightsLeft);
            return;
        }

        //placing knights
        if (isSafe(board, row, col)) {
            board[row][col] = true; // knight placed
            knights(board, row, col+1, knightsLeft-1);
            board[row][col] = false;  //undoing the changes.
        }
        knights(board, row, col + 1, knightsLeft);  //in case not safe so skip that col without doing anything

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //the below four conditions check the move of knight is in board or not and if in board
        //then whether that position is already taken or not.
        //obviously we don't need to check below of the present row b/z no knight will be present there.

        if(isValid(board, row-2, col+1)) {
            if(board[row-2][col+1]) {
                return false;
            }
        }
        if(isValid(board, row-2, col-1)) {
            if(board[row-2][col-1]) {
                return false;
            }
        }
        if(isValid(board, row-1, col+2)) {
            if(board[row-1][col+2]) {
                return false;
            }
        }
        if(isValid(board, row-1, col-2)) {
            if(board[row-1][col-2]) {
                return false;
            }
        }
        return true;
        }

    private static boolean isValid(boolean[][] board, int row, int col) {
        //to prevent repeated checking the move is in bound or not that's why created this method.
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }


    private static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean element : arr) {
                if(element) {
                    System.out.print("K ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}

// ⭐⭐⭐<<<<<<<<<<<<<<<THIS IS THE CODE TO RETURN THE TOTAL NUMBER OF POSSIBLE OUTCOMES..>>>>>>>>>>>>>>>>>>⭐⭐⭐


//public class NKnights {
//    public static void main(String[] args) {
//        int n = 4;   // size of board
//        int knights = 4;
//        boolean[][] board = new boolean[n][n];
//        int count = knights(board, 0, 0, knights);
//        System.out.println("Total possible outcomes: " + count);
//    }
//
//    static int knights(boolean[][] board, int row, int col, int knightsLeft) {
//        if (knightsLeft == 0) {
//            display(board);
//            System.out.println();
//            return 1; // Return 1 to represent a valid solution
//        }
//        if (row == board.length - 1 && col == board.length) {
//            return 0; // Return 0 as there are no more valid solutions from this point
//        }
//
//        if (col == board.length) {
//            return knights(board, row + 1, 0, knightsLeft);
//        }
//
//        int total = 0;
//        if (isSafe(board, row, col)) {
//            board[row][col] = true;
//            total += knights(board, row, col + 1, knightsLeft - 1);
//            board[row][col] = false;
//        }
//        total += knights(board, row, col + 1, knightsLeft);
//        return total;
//    }
//
//    private static boolean isSafe(boolean[][] board, int row, int col) {
//        if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1]) {
//            return false;
//        }
//        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) {
//            return false;
//        }
//        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) {
//            return false;
//        }
//        if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2]) {
//            return false;
//        }
//        return true;
//    }
//
//    private static boolean isValid(boolean[][] board, int row, int col) {
//        return row >= 0 && row < board.length && col >= 0 && col < board.length;
//    }
//
//    private static void display(boolean[][] board) {
//        for (boolean[] arr : board) {
//            for (boolean element : arr) {
//                if (element) {
//                    System.out.print("K ");
//                } else {
//                    System.out.print(". ");
//                }
//            }
//            System.out.println();
//        }
//    }
//}

