
/*
https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
Recommended : Use tabulation appraoch
*/
package LCS_Classics;

public class LongestCmnSubstr {
    // MEMOIZATION 1
    public static int memo(String s1, String s2, int i, int j, Integer[][] dp) {
        if(i == 0 || j == 0) return dp[i][j] = 0;
        if(dp[i][j] != null) return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            return dp[i][j] = 1 + memo(s1, s2, i-1, j-1, dp);
        } else {
            return dp[i][j] = 0;
        }
    }
    
    static int ans = 0;
    // MEMOIZATION 2
    public static int memo2(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int common = 0;
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            common = 1 + memo2(s1, s2, i - 1, j - 1, dp); // we don't need to carry the max
            // length here we want consecutive common chars
        }
        ans = Math.max(ans, common);
        memo2(s1, s2, i - 1, j, dp);
        memo2(s1, s2, i, j - 1, dp);
        return dp[i][j] = common;
    }
    
    
    // TABULATION
    public static int tabulation(String s1, String s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        int lcs = 0;
        // base cases is already initialized with zeros
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    lcs = Math.max(lcs, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return lcs;
    }
    
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // MEMOIZATION 1
        // int max = 0;
        // Integer[][] dp = new Integer[n+1][m+1];
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= m; j++) {
        //         int res = memo(S1, S2, i, j, dp);
        //         max = Math.max(max, res);
        //     }
        // }
        // return max;
        
        // MEMOIZATION 2
        // Integer[][] dp = new Integer[n+1][m+1];
        // ans = 0;   // resetting the global variable for other test cases
        // memo2(S1, S2, n, m, dp);
        // return ans;
        
        // TABULATION
        return tabulation(S1, S2, n, m);
    }
}
// https://www.geeksforgeeks.org/problems/longest-repeating-and-non-overlapping-substring3421/1
// H.W.