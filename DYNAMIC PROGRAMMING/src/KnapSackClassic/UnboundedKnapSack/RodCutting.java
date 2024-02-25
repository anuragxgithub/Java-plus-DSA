/*
https://www.geeksforgeeks.org/problems/rod-cutting0840/1?
reduce the size of rod by the length you cut it.
*/

package KnapSackClassic.UnboundedKnapSack;

public class RodCutting {
    // memoization
    public static int memo(int[] price, int n, int idx, Integer[][] dp) {
        if(idx == price.length) return 0;
        if(n == 0) return 0;
        if(dp[idx][n] != null) return dp[idx][n];
        
        // include
        int incl = 0;
        if(n - (idx+1) >= 0) {
            incl = price[idx] + memo(price, n-(idx+1), idx, dp);  // note do not increment idx value
        }
        int excl = memo(price, n, idx+1, dp);
        
        return dp[idx][n] = Math.max(incl, excl);
    }
    
    // tabulation
    public static int tabu(int[] price, int n) {
        int[][] dp = new int[n+1][n+1];
        // base cases already filled with 0s
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <= n; j++) {
                int val = price[i-1];
                if(i <= j) {   // here is already 1 based indexing
                    dp[i][j] = Math.max(val + dp[i][j-i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];   // exclude only
                }
            }
        }
        return dp[n][n];
    }
    public int cutRod(int price[], int n) {
        // Integer[][] dp = new Integer[price.length][n+1];
        // return memo(price, n, 0, dp);
        return tabu(price, n);
    }
}
