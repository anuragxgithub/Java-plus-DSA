/*

SEE :
=> INTRO 1
=> INTRO 2
=> DRYRUN 
IAMGES PRESENT IN THIS PACKAGE

https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
*/

package MCM;

import java.util.Arrays;

public class Mcm {
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        int n = arr.length;

        // RECURSIVE
        System.out.println(mcmRec(arr, 1, n-1));

        // MEMOIZATION
        int[][] dp = new int[n][n];
        for(int[] a : dp) Arrays.fill(a, -1);
        System.out.println(mcmMemo(arr, 1, n-1, dp));
    }
}
