package FibonacciClassic;

import java.util.HashMap;
public class MinCoins {

    public static int minCoins(int[] coins, int amount, HashMap<Integer, Integer> memo) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;

        int minCoins = -1;

        if(memo.containsKey(amount)) return memo.get(amount);

        for(int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minCoins(coins, subAmount, memo);
            if(subCoins != -1) {
                int numCoins = subCoins+1;
                if(numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }
        }
        memo.put(amount, minCoins);
        return minCoins;
    }

    public static void main(String[] args) {
        // Follow up of SumPossible.java
        int[] coins = {1,2,3,13};
        int amount = 15;
        /*
        Find out the minimum number of coins required to make the given amount
        you can use any coins as many times as you want
        */

        System.out.println(minCoins(coins, amount, new HashMap<Integer, Integer>()));
    }
}
//Tip: first try brute force recursion and then memoize it.