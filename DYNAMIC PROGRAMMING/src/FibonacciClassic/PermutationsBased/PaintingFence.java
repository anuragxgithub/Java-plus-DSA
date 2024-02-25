
/*

NOTE : 
1. Paint Fence is in premium question on leetcode.
2. THE TEST CASES ON GFG IS VERY KHATARNAK FOR JAVA USERS BECAUSE IT IS EVEN
   OVERFLOWING THE LONG DATA TYPE SO WE HAVE TO USE A LOT OF % EVERYWHERE TO PREVENT
   OVERFLOW. AND ALSO WE AT SOME PLACESWE NEED TO EVEN TYPE CAST IT TO LONG
   SO KEEP IN MY THE BRACKETS AND ALL.⭐⭐
3. BUT IT CAN BE EASILY PASSED ON CODING NINJAS AND LEETCODE.

Don't worry about the understand the concept which is used in the question.

You have to find out the recurrence relation using permutations.

https://www.geeksforgeeks.org/problems/painting-the-fence3727/1
*/
package FibonacciClassic.PermutationsBased;

public class PaintingFence {
    static final int MOD = 1000000007;
    
    // Memoization
    public static long memoization(int n, int k, long[] dp) {
        if (n == 1) return k;
        if (n == 2) return ((long) (k % MOD) * (k % MOD - 1) + k % MOD) % MOD;
        // the formula is (k*(k-1) + k) or (k+k*(k-1))  but rhs one is giving trouble on gfg
        
        if (dp[n] != -1) return dp[n];
        
        long ans = ((memoization(n - 2, k, dp) * (k - 1) % MOD) +
                    (memoization(n - 1, k, dp) * (k - 1) % MOD)) % MOD;
        
        return dp[n] = ans;
    }
    
    // tabulation
    public static long tabulation(int n, int k) {
        if (n == 1) return k;
        long[] dp = new long[n + 1];
        dp[1] = k;
        dp[2] = ((long) (k % MOD) * (k % MOD - 1) + k % MOD) % MOD;
    
        for (int i = 3; i <= n; i++) {
            long ans = ((dp[i - 2] * (k - 1)) % MOD + (dp[i - 1] * (k - 1)) % MOD) % MOD;
            dp[i] = ans;
        }
        return dp[n];
    }
    
    // TABULATION SPACE OPTIMIZATION
	public static long tabulationSO(int n, int k) {
		// since dp[i] has two dependencies dp[i-2] & dp[i-1]
		// so simply using two variables to store that
		if (n == 1) return k;

		// Initialize prev1 and prev2 to represent dp[i-1] and dp[i-2] respectively
		long prev2 = k;   // represents dp[i-2]            
		long prev1 = ((long) (k % MOD) * (k % MOD - 1) + k % MOD) % MOD; // represents dp[i-1]

		for (int i = 3; i <= n; i++) {
			long ans = ((prev2 * (k - 1)) % MOD + (prev1 * (k - 1)) % MOD) % MOD;
			// Update prev1 and prev2 for the next iteration
			prev2 = prev1;
			prev1 = ans;
		}
		return prev1;
	}
	
	
    long countWays(int n,int k)
    {
        // long[] dp = new long[n+1];
        // Arrays.fill(dp, -1);
        // return memoization(n, k, dp) % MOD;
        
        // return tabulation(n, k);
        return tabulationSO(n, k);
    }
}