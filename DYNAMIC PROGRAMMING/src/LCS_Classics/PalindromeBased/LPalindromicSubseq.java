/*

https://leetcode.com/problems/longest-palindromic-subsequence/description/
we have to return the length of lps (longest palindromic subsequence).

Simple approach:
1. Since we have to reduce this question to lcs.
   We need the 2nd string. Our 2nd string will be reverse of original string.
2. Now find the length of lcs. Simple.
Eg : agbcba
     its LPS would be: abcba
     
    s1 = agbcba
    s2 = abcbga         (reverse of s1)
    lcs = abcba = ans
*/

package LCS_Classics.PalindromeBased;

public class LPalindromicSubseq {
    // MEMOIZATION
    public static int lcsMemo(String s1, String s2, int i, int j, Integer[][] dp) {
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];
        // 3 choices
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcsMemo(s1, s2, i+1, j+1, dp);
        }
        int op1 = lcsMemo(s1, s2, i+1, j, dp);
        int op2 = lcsMemo(s1, s2, i, j+1, dp);
        return dp[i][j] = Math.max(op2, op1);
    }

    // TABULATION
    public static int tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i =1; i<=n; i++) {
            for(int j =1; j<=m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1 = "agbcba";

        String s2 = new StringBuilder(s1).reverse().toString();
        System.out.println(tabulation(s1, s2));
    }
}
