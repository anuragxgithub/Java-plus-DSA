
// https://leetcode.com/problems/climbing-stairs/description/
// https://www.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1

package FibonacciClassics;
public class ClimbingStairs {
    public static int distinctWays(int n, int[] dp) {           // O(n)
        if(n == 0 || n == 1) return 1;  // bcz last step will also be counted       (if n can be -ve then add another base case if(n < 0) return 0)

        if(dp[n] != 0) return dp[n];   // already calculated no need to caluculate it again

        dp[n] = distinctWays(n-1, dp) + distinctWays(n-2, dp);
        return dp[n];
    }

    //LC
    public static int climbStairs(int n) {
        return distinctWays(n, new int[n+1]);
    }
    public static void main(String[] args) {
        int n = 3;
        // Explanation: There are three ways to climb to the top.
        // 1. 1 step + 1 step + 1 step
        // 2. 1 step + 2 steps
        // 3. 2 steps + 1 step

        System.out.println(climbStairs(n));
        System.out.println(climbStairsTabulation(n));
    }

    private static int climbStairsTabulation(int n) {   // O(n)
        int[] dp = new int[n+1];
        dp[0] = 1;          // initialization
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];              // filling  (small to large)
        }
        return dp[n];
    }
}
// NOTE: If in question it was given that we can climb with 3 steps also then we just need to add
// 1 extra recursive fn for  + f(n-3) 