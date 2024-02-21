/*
 * this is follow up of subsetSumEqualsK problem where we only tell whether any subset with
 * sum k exists or not.
 * Here we will count such possible subsets.
 * 
 * https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
 */

package KnapSackClassic;

import java.util.Arrays;

public class SubsetSumEqualsKCnt {

    // memoization
    public static int memoization(int[] arr, int target, int idx, int[][] memo) {
        if(target==0 && idx == arr.length) return 1; // ⭐⭐⭐ important here return only when you reach the leaf node other wise some subsets will be left if u just return when target becomes 0
        if(idx == arr.length) return 0;
        
        if(memo[idx][target] != -1) return memo[idx][target];

        int count = 0;
        if(target - arr[idx] >= 0) {
            count += memoization(arr, target - arr[idx], idx + 1, memo);
        }
        count += memoization(arr, target, idx + 1, memo);
        
        return memo[idx][target] = count;
    }

    // tabulation
    public static int tabulation(int[] arr, int target, int n) {
        int[][] dp = new int[n+1][target+1];

        // initialization
        for(int i = 0; i < n+1; i++) {  // 0th col with value 1 bcz we always have empty subset whose sum is 0
            dp[i][0] = 1;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 0; j < target+1; j++) { //NOTE: HERE WE HAVE TO START J WITH 0⭐⭐⭐ becuase we need to consider empty set too {1,0} will have 2 subsets whose sum equls to 0
                int v = arr[i-1];
                if(v <= j) {
                    dp[i][j] = dp[i-1][j-v] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] arr = {1,0};   // including 2 items we can make 2 1s and 2 0s(empty subset)
        int target = 1;
        int n = arr.length;

        int[][] memo = new int[n][target+1];
        for(int[] m : memo) Arrays.fill(m, -1);

        System.out.println(memoization(arr, target, 0, memo));
        print(memo);

        System.out.println(tabulation(arr, target, n));
    }





    











    public static void print(int[][] dp) {
        System.out.println();
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}



