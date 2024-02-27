/*

https://leetcode.com/problems/house-robber-ii/

NOTE: EVERYTHING IS SAME LIKE THE HOUSE ROBBER 1 PROBLEM.
YOU JUST NEED TO SEPERATE THE ARRAYS.
CREATE AN ARRAY WHERE YOU SKIPPED THE LAST HOUSE.
AND CREATE ANOTHER ARRAY WHERE YOU SKIPPED THE FIRST HOUSE.
NOW FIND OUT THE MAX AMOUNT ROBBED FROM THE TWO SET OF ARRAYS AND RETURN MAX FROM THEM.
*/

package FibonacciClassics;

import java.util.HashMap;

public class HouseRobber2 {
    // APPROACH 1 : USING MEMOIZATION
    public static int maxLoot(int[] nums, int idx, HashMap<Integer, Integer> memo) {
        if(idx >= nums.length) {
            return 0;
        }

        if(memo.containsKey(idx)) return memo.get(idx);

        // robbing the current house and skipping the next house
        int robCurrent = nums[idx] + maxLoot(nums, idx+2, memo);
        // skipping the current house and robbing the next
        int skipCurrent = maxLoot(nums, idx+1, memo);

        int maxAmount = Math.max(robCurrent, skipCurrent);
        memo.put(idx, maxAmount);
        return maxAmount;

    }

    // APPRAOCH 2 TABULATION
    public static int maxLoot(int[] nums) {
        int n = nums.length;
        if(n < 2) return nums[0];    // why this again? bcz after skipping it may occur again
        int[] dp = new int[n];
        //initialization
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[n-1];
    }


    public static void main(String[] args) {
        int[] arr = {5,1,3,6,7};

        int n = arr.length;
        if(n < 2) {
            System.out.println(arr[0]);  // don't forget this
            return;
        }

        int[] skippingLast = new int[n-1];
        int[] skippingFirst = new int[n-1];

        for(int i = 0; i < n-1; i++) {
            skippingFirst[i] = arr[i+1];
            skippingLast[i] = arr[i];
        }

        int x = maxLoot(skippingFirst, 0, new HashMap<>());
        int y = maxLoot(skippingLast, 0, new HashMap<>());
        System.out.println(Math.max(x,y));

        int x1 = maxLoot(skippingFirst);
        int y1 = maxLoot(skippingLast);
        System.out.println(Math.max(x1, y1));
    }
}
