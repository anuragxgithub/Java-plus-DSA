/*
https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1

 * Question is : Return the length of the shortest Supersequence.
 * Simple : length(Str1 + Str2) - length of lcs
 */

package LCS_Classics;

public class ShortestSuperSequence {
    // MEMOIZATION
    public static int lcsMemo(String s1, String s2, int i, int j, Integer[][] dp) {
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcsMemo(s1, s2, i+1, j+1, dp);
        }
        int op1 = lcsMemo(s1, s2, i+1, j, dp);
        int op2 = lcsMemo(s1, s2, i, j+1, dp);

        return dp[i][j] = Math.max(op1, op2);
    }
    
    // TABULATION
    public static int lcsTab(String s1, String s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        // base case is already initialize with zeros dp[i][0] and dp[0][i]

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <=m; j++) {
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
        String X = "abcd";
        String Y = "xycd";

        int n = X.length();
        int m = Y.length();

        int lengthOfLCS = lcsMemo(X, Y, 0, 0, new Integer[n][m]);
        System.out.println((n+m)-lengthOfLCS);
    }
}
