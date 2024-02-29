/*

https://leetcode.com/problems/longest-palindromic-substring/description/

The idea is to check for all possible substring  and if we got a substring which is
palindromic we will store that this from which idx to which idx it is palindromic so we don't
need to calculate it again and again.

NOTE :
THERE IS OTHER APPROACHES TOO FOR THIS PROBLEM LIKE.
H.W. IS :
1 - IMPLEMENT BRUTE FORCE (check for each possible substring whether palindrome or not?
    return the max length palindrom.)
    WE FURTHER OPTIMISE THIS USING MEMOIZATION which we did below.
2 - USING TWO POINTER WE CAN FURTHER IMPROVE THE MEMOIZATION CODE. IMPLEMENT AND LEARN IT TOO.

*/

package LCS_Classics.PalindromeBased;

public class LPalindromicSubstr {
    // MEMOIZATION   O(n^2)
    public static boolean memo(String s, int l, int r, Boolean[][] dp) {
        if(l >= r) return true;

        if(dp[l][r] != null) return dp[l][r];

        if(s.charAt(l) == s.charAt(r)) {
            return dp[l][r] = memo(s, l+1, r-1, dp);
        }
        return dp[l][r] = false;
    }

    // TABULATION   (Same as memo appraoch)   O(n^2)
    public static String tab(String s, int n) {
        boolean[][] dp = new boolean[n][n];
        int startingIdx = 0;
        int  maxlen = 1;
        int endIdx = 0;
        
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;        // INITIALIZATION (bcz single char is a palindrome itself)
            for(int j = 0; j < i; j++) {
                if(s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if((i-j)+1 >  maxlen) {
                        maxlen = (i-j)+1;
                        startingIdx = j;
                        endIdx = i;
                    }
                }
            }
        }

        return s.substring(startingIdx, endIdx+1);
    }

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        // base case 
        if(s.length() <= 1) System.out.println(s);

        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        int maxlen = 1;     // represents ending idx of substring
        int startingIdx = 0;
        // trying for all possible (substrings)
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(memo(s, i, j, dp)) {   // true, if palindrome exist from substring idx i to j
                    if((j-i)+1 > maxlen) {
                        startingIdx = i;
                        maxlen = (j-i)+1;
                    }
                }
            }
        }
        System.out.println(s.substring(startingIdx, maxlen+1));

        System.out.println(tab(s, n));
    }
}
