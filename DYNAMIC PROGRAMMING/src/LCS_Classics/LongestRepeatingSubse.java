/*

https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

Question: You need to find out the "length of longest subsequence" which repeates twice
          in given string's subsequence.
          If subsequence is stated that means you have to take care of the relative order of
          chars.
Eg : str = "aacbdxbd"
    subsequence "ac" is repeating twice  {1) a of idx 0; 2) a of idx 1}
    subsequence "abd" is repeating twice ({a,b,d} -> {0,3,4} & {a,b,d} -> {1,6,7})
    BUT THE LONGEST REPEATING SUBSEQUENCE IS "abd". So 3(its length) is our ans.

Appraoch:
Since we need to reduce it to simpler lcs problem
So we have to figure out the 2nd string. Second string will be the original string itself.

1) Now we have two strings. Both are same.
2) Now again we will find the subsequence of both the string BUT THE LITTLE TWEAK WILL BE:
   "that we won't consider same char if they are present on the same string in both string."

   Eg: 
   s1 = "aacbdxbd"
   s2 = "aacbdxbd"
   -> here we will take 'a' from 1st s1 idx 0 and 2nd 'a' from s2 idx 1 similarly,
   take b of idx 3 from s1 and b of s2 idx 6 and so on...

   THIS IS MAKING SURE THAT WE that all chars from subsequence is repeating again inside the
   string in relatively correct order. Simple.


*/

package LCS_Classics;

public class LongestRepeatingSubse {
    // Memo
    public static int lcsMemo(String s1, String s2, int i, int j, Integer[][] dp) {
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];

        //3 choices
        if(s1.charAt(i) == s2.charAt(j) && i != j) {   // this little change
            return dp[i][j] = 1 + lcsMemo(s1, s2, i+1, j+1, dp);
        }

        return dp[i][j] = Math.max(lcsMemo(s1, s2, i+1, j, dp), lcsMemo(s1, s2, i, j+1, dp));

    }

    // Tab
    public static int lcsTab(String s1, String s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        // base cases is already initialized with zeros

        for(int i = 1; i <= n; i++) {
            for(int j =1; j <=m;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1) && i != j) { // this little change
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "aacbdxbd";

        String s2 = s1;
        int n = s1.length();
        int m = s2.length();
        System.out.println(lcsMemo(s1, s2, 0, 0, new Integer[n][m]));
        System.out.println(lcsTab(s1, s2, n, m));
    }
}
