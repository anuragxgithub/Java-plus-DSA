/*
https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1

Q) Given an array, count all the possible subsets (two subsets after partition) whose diff
   comes out to be the diven "diff". Basically divide the array into two subsets
   whose difference come out to equal to given diff. Count all such subsets possible.
   Eg: [1,1,2,3]  diff = 1
   Ans: 3
   Explanation : 
   [1,1,2] - [3]
   [1,3] - [1,2]
   [1,3] - [1,2]  // bcz there is 2 different 1
   s1 = (diff + sum(arr))/2     subset sum1
   s2 = (s1-diff)
   So, Number of "subsets whose sum is equal to s1" or you can use s2 but we will use s1
   in our ans.
   It would be good if you can just take a look of PartitionWithEqualSum. (Not necessary).

   EXPLANATION WITH IMAGE IS PRESENT IN THIS PACAKGE ⭐⭐⭐
*/
package KnapSackClassics;

import java.util.Arrays;

public class _5_PartitionWithGiveDiff {
    static final int MOD = (int)1e9 + 7;

    // Memoization
    public static int memoization(int[] arr, int sum, int idx, int[][] memo) {
        if(sum == 0 && idx == arr.length) return 1;
        if(idx == arr.length) return 0;
        
        if(memo[idx][sum] != -1) return memo[idx][sum];

        int include = 0;
        if(sum - arr[idx] >= 0) {
            include = memoization(arr, sum-arr[idx], idx+1, memo) % MOD;
        }
        int exclude = memoization(arr, sum, idx+1, memo) % MOD;

        return memo[idx][sum] = (include + exclude) % MOD;
    }

    // Tabulation
    public static int tabulation(int[] arr, int diff, int n) {
        int total = Arrays.stream(arr).sum();

        if(Math.abs(diff) > total) System.out.println(0);
        if((diff+total) % 2 == 1) System.out.println(0);

        int sum = (diff+total)/2;   // "sum" is sum of subset1

        int[][] dp = new int[n+1][sum+1];

        // initialization
        for(int i = 0; i < n+1; i++) {  // 0th col with value 1 bcz we always have empty subset whose sum is 0
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= sum; j++) { //NOTE: HERE WE HAVE TO START J WITH 0⭐⭐⭐ becuase wht if array elment contains 0 in it then there logically at 0th item and target = 0 count should be 2 dry run for {1,0} to understand this 
                int v = arr[i-1];
                if(v <= j) {
                    dp[i][j] = (dp[i-1][j-v] + dp[i-1][j]) %MOD;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int diff = 1;

        int sumArray = 0;
        for(int e : arr) sumArray += e;

        // base cases
        if(Math.abs(diff) > sumArray) System.out.println(0);
        if((diff+sumArray) % 2 == 1) System.out.println(0); // odd value not possible to get a subset whose sum is in decimal

        int sum = (diff + sumArray)/2;   // "sum" is sum of subset1

        int[][] memo = new int[arr.length][sum+1];
        for(int i = 0; i < arr.length; i++) Arrays.fill(memo[i], -1);

        // now your job is to find the number of subsets present whose sum is "sum"
        // that is our ans.
        System.out.println(memoization(arr, sum, 0, memo));


        // tabulation
        System.out.println(tabulation(arr, diff, arr.length));
    }
}
