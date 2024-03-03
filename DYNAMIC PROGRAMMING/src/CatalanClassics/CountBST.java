/*

https://leetcode.com/problems/unique-binary-search-trees/

*/

package CatalanClassics;

public class CountBST {
    // memoization
    public static int catalanMemo(int n, int[] dp) {
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];

        int ans = 0;
        for(int i = 0; i <= n-1; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }
        return dp[n] = ans;
    }
    
    // tabulation
    public static int catalanTab(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                // Ci -> BST (i nodes)
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }
    public int numTrees(int n) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return catalanMemo(n, dp);
        return catalanTab(n);
    }
}
