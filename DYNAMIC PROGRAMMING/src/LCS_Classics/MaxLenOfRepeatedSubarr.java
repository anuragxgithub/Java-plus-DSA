/*
https://leetcode.com/problems/maximum-length-of-repeated-subarray/
*/

package LCS_Classics;

public class MaxLenOfRepeatedSubarr {
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
        return tabulation(nums1, nums2, nums1.length, nums2.length);
    }
}
