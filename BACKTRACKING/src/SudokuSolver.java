public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(solver(board)) {
            display(board);
        } else {
            System.out.println("Sudoku can't be solved.");
        }
    }

    static boolean solver(int[][] board) {
        int n = board.length;
        int row = -1, col = -1;

        boolean emptyLeft = true;
        //this is how we are replacing row, col in from arguments.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            //if you find some empty element in row then break
            if (emptyLeft == false) {
                break;
            }
        }
        if (emptyLeft == true) {
            return true;
            //sudoku is solved.
        }

        //backtrack
        for (int number = 0; number <= 9; number++) {
            if(isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solver(board)) {
                    //found the answer
                    return true;
                } else {
                    //backtrack
                    board[row][col] = 0;
                }
            }
        }

        return false;   //sudoku can't be solved.
    }

    static boolean isSafe(int[][] board, int r, int c, int num) {
        //check if the number is in the row or not.
        for (int i = 0; i < board.length; i++) {
            if(board[r][i] == num) {
                return false;
            }
        }
        //check if the number is in the column or not.
        for (int[] nums : board) {
            if(nums[c] == num) {   // same column for different row
                return false;
            }
        }
        //check for the 3X3 matrix whether number present there or not
        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = r - r%sqrt;
        int colStart = c - c%sqrt;
        for (int i = rowStart; i < rowStart+sqrt; i++) {
            for(int j = colStart; j < colStart+sqrt; j++) {
                if(board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static void display(int[][] board) {
        for (int[] arr : board) {
            for(int nums : arr) {
                System.out.print(nums + " ");
            }
            System.out.println();
        }
    }
}
