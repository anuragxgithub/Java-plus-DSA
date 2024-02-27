
/*
https://leetcode.com/problems/combination-sum-iv/ 
Here 1,2 and 2,1  will count as distinct combinations
*/

package FibonacciClassics;

public class CombinationSum4 {
    // MEMOIZATION  Time : O(target * nums.length) Space : O(target) + stack calls
    public static int memoization(int[] nums, int target, Integer[] dp) {
        if(target == 0) return 1;
        if(dp[target] != null) return dp[target];

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(target - nums[i] >= 0) {
                count = count + memoization(nums, target-nums[i], dp);
            }
        }
        dp[target] = count;
        return count;
    }

    // Tabulation  Time : O(target * nums.length) Space : O(target)
    public static int tabulation(int[] nums, int target) {
        // dp[i]: The value stored in dp[i] represents the number of
        // ways to achieve the target sum i using elements from the nums array.
        int[] dp = new int[target+1];
        dp[0] = 1; // Base case, there's one way to make target 0 (choose no elements)
        for(int i = 1; i <= target; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i-nums[j] >= 0) {
                    dp[i] = dp[i] + dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
    public static int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target+1];
        return memoization(nums, target, dp);

        // return tabulation(nums, target);
    }


    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[] {1,2,5}, 5));
    }
}
