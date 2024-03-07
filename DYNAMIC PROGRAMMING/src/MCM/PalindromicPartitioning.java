/*
 

https://www.geeksforgeeks.org/problems/palindromic-patitioning4845/1

in the worst case n-1 cuts are needed.  (divide each char into single char)
 */

package MCM;

public class PalindromicPartitioning {
    public static boolean isPalindrome(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    // MEMOIZATION
    public static int mcmMemo(String s, int i, int j, Integer[][] dp) {
        if(i >= j) return 0;  // if string becomes empty so cuts needed

        if(dp[i][j] != null) return dp[i][j];

        if(isPalindrome(s, i, j)) {
            return 0;   // no need to cut it
        }

        int minCuts = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++) {  // why till j-1 bcz 2nd partitioning is from k+1
            int c1 = mcmMemo(s, i, k, dp);  // c1 => no of cuts
            int c2 = mcmMemo(s, k+1, j, dp);
            int tempAns = c1 + c2 + 1;
            minCuts = Math.min(tempAns, minCuts);
        }
        return dp[i][j] = minCuts;
    }

    public static void main(String[] args) {
        String str = "aaabba";
        // Output: 1
        // Explaination: The substrings after 1
        // partitioning are "aa" and "abba".
        int n = str.length();
        System.out.println(mcmMemo(str, 0, n-1, new Integer[n][n]));
    }
}
