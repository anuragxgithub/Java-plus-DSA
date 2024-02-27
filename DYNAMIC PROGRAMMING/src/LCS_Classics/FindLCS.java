/*
https://leetcode.com/problems/longest-common-subsequence/
*/

package LCS_Classics;

public class FindLCS {
    // Memoization
    public static int memo(String s1, String s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            return 1 + memo(s1, s2, n-1, m-1, dp);
        }
        else {
            // Two choice either decrease the search area of s1 or s2
            // 1 decreasing s.a. of s1 
            int ans1 = memo(s1, s2, n-1, m, dp);
            // 1 decreasing s.a. of s2 
            int ans2 = memo(s1, s2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    //Tabulation
    public static int tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    // Two choice either decrease the search area of s1 or s2
                    // 1 decreasing s.a. of s1 
                    int ans1 = dp[i+1][j];
                    // 1 decreasing s.a. of s2 
                    int ans2 = dp[i][j+1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[0][0];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        if(n == 0 || m == 0) return 0;   // base case

        // int[][] dp = new int[n+1][m+1];
        // for(int[] arr : dp) Arrays.fill(arr, -1);
        // return memo(text1, text2, n, m, dp);

        return tabulation(text1, text2);
    }
}
