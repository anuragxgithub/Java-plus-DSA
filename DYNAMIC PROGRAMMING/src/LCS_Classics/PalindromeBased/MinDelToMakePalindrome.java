/*
https://www.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1?

Question : Find the minimum number of delete operations required to make the given string 
a palindrome.

Eg:                           "agbcba"
        -Lets say we delete 3 chars then we have "bcb"          (3 del operations)  
        -Lets say we del 5 chars then we have "a"               (5 del operations)
        -Lets say we del 1 char then we have "abcba"            (1 del operation (min)) ANS.

So, if we observe, then we can infer that:
Length of subsequence is INVERSELY PROPORTIONAL to num of del operations.
Less num of deletions ->  max length of subsequence.

So, we can say that if we can find the LONGEST PALINDROMIC SUBSEQUENCE then we can easily
find the MINIMUM number of del operations required to make string palindrome.
Simply, subtract the length LPS with the length of original string.

(Why this is working ?? simple bcz of inverse relation in lps and deletion. If we have max
lps that means min deletions had taken place
OR IN LAYMAN
By taking the lps from the string we are seperating the palindromic part now we are left with
chars which are not forming the palindrome so simply remove them that many del operations are
needed.)
*/


package LCS_Classics.PalindromeBased;

public class MinDelToMakePalindrome {
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
