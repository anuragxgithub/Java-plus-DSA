package FibonacciClassics;

import java.util.Arrays;

public class JumpGame2 {
    // Guaranteed that we can reach the end. (Given)
    
    // METHOD 1 (DYNAMIC PROGRAMMING (TABULATION or BOOTOM UP APPROACH))
    // Time complexity: O(N*N)
    // Space complexity: O(N)
    public static int minJumpsTab(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1001);
        dp[0] = 0;     //initialization, bcz min distance from x to x itself is obviously 0

        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j <= nums[i]+i; j++) {
                if(j < n) {
                    dp[j] = Math.min(dp[j], 1+dp[i]);   // bcz one jump we are taking to move from curr to this idx
                }
                if(j == n-1) return dp[n-1];
            }
        }
        return dp[n-1];
    }

    // METHOD 2 DYNAMIC PROGRAMMING (MEMOIZATION or TOP-DOWN APPRAOCH)
    /*
     IMPORTANT:
        In Java, Integer.MAX_VALUE represents the maximum positive value that can be held by a variable of type int.
        It is equal to 2^31 - 1, which is 2,147,483,647.
        The reason you might be seeing -2147483648 instead is because of integer overflow. In Java, integer overflow
        occurs when a value exceeds the maximum positive value that can be held by the data type. When this happens, the
        value "wraps around" to the minimum value for that data type, which for int is -2,147,483,648.
        So, when Integer.MAX_VALUE is incremented by 1, it overflows and becomes -2147483648.
        This behavior is defined by the Java language specification.
     */
    public static int minJumpsMemo(int[] nums, int idx, int[] memo) {
        if(idx == nums.length-1) {
            return 0;
        }
        if(memo[idx] != -1 && memo[idx] != Integer.MAX_VALUE) return memo[idx];

        int minJumps = Integer.MAX_VALUE-1;   // why bcz it might be possible that we have to increment this value by 1 thats why this to prevent overflow
        for(int i = 1; i <= nums[idx]; i++) {
            if(idx+i < nums.length) {
                minJumps = Math.min(minJumps, 1+ minJumpsMemo(nums, idx+i, memo)); 
                // whatever value which we move from [1 to nums[i]] will count as 1
            }
        }
        memo[idx] = minJumps;
        return minJumps;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,1,2,3,1,1,2};
        System.out.println(minJumpsTab(nums));

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        System.out.println(minJumpsMemo(nums, 0, memo));

    }
}
