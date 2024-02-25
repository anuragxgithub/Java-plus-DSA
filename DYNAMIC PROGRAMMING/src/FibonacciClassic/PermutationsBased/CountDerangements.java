/*

https://www.codingninjas.com/studio/problems/count-derangements_873861?leftPanelTabValue=PROBLEM

See how the formula is derived.
*/

package FibonacciClassic.PermutationsBased;

public class CountDerangements {
    static final int MOD = (int)1e9+7;

	public static long memoization(int n, long[] dp) {
		if(n==1) return 0;
		if(n==2) return 1;

		if(dp[n] != -1) return dp[n];
 
		long ans = ((n - 1) * (memoization(n-1, dp) + memoization(n-2, dp))) % MOD;	   
		dp[n] = ans;
		return ans;
	}

	public static long tabulation(int n) {
		long[] dp = new long[n+1];
		if(n==1) return 0;
		if(n==2) return 1;
		dp[1] = 0;
		dp[2] = 1;

		for(int i = 3; i <= n; i++) {
			// dp[i] = (((i-1) * dp[i-1]) + dp[i-2])%MOD;
			dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % MOD;
		}
		return dp[n];
	}
	public static long countDerangements(int n) {
		// long[] dp = new long[n+1];
		// Arrays.fill(dp, -1);
		// return memoization(n, dp);
		return tabulation(n);
	}
}
