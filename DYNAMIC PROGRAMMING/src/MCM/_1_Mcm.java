/*

SEE :
=> INTRO 1
=> INTRO 2
=> DRYRUN 
IAMGES PRESENT IN THIS PACKAGE

https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1


Tabulation code is less intuitive you can choose any either Tabulation or Memoization.
*/

package MCM;

import java.util.Arrays;

public class _1_Mcm {
    // RECURSIVE
    public static int mcmRec(int[] arr, int i, int j){
        if(i == j) return 0;   // single matrix case. So, cost of operation will be 0

        int ans = Integer.MAX_VALUE;
        for(int k=i; k <= j-1; k++) {
            int cost1 = mcmRec(arr, i, k);    //Ai...Ak => multiplication of matrices from Ai to Ak would be of size : (arr[i-1] x arr[k])
            int cost2 = mcmRec(arr, k+1, j);  //Ak+1...Aj => size : (arr[k] x arr[j])
            // we have cost of multiplication of left sub matrix and right sub matrix 
            // now our job is to find the cost of multiplication of both the matrices with each other
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(finalCost, ans);
        }
        return ans;
    }

    // MEMOIZATION
    public static int mcmMemo(int[] arr, int i, int j, int[][] dp) {
        if(i == j) return 0;     // single matrix case. So cost of operation will be 0
        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++) {
            int cost1 = mcmMemo(arr, i, k, dp);   //Ai...Ak => multiplication of matrices from Ai to Ak would be of size : (arr[i-1] x arr[k])
            int cost2 = mcmMemo(arr, k+1, j, dp); //Ak...Aj => .. size(arr[k] x arr[j])
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(finalCost, ans);
        }
        return dp[i][j] = ans;
    }

    // TABULATION   (Here instead of filling table traditionally from left to right this time we'll fill table diagonally)
    public static int mcmTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        // intialization 
        for(int i = 0; i < n; i++) {   
            dp[i][i] = 0;   // single matrix casee (cost of multiplication would be 0)
        }

        // bottom up
        for(int len = 2; len <= n-1; len++) {   // represent col of table
            for(int i = 1; i <= n-len; i++) {   // i represents rows for each len row is going till n-len
                int j = i+len-1;  // col for each row i at given length len
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k<=j-1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }
        print(dp);      // bottom half table is useless (b/z we can't multiply matrix 2 to matrix 1 ...) 
        return dp[1][n-1];
    }


    public static void print(int[][] dp) {
        for(int i = 0;i< dp.length; i++) {
            for(int j = 0;j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        int n = arr.length;

        // RECURSIVE
        System.out.println(mcmRec(arr, 1, n-1));

        // MEMOIZATION
        int[][] dp = new int[n][n];
        for(int[] a : dp) Arrays.fill(a, -1);
        System.out.println(mcmMemo(arr, 1, n-1, dp));


        System.out.println(mcmTab(arr));
    }
}
