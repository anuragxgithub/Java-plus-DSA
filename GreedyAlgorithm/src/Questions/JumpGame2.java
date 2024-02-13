package Questions;

import java.util.Arrays;

public class JumpGame2 {

    // Guaranteed that we can reach the end. (Given)
    
    // METHOD 1 (DYNAMIC PROGRAMMING (TABULATION or BOOTOM UP APPROACH))
    // Time complexity: O(N*N)
    // Space complexity: O(N)
    public static int minJumps(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(minJumps(nums));



    }
}
