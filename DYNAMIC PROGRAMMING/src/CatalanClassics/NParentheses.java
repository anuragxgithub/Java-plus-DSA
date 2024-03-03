/*
Question : Given n pairs of parentheses return the total number of valid parentheses made.

DRY RUN IS GIVEN see there for clarity.
*/

package CatalanClassics;

import java.util.Arrays;

public class NParentheses {
    public static int catalanMemo(int n, int[] dp) {
        if(n == 0 || n== 1) return 1;
        if(dp[n] != -1) return dp[n];

        int ans = 0;
        for(int i = 0;i <= n-1; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }
        return ans;
    }

    public static int catalanTab(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += (inside * outside);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 3;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(catalanMemo(n, dp));
        System.out.println(catalanTab(n));
    }
}
