
/*
https://leetcode.com/problems/edit-distance/description/
*/
package LCS_Classics;

public class EditDistance {
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
        int replace = 1 + memo(word1, word2, n-1, m-1, dp);

        return dp[n][m] = Math.min(insert, Math.min(delete, replace));
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
                    int replace = 1+ dp[i+1][j+1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        print(dp);
        return dp[0][0];
        // You can do both approaches memo. and tabul. by starting from idx 1
    }


    public static int minDistance(String word1, String word2) {
        // int n = word1.length();
        // int m = word2.length();
        // int[][] dp = new int[n+1][m+1];
        // for(int[] arr : dp) Arrays.fill(arr, -1);
        // return memo(word1, word2, n, m, dp);

        return tabulation(word1, word2);
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));

    }



    static void print(int[][] dp) {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
