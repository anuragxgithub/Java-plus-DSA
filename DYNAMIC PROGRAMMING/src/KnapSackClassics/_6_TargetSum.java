/*
https://leetcode.com/problems/target-sum/description/

PREREQUISITE: _5_PartitionWithGiveDiff.java   &  _3_SubsetSumEqulasKCnt.java ⭐⭐
Same problem just asked in different style underlying logic is same.

Same thing is happening we are dividing the array into two subsets and we need to find out
whether their diff is equal to target or not. Eg
Lets assign a random signs from any possible ans
    - + + + -
   [1,1,1,3,2]  target = 2
    /     \
[1,1,3] - [1+2]       taken rhs - as common
The problem is reduced to CountsubsetSumDiff easy now we can reduce it to subsetSumEqualsK already 
studied.

s1 = (target+sum(arr))/2          this is basically sum of subset 1 count how many possible subsets whose sum is equal to this that will be our ans.

Easy peasy.
BaseCases are imp. since target can be -ve ⭐
*/

package KnapSackClassics;

import java.util.Arrays;

public class _6_TargetSum {
    class Solution {
        static int total = 0;
        // MEMOIZATION METHOD 1  (requires some knowledge to reduce the problem into clear subsetSumEqualsK prob.)
        public static int memoization(int[] arr, int sum, int idx, int[][] memo) {
            if(sum == 0 && idx == arr.length) return 1;  // if idx == arr.length only then valid subset don't forget
            if(idx == arr.length) return 0;
            
            if(memo[idx][sum] != -1) return memo[idx][sum];
    
    
            if(sum - arr[idx] >= 0) {
                return memo[idx][sum] = memoization(arr, sum-arr[idx], idx+1, memo) + 
                       memoization(arr, sum, idx+1, memo);  // included count and excluded count
            } else {
                return memo[idx][sum] = memoization(arr, sum, idx+1, memo);
            }
        }
    
        // MEMOIZATION METHOD 2  (just coding what we see normal way)
        public int helperMem(int[] nums, int i, int sum, int target, int[][] dp) {
            if(sum == target && i == nums.length) return 1;  // ensuring all values are present while sum becomes target
            if(i == nums.length) return 0;
            
            if(dp[i][sum + total] != Integer.MIN_VALUE) return dp[i][sum + total];
    
            int pos = helperMem(nums, i + 1, sum + nums[i], target, dp);
            int neg = helperMem(nums, i + 1, sum - nums[i], target, dp);
            return dp[i][sum + total] = pos + neg;
        }
     // ---------------------------------------------------------------------------//
        // TABULATION METHOD 1 (tabulation for memo method 1 requires reducing knowledge)
        public static int tabulation(int[] arr, int target) {
            int n = arr.length;
            int totalSum = 0;
            for(int i = 0; i < n; i++) totalSum += arr[i];
            if((totalSum + target) % 2 == 1 || Math.abs(target) > totalSum) return 0; // doing same thing like memo M1
    
            // now find the sum whose subset sum count i need to find
            int sum = (totalSum+target)/2;
            // with the help of tabulation find out cnt of subset sums whose value is equal to sum
    
            int[][] dp = new int[n+1][sum+1];
            for(int i = 0; i <= n; i++) dp[i][0] = 1; // initialization
    
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j <= sum; j++) {
                    int v = arr[i-1];
                    if(v <= j) {
                        dp[i][j] = dp[i-1][j-v] + dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][sum];  // return count that will be our ans
        }
    
        // TABULATION METHOD 2 (tabulation for memo method 2 just code what u see)
        public static int helperTab(int[] arr, int target) {
            int total = Arrays.stream(arr).sum();
            if(Math.abs(target) > total) return 0;
            int n = arr.length;
            int[][] dp = new int[n+1][(total*2)+1];
    
            dp[0][total] = 1;  // base case initialization (there's one way to achieve a sum of 0 (when no elements are included).)
            for(int i = 1; i <= n; i++) {
                for(int j = -total; j <= total; j++) {
                    if(dp[i-1][j+total] > 0) {
                        dp[i][j + arr[i-1] + total] += dp[i-1][j+total];  // adding
                        dp[i][j - arr[i-1] + total] += dp[i-1][j+total];  // subtracting
                    }
                }
            }
            return dp[n][target+total];
        }
    
    
        public int findTargetSumWays(int[] nums, int target) {
            // ----> MEMOIZATION METHOD 1 <----
    
            int sumArray = 0;
            for(int e : nums) sumArray += e;
            //Important line (THIS WILL MAKE SURE WE DON'T GET -VE VALUE TO FIND SUBSET SUM :))
            if((sumArray+target) % 2 == 1 || Math.abs(target) > sumArray) return 0;   // odd value not possible to to find decimal value
    
            int sum = (target + sumArray)/2;
            int[][] memo = new int[nums.length][sum+1];
            for(int i = 0; i < nums.length; i++) Arrays.fill(memo[i], -1);
    
            return memoization(nums, sum, 0, memo);
    
            // ----> MEMOIZATION METHOD 2 <----
    
            // for(int a : nums){
            //     total += a;
            // }
            // int[][] dp = new int[nums.length][2 * total + 1];
            // if(Math.abs(target) > total) return 0;
            // for(int[] row : dp){
            //     Arrays.fill(row, Integer.MIN_VALUE);
            // }
            // return helperMem(nums, 0, 0, target, dp);
    
            //---------------------------------------------------------------//
    
            // ----> TABULATION METHOD 1 <----
            // return tabulation(nums, target);
    
            // ----> TABULATION METHOD 2 <----
            // return helperTab(nums, target);
    
        }
    }
}
// Obviously method 1 of tabualtion and memoization is better in time and space. 