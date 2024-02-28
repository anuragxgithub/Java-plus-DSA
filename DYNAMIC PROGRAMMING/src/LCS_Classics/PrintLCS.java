
/*
 * Print the longest common subsequence.
 * Here we will leverage the table of tabulation appraoch.
 * 1. Fill the table with the length of longest common subsequence and after that use 
 * it to derive the actual lcs.
 */
package LCS_Classics;

public class PrintLCS {
    public static String tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        // base cases are already initialized with zeros

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] =  1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i = n, j = m;
        StringBuilder ans = new StringBuilder();
        while(i > 0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            } else {  // if char is not equal then go from where this cell is derived
                if(dp[i-1][j] > dp[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return ans.reverse().toString();  // send the reverse string
    }
    public static void main(String[] args) {
        String s1 = "abxcdg";
        String s2 = "abmzxcd";

        System.out.println(tabulation(s1, s2));
    }
}
