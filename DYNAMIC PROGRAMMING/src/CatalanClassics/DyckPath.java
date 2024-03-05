/*

https://www.geeksforgeeks.org/problems/dyck-path1028/1

BASICALLY Question is :
Your goal is to reach from (n-1,0) to (0,n-1). You have to move in such a way that you
must have to always be above or equal to diagonal line from (n-1,0) to (0,n-1).
In this case if you observe then, at every point you numb of up movement should always be
greater than or equal to right movement to stay valid.

NOTE: There can be other variation too like you can be asked to always be below or qual to
the diagonal line the ans will remain same.

*/

package CatalanClassics;

public class DyckPath {
    // Memoization
    public static long catalanMemo(int n, Long[] dp) {
        if(n == 0 || n == 1) return 1;
        if(dp[n] != null) return dp[n];

        long ans = 0;
        for(int i = 0; i <= n-1; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }
        return dp[n] = ans;
    }
    // Tabulation
    public static long catalanTab(int n) {
        long[] dp = new long[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    
    static Long dyckPaths(int N) {
        // return catalanTab(N);
        return catalanMemo(N, new Long[N+1]);
    }
}
