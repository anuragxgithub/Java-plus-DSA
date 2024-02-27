/*
https://leetcode.com/problems/delete-operation-for-two-strings/
*/
package LCS_Classics;

public class DelOpOn2Strs {
    // MEMOIZATION
    public static int memo(String word1, String word2, int n, int m, Integer[][] dp) {
        if(n == 0) return m;  // m delete operations are required
        if(m == 0) return n;  // n delete operations are required
        if(dp[n][m] != null) return dp[n][m];

        if(word1.charAt(n-1) == word2.charAt(m-1)) {
            return dp[n][m] = memo(word1, word2, n-1, m-1, dp);
        }
        // delete char from word 1
        int ans1 = 1 + memo(word1, word2, n-1, m, dp);
        // delete char from word 2
        int ans2 = 1 + memo(word1, word2, n, m-1, dp);
        return dp[n][m] = Math.min(ans1, ans2);
    }

    // TABULATION
    public static int tabulation(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        // base case initialization
        for(int i = 0; i < m; i++) dp[n][i] = m-i;  //{dp[n][m] should be zero}
        for(int i = 0; i < n; i++) dp[i][m] = n-i;

        for(int i = n-1; i >= 0; i--) {   // representing chars of word1
            for(int j = m-1; j >= 0; j--) { // representing chars of word2
                if(word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    int del1 = 1 + dp[i+1][j];
                    int del2 = 1 + dp[i][j+1];
                    dp[i][j] = Math.min(del1, del2);
                }
            }
        }
        return dp[0][0];
    }

    public int minDistance(String word1, String word2) {
        // int n = word1.length();
        // int m = word2.length();
        // Integer[][] dp = new Integer[n+1][m+1];
        // return memo(word1, word2, n, m, dp);
        return tabulation(word1, word2);
    }
}
