/*
https://leetcode.com/problems/coin-change-ii/

Soo easy we already did same problem while learning recursion/backtracking.
SubsetWithRepetition.java

Here we can't do this lets say for making 5
3+2
2+3

Only one way is counted thats why subsets with repetion appraoch is choosen.
*/

package KnapSackClassic.UnboundedKnapSack;

public class CoinChange2 {
    // MEMOIZATION
    public static int memoization(int coins[], int amount, int idx, Integer[][] dp) {
        if(amount == 0) return 1;
        if(idx == coins.length) return 0;

        if(dp[idx][amount] != null) return dp[idx][amount];

        // do not include
        int exclude = memoization(coins, amount, idx+1, dp);
        // include (but we known we keep taking the current item till max size)
        // so don't increment idx
        int include = 0;
        if(amount - coins[idx] >= 0) {
            include = memoization(coins, amount-coins[idx], idx, dp);
        }
        return dp[idx][amount] = include+exclude;
    }
    
    // TABULATION
    public static int tabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0; i <= n; i++) {  // base case initialization
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= amount; j++) {
                int coin = coins[i-1];
                int exclude = dp[i-1][j];
                int include = 0;
                if(coin <= j) {
                    include = dp[i][j-coin];
                }
                dp[i][j] = include + exclude;
            }
        }
        return dp[n][amount];
    }
    // TABULATION SPACE OPTIMIZATION
    public static int tabulationSO(int[] coins, int amount) {
        return 0;
    }

    public int change(int amount, int[] coins) {
        // Integer[][] dp = new Integer[coins.length][amount+1];
        // return memoization(coins, amount, 0, dp);
        return tabulation(coins, amount);
    }
}
