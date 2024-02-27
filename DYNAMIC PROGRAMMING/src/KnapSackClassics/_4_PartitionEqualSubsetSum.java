/*
https://leetcode.com/problems/partition-equal-subset-sum/description/
NOTE:
1. If sum of elements in "nums" is odd then it is not possible to divide the array into
   equal subset.
2. If sum is even. Lets say 22 then it may be possible that we would have two subsets
   whose sum is 11.
   Now, you don't need to do anything just take 11 (sum/2) and find out whether
   any subset has sum equals to 11 if yes that means we can partition the array into
   equal subset.
   This way our problem is reduced to Knapsack Problem.


   EXPLANATION WITH IMAGE IS PRESENT IN THIS PACAKGE ⭐⭐⭐
*/
package KnapSackClassics;

public class _4_PartitionEqualSubsetSum {
    public boolean subsetSum(int[] nums, int idx, int sum, Boolean[][] memo) {
        if(sum == 0) return true;
        if(idx == nums.length) return false;

        if(memo[idx][sum] != null) return memo[idx][sum];

        boolean included = false;
        if(sum - nums[idx] >= 0) {
            included = subsetSum(nums, idx+1, sum-nums[idx], memo);
        }
        boolean excluded = subsetSum(nums, idx+1, sum, memo);

        memo[idx][sum] = included || excluded;
        return memo[idx][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if((sum & 1) == 1) return false;  // odd sum

        Boolean[][] memo = new Boolean[nums.length][(sum/2)+1];
        
        return subsetSum(nums, 0, sum/2, memo);
    }
}