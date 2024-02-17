package KnapSackClassic;

import java.util.Arrays;

public class _0_1KnapSack {

    // TIME : O(n*W)
    public static int memoization(int[] val, int[] wt, int W, int idx, int[][] dp) {
        if(idx == val.length || W == 0) {
            return 0;
        }

        if(dp[idx][W] != -1) return dp[idx][W];

        // include and exclude thing only nothing new
        if(W - wt[idx] >= 0) {
            int ans1 = val[idx] + memoization(val, wt, W-wt[idx], idx+1, dp);  // including it
            int ans2 = memoization(val, wt, W, idx+1, dp);  // excluidng it

            dp[idx][W] = Math.max(ans1, ans2);
            return dp[idx][W];

        } else {  // not valid (if wt of current idx exceeds the limit exclude it)
            dp[idx][W] = memoization(val, wt, W, idx+1, dp);
            return dp[idx][W];
        }

    }


    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7;
        // ans should be : 75

        int[][] dp = new int[val.length+1][W+1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(memoization(val, wt, W, 0, dp));

    }
}
// https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?