package LCS_Classics;

public class LongestCmnSubstr {
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
        
        return tabulation(S1, S2, n, m);
    }
}
