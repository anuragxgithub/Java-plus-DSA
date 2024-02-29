
/*
https://leetcode.com/problems/is-subsequence/description/
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

Find the lcs between two stirng if the lenght of lcs is equal to length of target 
subsequence string length then return true.
Why this is working ?? Think yourself.
 */
package LCS_Classics;

public class isSubsequence {
    public static int lcsTab(String s1, String s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    // Two choice either decrease the search area of s1 or s2
                    // 1 decreasing s.a. of s1 
                    int ans1 = dp[i-1][j];
                    // 1 decreasing s.a. of s2 
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        int lcsLen = lcsTab(s, t, s.length(), t.length());
        if(lcsLen == s.length()) {
            System.out.println("true");
        }
    }
}
// Two pointer approach is better.