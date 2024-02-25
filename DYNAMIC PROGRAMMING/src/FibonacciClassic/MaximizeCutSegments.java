/*
Same as Coin change problem. Here max is needed.
*/

package FibonacciClassic;

import java.util.Arrays;

public class MaximizeCutSegments {
    // Memoization
    public static int memo(int n, int x, int y, int z, int[] dp) {
        if(n == 0) return 0;
        if(n < 0) return Integer.MIN_VALUE;
        if(dp[n] != -1) return dp[n];
        
        int cutX = 1 + memo(n-x, x, y, z, dp);
        int cutY = 1 + memo(n-y, x, y, z, dp);
        int cutZ = 1 + memo(n-z, x, y, z, dp);
        
        return dp[n] = Math.max(cutX, Math.max(cutY, cutZ));
    }
    // Tabultion
    public static int tabulation(int n, int x, int y, int z) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);  // since we want max so fill it with min value
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++) {  // i is representing n of memoization approach
            if(i-x >= 0) {
                dp[i] = Math.max(1+ dp[i-x], dp[i]);
            }
            if(i-y >= 0) {
                dp[i] = Math.max(1+ dp[i-y], dp[i]);
            }
            if(i-z >= 0) {
                dp[i] = Math.max(1+ dp[i-z], dp[i]);
            }
        }
        if(dp[n] < 0) return 0;  // no possible cuts at all
        return dp[n];
    }
    
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // int ans = memo(n, x, y, z, dp);
        // if(ans < 0) return 0;  // no possible cuts at all
        // return ans;
        
        return tabulation(n, x, y, z);
    }
}
