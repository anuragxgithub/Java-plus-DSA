/*

FOLLOW UP OF DYCK PATHS.

Question : You are given n X's and n Y's. You have to find the numbe of ways in which
we can arrange them so that "AT ANY POINT" from the very beginning number of X's is 
always greater than or equal to number of Y's.
Eg: XY  - valid ✅
    XYYXX - invalid ❌    bcz see XYY at this point y is greater than the number of x
    XXYY - ✅

Or the question can be vice versa : But the ans will remain same.

https://www.geeksforgeeks.org/dyck-words-of-given-length/ ⭐

*/
package CatalanClassics;

public class DyckWords {
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
