/*

https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

*/

package KnapSackClassic.UnboundedKnapSack;

public class KnapSackWithDups {
    public static int memo(int[] val, int[] wt, int W, int n, int idx, Integer[][] dp) {
        if(W == 0) return 0;
        if(idx == n) return 0;
        if(dp[idx][W] != null) return dp[idx][W];
        // easy peasy same as subset with repetion we already learnt it
        int include = 0;
        if(W - wt[idx] >= 0) {
            include = val[idx] + memo(val, wt, W-wt[idx], n, idx, dp);  // we won't indcrease the idx here this is the only catch bcz we want to iclude the current val till max size
        }
        int exclude = memo(val, wt, W, n, idx+1, dp);
        
        return dp[idx][W] = Math.max(include, exclude); // max value/profit recieved
        
    }
    
    public static int tabu(int[] val, int[] wt, int n, int W) {
        int[][] dp = new int[n+1][W+1];
        // base case is already assigned with zeros dp[i][0]
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= W; j++) {
                int v = val[i-1];
                int w = wt[i-1];
                int include = 0;
                if(w <= j) {
                    include = v + dp[i][j-w]; // idx will remain same
                }
                int exclude = dp[i-1][j];
                dp[i][j] = Math.max(include, exclude);
            }
        }
        return dp[n][W];
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // Integer[][] dp = new Integer[N][W+1];
        // return memo(val, wt, W, N, 0, dp);
        return tabu(val, wt, N, W);
    }
}
