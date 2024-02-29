/*

https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

SAME THING APPLY HERE TOO.
LIKE MIN DEL TO MAKE PALINDROME.
ans = s.length() - lps length;

Eg :     "mbadm"
    - LPS of mbadm would be   lcsOf(mbadm , mdabm) = mam
    - if we remove mam from the original string we will have b & d.
      And this is our answer if we insert b & d in original string we get the 
      palindromic string in minimum insertion. (mdbabdm).
(Why this is working ??  Bcz we are taking out the already palindromic part from original
string what we are left with now is chars that do not make palindrom so if we can 
add that many chars to the original string it would make the string palindrom :))
*/

package LCS_Classics.PalindromeBased;

public class MInInsertionToMakePalin {
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
    public static int lcsTab(String s1, String s2) {
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
        String s = "aebcbda";

        // simply follow the procedure of finding the LPS
        String s2 = new StringBuilder(s).reverse().toString();
        // int n = s.length();
        // int m = s2.length();
        // int lenLCS = lcsMemo(s, s2, 0, 0, new Integer[n][m]);
        int lenLCS = lcsTab(s, s2);
        System.out.println(s.length()-lenLCS);
    }
}
// 100% same as MinDelToMakePalindrome.java
// Bcz if we are left with chars which are not making palindrome remove it.
// and if we can only insert then insert that many chars to make them palindrom so same ans.