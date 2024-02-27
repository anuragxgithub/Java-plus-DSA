/*

https://leetcode.com/problems/maximal-square/
Note: Understanding Static Variables and Method Execution in Java

Scenario:

While solving a coding problem involving recursion and dynamic programming in Java, encountered unexpected behavior
when running multiple test cases consecutively.
The code worked correctly for a single test case but produced incorrect results when run alongside other test cases.
Issue:

Identified that the problem stemmed from the improper handling of a static variable within the code.
The static variable max retained its value across multiple method invocations, leading to incorrect results.
Lesson Learned:

In Java, static variables are shared across all instances of a class, retaining their value throughout the program's 
execution.
When dealing with static variables, ensure they are managed carefully, as they can lead to unexpected behavior if
not reset appropriately.
In this scenario, resetting the static variable max to its initial state before each test case resolved the issue.
Resolution:

Ensured that the max variable was reset to 0 at the beginning of each test case within the maxSquare method.
This prevented the carry-over of values between test cases and ensured correct results.
Key Takeaway:

Understanding the scope and behavior of variables, especially static ones, is crucial for writing bug-free an 
efficient Java code.
Proper variable management, including initialization and resetting, is essential for predictable program behavior,
particularly in scenarios involving multiple method calls or test cases.
*/


package KnapSackClassics;

public class MaximalSquareIMP {
    static int max = 0;
    
    // Memoization
    public static int memo(char[][] grid, int i, int j, int[][] dp) {
        if(i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        
        int right = memo(grid, i, j+1, dp);
        int diagonal = memo(grid, i+1, j+1, dp);
        int down = memo(grid, i+1, j, dp);
        
        if(grid[i][j] == '1') {
            int ans = 1 + Math.min(right, Math.min(diagonal, down));
            max = Math.max(max, ans);
            return dp[i][j] = ans;
        } else {
            return dp[i][j] = 0;
        }
    }
    // TABULATION
    public static int tabulation(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];

        for(int i = row-1; i >= 0; i--) {
            for(int j = col-1; j >= 0; j--) {
                int right = dp[i][j+1];
                int diagonal = dp[i+1][j+1];
                int down = dp[i+1][j];
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max*max;  // max possible sqaure
    }

    // find out the SPACE OPTIMIZATION appraoch

    public int maximalSquare(char[][] matrix) {
        max = 0;  // resetting the value of max for other testcases
        // int[][] dp = new int[matrix.length][matrix[0].length];
        // for(int[] arr : dp) Arrays.fill(arr, -1);
        // memo(matrix, 0, 0, dp);
        // return max*max;

        return tabulation(matrix);
    }
}