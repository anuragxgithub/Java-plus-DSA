/*
https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1?

Question :
Given an array arr of size n containing non-negative integers, the task is to divide
it into two sets S1 and S2 such that the absolute difference between their sums is 
minimum and find the minimum difference.
Input: N = 4, arr[] = {1, 6, 11, 5} 
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11


EXPLANATION WITH IMAGE IS GIVEN IN THIS PACKAGE _7_MinimumSumPartition.jpg ⭐⭐⭐
*/

package KnapSackClassics;

import java.util.Arrays;

public class _7_MinimumSumPartition {

    // TABULATION
    public static int tabulation(int[] arr, int n) {
        int total = Arrays.stream(arr).sum();

        boolean[][] dp = new boolean[n+1][(total/2)+1];  // total/2
        // initialization
        for(int i = 0; i < n+1; i++) {  // 0th col
            dp[i][0] = true;
        }
        // NOTE : Here we have to initialize 0th row to false also bcz if we do not have
        // any item to add so obviously we can't make it to the target sum
        // but in java already false values are present so not doing that
        // but dp[0][0] would be true from the 1st col 0th row start filling F
        // i items and j is target sum
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(arr[i-1] <= j && dp[i-1][j-arr[i-1]] == true) {  // if including it gives true update the dp array to true otherwise its already false
                    dp[i][j] = true;
                } else if(dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i <= (total/2); i++) {    // target/2 = (total/2)
            if(dp[n][i]) {  // possible subsets
                int s1 = i;         // subset sum1
                int s2 = total-i;   //subset sum2
               minDiff = Math.min(Math.abs(s1-s2), minDiff);
            }
        }
        return minDiff;
    }

    public static void main(String[] args) { 
        int[] arr = {1,6,11,5};
        int n = arr.length;
        System.out.println(tabulation(arr, n));

        // NOTE: ⭐⭐
        // PERFORM THIS USING TABULATION ONLY BECAUSE IT IS MORE INTUITIVE WITH
        // TABULATION APPRAOCH + IF YOU USE MEMOIZATION IT WILL GIVE WRONG RESULTS
        // BECUASE LOOK TABLE IS FILLED DIFFERENTLY IN MEMOIZATION.
    }













    static void print(boolean[][] dp) {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
