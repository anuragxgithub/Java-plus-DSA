/*

https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
*/
package LCS_Classics;

public class MinDelAndIn {
    /*
NOTE : HERE QUESTION CAN BE TWISTED. IT MAY BE POSSIBLE THAT YOU CAN BE 
ASKED TO TELL THE NUMBER OF "DELETE" AND "INSERT" OPERATIONS ARE REQUIRED
SEPERATELY. THIS WOULD BE SIMPLE.
IF YOU OBSERVE : THAT YOU HAVE ONLY 2 OPERATIONS TO PERFORM:
1. SIMPLY FIND THE LENGTH OF THE LCS IN BOTH THE STRING.
2. COMPARE THE LENGTH OF STR1 WITH THE LCS THE DIFFERENCE WOULD BE 
   "NUMBER OF DELETE OPERATIONS"
3. COMPARE THE LENGTH OF LCS WITH STR2 DIFF WOULD BE "NUMBER OF INSERT OPERATIONS".
See MinDelAndIn2.java
*/
    // MEMOIZATION
    public static int memo(String word1, String word2, int n, int m, int[][] dp) {
        if(n == 0) {  // word 1 becomes empty
            // we have to insert the remaining character from word2
            return m;  // num of operations = chars left in word2
        }
        if(m == 0) {  // word 2 becomes empty
            // we have to delete the remaining character from word1
            return n;  // num of operations = chars left in word1
        }
        if(dp[n][m] != -1) return dp[n][m];

        if(word1.charAt(n-1) == word2.charAt(m-1)) {
            return dp[n][m] = memo(word1, word2, n-1, m-1, dp);
        }
        // choices
        int insert = 1 + memo(word1, word2, n, m-1, dp);
        int delete = 1 + memo(word1, word2, n-1, m, dp);

        return dp[n][m] = Math.min(insert, delete);
    }

    // TABULATION
    public static int tabulation(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        // base case initialization
        // if word1 is empty we have to insert the remaining character from word2 to it
        for(int i = 0; i < m; i++) dp[n][i] = m - i;
        for(int i = 0; i < n; i++) dp[i][m] = n - i;  //{dp[n][m] should be zero}

        for(int i = n-1; i >= 0; i--) {       // represent idx for word1
            for(int j = m-1; j >= 0; j--) {  // represent idx for word2
                if(word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    // 3 choices
                    int insert = 1 + dp[i][j+1];
                    int delete = 1 + dp[i+1][j];
                    dp[i][j] = Math.min(insert, delete);
                }
            }
        }
        return dp[0][0];
        // You can do both approaches memo. and tabul. by starting from idx 1
    }

	public int minOperations(String str1, String str2) 
	{ 
	   // int n = str1.length();
	   // int m = str2.length();
	   // int[][] dp = new int[n+1][m+1];
	   // for(int[] arr : dp) Arrays.fill(arr, -1);
	   // return memo(str1, str2, n, m, dp);
	   return tabulation(str1, str2);
	}
}
