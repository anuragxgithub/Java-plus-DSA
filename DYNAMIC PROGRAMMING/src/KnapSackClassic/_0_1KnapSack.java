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
        // This if else thing can take much lines you just put one if that way is better
        // saves writing extra code
    }

    // Time : O(n*W)
    public static int tabulation(int[] val, int[] wt, int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1]; // rows representing items and cols wts
        // each idx coordinate of dp will store the max value we can carry at given constraint
        // eg at dp[3][5] max value would be stored of having 3 items and wt limit is 5.
        // similarly every possible combination of values would be stored for n items within wt of W

        // initialization
        for(int i = 0; i < dp.length; i++) { // 0th col (what if there is no item max profit would be 0)
            dp[i][0] = 0;
        }
        for(int i = 0; i < dp[0].length; i++) { // 0th row (what if W(capacity) is zero) max profit would be 0
            dp[0][i] = 0;
        }

        for(int i = 1; i < dp.length; i++) {     // i represents items
            for(int j = 1; j < dp[0].length; j++) {  // j represents wts from 0, 1 to W
                int v = val[i-1];  // ith item value (why i-1 ? bcz see here loop starting from 1 so its actual position in val array is i-1
                int w = wt[i-1];   // ith item wt 
                if(w <= j) {   // valid
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {  // invalid
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
        /*
         * Here for every item all possible values of wt is given.
         * Eg: 1st row of dp indicates max values possible when wt is 1,2,3...W
         */
    }
    public static void print(int[][] dp) {
        for(int i = 0; i < dp.length;i++) {
            for(int j = 0; j < dp[0].length;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7;
        // ans should be : 75

        int[][] dp = new int[val.length][W+1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(memoization(val, wt, W, 0, dp));  // here we are starting from idx 0 so ans in the dp would be at 0th row and 7th col
        print(dp);

        System.out.println(tabulation(val, wt, W));
    }
}
// https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?