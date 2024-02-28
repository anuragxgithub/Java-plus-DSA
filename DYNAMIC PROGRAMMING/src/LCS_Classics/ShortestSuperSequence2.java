/*
https://leetcode.com/problems/shortest-common-supersequence/
 * Question: Print the SCS (Shortest Common Supersequence)
 * 
 * Follow up of:
 * - find length of scs (ShortestSuperSequence.java)     len(s1+s2)-lcs
 * - print the lcs
 * 
 * This time we print the append the common char in ans string as well as other
 * chars to becuase here we don't want only common rather every common char should be present 
 * in ans.
 */
package LCS_Classics;

public class ShortestSuperSequence2 {

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
                    ans.append(s1.charAt(i-1));
                    i--;
                } else {  // when (dp[i][j-1] > dp[i-1][j])
                    ans.append(s2.charAt(j-1));
                    j--;
                }
            }
        }
        // append the remaining chars form either of the string if any
        while(i > 0) {
            ans.append(s1.charAt(i-1));
            i--;
        }
        while(j > 0) {
            ans.append(s2.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();  // send the reversed string
    }
    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";

        System.out.println(tabulation(str1, str2));
    }
}
