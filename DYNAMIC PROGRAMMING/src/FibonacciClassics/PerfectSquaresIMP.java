/*
 https://www.geeksforgeeks.org/problems/get-minimum-squares0538/1
 https://leetcode.com/problems/perfect-squares/description/

 SOLVED IT WITHOUT ANY HELP
 */
package FibonacciClassics;

import java.util.Arrays;

public class PerfectSquaresIMP {

    // MEMOIZATION Time complexity: O(n*sqrt(n)) Space complexity: O(n)
    public static int memoization(int n, int[] dp) {
        if(n == 0) return 0;
        
        if(dp[n] != -1) return dp[n];
        
        int minCnt = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(i*i <= n) {
                minCnt =  Math.min(minCnt, 1 + memoization(n - (i*i), dp));
            }
        }
        dp[n] = minCnt;
        return minCnt;
    }

    // TABULATION  Time : O(n*sqrt(n)) Space : O(n)
    public static int tabulation(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // same to same copy pasted the recursive solution
        for(int i = 1; i <= n; i++) {     // here in represents n  (recursive calls)
            for(int j = 1; j*j <= i; j++) {  // j represents loop which we ran in memo. approach
                dp[i] = Math.min(dp[i], dp[i- (j*j)]+1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(memoization(n, dp));

        System.out.println(tabulation(n));
    }
}
