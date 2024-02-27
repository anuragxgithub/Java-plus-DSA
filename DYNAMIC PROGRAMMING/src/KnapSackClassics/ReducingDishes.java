/*
https://leetcode.com/problems/reducing-dishes/
Easy peasy question.

NOTE: IDK WHY TABULATION IS NOT WORKING
Also space optimise it.

TIP: IF TABULATION IS NOT WORKING WITH 0 TO N START FROM N-0 (this is MoreEasy to transform
from memo to tabulation) but remember which row and col to use while initialization.
*/

package KnapSackClassics;

import java.util.Arrays;

public class ReducingDishes {
    // MEMOIZATION
    public static int memoization(int[] sat, int idx, int time, Integer[][] dp) {
        if(idx == sat.length) return 0;
        if(dp[idx][time] != null) return dp[idx][time];
        // include dish
        int include = sat[idx]*(time+1) + memoization(sat, idx+1, time+1, dp);
        // exlude dish
        int exclude = memoization(sat, idx+1, time, dp);

        return dp[idx][time] = Math.max(include, exclude);
    }

    // TABULATION 1 NOT WORKING
    public static int tabulation(int[] sat) {
        int n = sat.length;
        int[][] dp = new int[n+1][n+1];  //{idx, time}
        // base case is already initialized with zero

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int include = (sat[i-1] * j) + dp[i-1][j-1];
                int exclude = dp[i-1][j];
                dp[i][j] = Math.max(include, exclude);
            }
        }
        return dp[n][n];
    }
    // TABULATION 2 Working
    public static int tabulationn(int[] sat) {
        int n = sat.length;
        int[][] dp = new int[n+1][n+1];
        // base case is already initialized with zero

        for(int i = n-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                int include = (sat[i] * (j+1)) + dp[i+1][j+1];
                int exclude = dp[i+1][j];
                dp[i][j] = Math.max(include, exclude);
            }
        }
        return dp[0][0];
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        // Integer[][] dp = new Integer[satisfaction.length][satisfaction.length+1];
        // return memoization(satisfaction, 0, 0, dp);

        return tabulation(satisfaction);
    }
}
