/*
https://leetcode.com/problems/longest-increasing-subsequence/

Que: What is increasing subsequence ??
Ans: Subsequence in which elements are in increasing order.
     Note: relative order remains same.
     Only unique elements are allowed.

Approach:
1. Create an array by removing the duplicate elements from original array if any.
2. Sort the newly created array arr2. Becuase we want increasing subsequence.
2. Now we have two array now simply find length lcs(longest common subsequence b/w arr1 & arr2).
 
*/

package LCS_Classics;

import java.util.Arrays;
import java.util.HashSet;


public class LIS {

    // ----------   MEMOIZATION   ------------ //
    public static int lcsMem(int[] arr1, int[] arr2, int i, int j, Integer[][] dp) {
        if(i == arr1.length || j == arr2.length) return 0;

        if(dp[i][j] != null) return dp[i][j];

        // 3 choices
        if(arr1[i] == arr2[j]) {
            return dp[i][j] = 1 + lcsMem(arr1, arr2, i+1, j+1, dp);
        }

        int op1 = lcsMem(arr1, arr2, i+1, j, dp);
        int op2 = lcsMem(arr1, arr2, i, j+1, dp);

        return dp[i][j] = Math.max(op1, op2);
    }

    public static int lisMem(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        // put items in set
        for(int n : arr) set.add(n);
        // put "unique" items from set to new array
        int arr2[] = new int[set.size()];
        int idx = 0;
        for(int n : set) arr2[idx++] = n;

        Integer[][] dp = new Integer[arr.length][arr2.length];
        Arrays.sort(arr2);
        // now call lcs method for two arrays
        return lcsMem(arr, arr2, 0, 0, dp);
    }

    // -------------   TABULATION ----------------//   
    public static int lcsTab(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[][] dp = new int[n+1][m+1];
        // base cases are already initialized with 0
        for(int i = 1; i <= n; i++) {      // represent idx of for arr1
            for(int j = 1; j <= m; j++) {  // represent idx of for arr2
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    // we have two choices now after the first one
                    int op1 = dp[i-1][j];  // reduce search area of arr 1
                    int op2 = dp[i][j-1];  // reduce search area of arr 2
                    dp[i][j] = Math.max(op1, op2);
                }
            }
        }
        return dp[n][m];
    }
    public static int lisTab(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        // put items in set
        for(int n : arr) set.add(n);
        // put "unique" items from set to new array
        int arr2[] = new int[set.size()];
        int idx = 0;
        for(int n : set) arr2[idx++] = n;

        Arrays.sort(arr2);
        // now call lcs method for two arrays
        return lcsTab(arr, arr2);
    }


    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        System.out.println(lisMem(arr));

        System.out.println(lisTab(arr));


    } 
}