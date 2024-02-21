/*
https://leetcode.com/problems/target-sum/description/

Prerequisite: CntSubsetSumDiff.java
Same problem just asked in different style underlying logic is same.

Same thing is happening we are dividing the array into two subsets and we need to find out
whether their diff is equal to target or not. Eg
Lets assign a random signs from any possible ans
    - + + + -
   [1,1,1,3,2]  target = 2
    /     \
[1,1,3] - [1+2]       taken rhs - as common
The problem is reduced to CountsubsetSumDiff easy now we can reduce it to knapsack already 
studied.

s1 = (target+sum(arr))/2
Number of "subsets whose sum is equal to s1" is our ans.
*/

package KnapSackClassic;

import java.util.Arrays;

public class TargetSum {
    public static int memoization(int[] arr, int sum, int idx, int[][] memo) {
        if(sum == 0 && idx == arr.length) return 1;
        if(idx == arr.length) return 0;
        
        if(memo[idx][sum] != -1) return memo[idx][sum];


        if(sum - arr[idx] >= 0) {
            return memo[idx][sum] = memoization(arr, sum-arr[idx], idx+1, memo) + 
                   memoization(arr, sum, idx+1, memo);  // included count and excluded count
        } else {
            return memo[idx][sum] = memoization(arr, sum, idx+1, memo);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int target = 3;

        int sumArray = 0;
        for(int e : arr) sumArray += e;

        if((target+sumArray) % 2 == 1) System.out.println(0);; // odd value not possible to get a subset whose sum is in decimal

        int sum = (target + sumArray)/2;

        int[][] memo = new int[arr.length][sum+1];
        for(int i = 0; i < arr.length; i++) Arrays.fill(memo[i], -1);

        System.out.println(memoization(arr, sum, 0, memo));
    }
}

// 2nd way easy if you don't know anything any want to just find it normal way 
// include don't include.
class Solution {
    static int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        
        for(int a : nums){
            total += a;
        }
        int[][] dp = new int[nums.length][2 * total + 1];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return helperMem(nums, 0, 0, target, dp);
    }

    // Memoization Method
    public int helperMem(int[] nums, int i, int sum, int target, int[][] dp){
        if(i == nums.length){
            if(sum == target) return 1;
            else return 0;
        }else{
            if(dp[i][sum + total] != Integer.MIN_VALUE) return dp[i][sum + total];
            int pos = helperMem(nums, i + 1, sum + nums[i], target, dp);
            int neg = helperMem(nums, i + 1, sum - nums[i], target, dp);
            return dp[i][sum + total] = pos + neg;
        }
    }
}