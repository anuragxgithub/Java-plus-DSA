/*
https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1?

*/

package KnapSackClassic;

public class MinimumSumPartition {
    public static int tabulation(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][target+1];
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
            for(int j = 1; j < target+1; j++) {
                if(arr[i-1] <= j && dp[i-1][j-arr[i-1]] == true) {  // if including it gives true update the dp array to true otherwise its already false
                    dp[i][j] = true;
                } else if(dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i <= (target/2); i++) {
            if(dp[n][i]) {  // possible subsets
               minDiff = Math.min(target - (2*i), minDiff);
            }
        }
        return minDiff;
    }

    public int minDifference(int arr[], int n) { 
        int range = 0;
        for(int i = 0; i < n;i++) range += arr[i];
        return tabulation(arr, range);
    }
}
