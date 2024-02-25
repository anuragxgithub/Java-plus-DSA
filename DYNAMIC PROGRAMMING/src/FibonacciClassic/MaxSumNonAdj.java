/*

https://www.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1
*/

package FibonacciClassic;

import java.util.Arrays;

public class MaxSumNonAdj {
    // Memoization
    public static int memoization(int[] arr, int n, int idx, int[] memo) {
        if(idx >= n) return 0;
        if(memo[idx] != -1) return memo[idx];
        
        int include = arr[idx] + memoization(arr, n, idx+2, memo);
        int exclude = memoization(arr, n, idx+1, memo);
        
        return memo[idx] = Math.max(include, exclude);
        
    }
    
    // Tabulation
    public static int tabulation(int[] arr, int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = arr[0];
        
        for(int i = 2; i <= n; i++) {
            int include = arr[i-1] + dp[i-2];
            int exclude = dp[i-1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[n];
    }
    
    
    int findMaxSum(int arr[], int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        // return memoization(arr, n, 0, memo);
        return tabulation(arr, n);
    }
}
