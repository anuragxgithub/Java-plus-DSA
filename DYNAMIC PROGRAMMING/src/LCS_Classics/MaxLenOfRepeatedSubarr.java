/*
https://leetcode.com/problems/maximum-length-of-repeated-subarray/
Recommended : Use tabulation appraoch
*/

package LCS_Classics;

public class MaxLenOfRepeatedSubarr {
    static int ans = 0;
    // MEMOIZATION 1
    public static int memo(int[] nums1, int[] nums2, int i, int j, Integer[][] dp) {
        if(i == 0 || j == 0) return dp[i][j] = 0;
        if(dp[i][j] != null) return dp[i][j];

        if(nums1[i-1] == nums2[j-1]) {
            return dp[i][j] = 1 + memo(nums1, nums2, i-1, j-1, dp);
        } else {
            return dp[i][j] = 0;
        }
    }

    // MEMOIZATION 2
    public static int memo2(int[] nums1, int[] nums2, int i, int j, Integer[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int common = 0;
        if (nums1[i-1] == nums2[j-1]) {
            common = 1 + memo2(nums1, nums2, i - 1, j - 1, dp);
        }
        ans = Math.max(ans, common);
        memo2(nums1, nums2, i - 1, j, dp);
        memo2(nums1, nums2, i, j - 1, dp);
        return dp[i][j] = common;
    }

    // TABULATION
    public static int tabulation(int[] nums1, int[] nums2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        int lcs = 0;
        // base cases is already initialized with zeros
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    lcs = Math.max(lcs, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return lcs;
    }
    public int findLength(int[] nums1, int[] nums2) {
        // MEMOIZATION 1
        // int n = nums1.length;
        // int m = nums2.length;
        // int max = 0;
        // Integer[][] dp = new Integer[n+1][m+1];
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= m; j++) {
        //         int res = memo(nums1, nums2, i, j, dp);
        //         max = Math.max(max, res);
        //     }
        // }
        // return max;

        // MEMOIZATION 2
        // int n = nums1.length;
        // int m = nums2.length;
        // Integer[][] dp = new Integer[n+1][m+1];
        // ans = 0;   // resetting the global variable for other test cases
        // memo2(nums1, nums2, n, m, dp);
        // return ans;

        // TABULATION
        return tabulation(nums1, nums2, nums1.length, nums2.length);
    }
}
