/*
IMP: THIS IS CLASSICAL Problem and is of hard level. Don't worry if this comes in interview
you will be given 1 hr.
  
https://leetcode.com/problems/wildcard-matching/description/
Ques:
Given an input string (s) and a pattern (p), implement wildcard pattern matching with
support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Explore different possibility patiently it can be easily done.

*/

package LCS_Classics;

public class WildCardMatching {
    // TABULATION
    public static boolean tab(String s, String p, int n, int m) {
        boolean[][] dp = new boolean[n+1][m+1];

        // base cases Important
        // 1. if s is empty and p is also empty that means pattern is matching with string
        dp[0][0] = true;
        // 2. if pattern(p) is empty and string(s) is non empty then obviously pattern can't be matched
        // for(int i =1 ; i <= n; i++) dp[i][0] = false;  // but in java already filled

        // 3. IMP. If string is empty and pattern is non empty then pattern can be matched
        //    only when there is only '*' in pattern bcz we can treat them as empty subseqe.
        //    so for all dp[0][j] if jth char is '*' then check whether dp[0][j-1] is matching with
        //    string or not. If yes then fill true. For every other case fill 'False'
        for(int i = 1; i <= m; i++) {
            if(p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-1]; 
            } else { 
                dp[0][i] = false;    // bcz anyother can can't be tranformed into empty subseque.
            }  // pretty logical
        }

        // now lets fill the table
        for(int i = 1; i <= n; i++) {
            for(int j =1; j <=m; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    // reduce the search area/problem b/z chars are matching here
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*') {
                    // two options are available for us
                    // 1. either take this * as empty subsequence i will remain same but j will reduce
                    boolean ignoringStar = dp[i][j-1];
                    // 2. taking * as some sequence so that it can help us math the pattern with string
                    // so i will be reduces and j will remain same why j will remain same ??
                    // bcz it may be possible that we need that * for making other chars too why restricting to make only one char
                    boolean takingStar = dp[i-1][j];
                    dp[i][j] = takingStar || ignoringStar;   // whichever gives true
                } else {
                    dp[i][j] = false;    // for other cases like if chars do not match or any other problem occur
                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "*?";

        int n = s.length();
        int m = p.length();
        System.out.println(tab(s, p, n, m));
    }

    // You can think of its memoization if you want.













    public static void print(boolean[][] dp) {
        for(int i = 0; i< dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
