package FibonacciClassic;

import java.util.Arrays;

public class CoinChange {
    // Appraoch 1 : MEMOIZATION (TOP-DOWN)
    public static int minCoins(int[] coins, int amount, int[] memo) {
        if(amount == 0) return 0;
        if(memo[amount] != -1) return memo[amount];

        int minCoins = 100010;
        for(int i = 0; i < coins.length; i++) {
            if(amount - coins[i] >= 0) {
                minCoins = Math.min(1 + minCoins(coins, amount-coins[i], memo), minCoins); // because at every step you are taking 1 coin
            }
        }
        memo[amount] = minCoins;
        return minCoins;
    }

    // Appraoch 2 : TABULATION (BOTTOM-UP)
    // Create an array dp of size amount + 1, where dp[i] will represent the minimum number of
    // coins needed to make up the amount i.
    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // initialization
        Arrays.fill(dp, amount+1);   // Initialize dp array with a value greater than amount
        dp[0] = 0;   // because min coins required to make amount 0 is zero

        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    // Update dp[i] to the minimum of its current value and 1 + dp[i - coins[j]]
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        // If dp[amount] is still greater than amount, it means it was not possible to make up the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {5, 9, 11};   
        int amount = 17;
        
        int[] memo = new int[amount+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int result = minCoins(coins, amount, memo);
        System.out.println(result == 100010 ? -1 : result);

        System.out.println(minCoins(coins, amount));
    }
}
