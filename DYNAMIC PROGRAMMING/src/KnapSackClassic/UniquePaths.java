
/*
 * https://leetcode.com/problems/unique-paths/description/
 * In this case where we go down and right only no need to mark the visited path.
 * If you're traversing a matrix and are only allowed to move either down or right, you 
 * typically don't need to mark the paths you've visited. This is because you can't
 * revisit a cell you've already passed through since you're only moving down or right, 
 * never up or left. Each cell you reach will be unique along your path.
 */
package KnapSackClassic;

import java.util.Arrays;

public class UniquePaths {
    //Memoization time->O(m*n) space->O(m*n) +Stack extra sapace
    public static int totalPaths(int rows, int cols, int r, int c, int[][] dp) {
        if(r == rows-1 && c == cols-1) return 1;
        if(r >= rows || c >= cols) {
            return 0;
        }
        if(dp[r][c] != -1) return dp[r][c];

        int[] drow = {0, 1};
        int[] dcol = {1, 0};
        int count = 0;
        for(int i = 0; i < 2; i++) {  //will go down and right
            count = count + totalPaths(rows, cols, r + drow[i], c + dcol[i], dp);
        }
        dp[r][c] = count;
        return count;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] a : dp) Arrays.fill(a, -1);
        
        return (totalPaths(m, n, 0, 0, dp));
    }
}
