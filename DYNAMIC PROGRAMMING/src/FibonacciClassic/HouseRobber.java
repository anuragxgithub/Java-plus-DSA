
/*
https://leetcode.com/problems/house-robber/

Try to break down the problem into smaller steps. That how recursion/dp works.
For eg : 
Imagine you have this scenario:
..... h-3, h-2, h
Now here you have choose between two houses either you choose the h-2 or h
Lets say you have choosen h-2 that means you can't choose the h you should skip it.
And lets say if you choose h that means you are skipping h-2 and you have ans till h-3.
So here we can derive a formula that at every step we either rob the current house and
skip the next house OR we can skip the current house and rob the next house.
And the max value you get from these two steps that will be you ans.

Easy Peasy
1. Define a recursive function that takes the index of the current house as a parameter.
2. At each house, you have two choices: either rob the current house and skip the next
   one, or skip the current house and move to the next one.
3. Base case: If you reach the end of the array, return 0.
4. At each step, return the maximum amount you can rob either by robbing the 
   current house or skipping it.
5. Memoize the results to avoid redundant calculations.

NOTE :  Greedy won't work because : [2,3,2]     Ans. should be 4

 */

package FibonacciClassic;

import java.util.HashMap;

public class HouseRobber {

    // APPROACH 1 : MEMOIZATION  (TOP DOWN APPRAOCH)
    public static int maxLoot(int[] arr, int idx, HashMap<Integer, Integer> memo) {  // Time O(n)
        if(idx >= arr.length) {
            return 0;
        }
        if(memo.containsKey(idx)) {
            return memo.get(idx);
        }

        // robbing current and skipping next house
        int robCurrent = arr[idx] + maxLoot(arr, idx+2, memo);

        // skipping current and robbing next house
        int skipCurrent = maxLoot(arr, idx+1, memo);

        int maxAmount = Math.max(robCurrent, skipCurrent);

        memo.put(idx, maxAmount);
        return maxAmount;
    }

    // APPRAOCH 2 : TABULATION   (BOTTOM UP APPRAOCH)
    public static int maxLoot(int[] nums) {    // Time O(n)
        int n = nums.length;
        if(nums.length < 2) return nums[0];  // don't forget this
        int[] dp = new int[n];    // store the maxmimum loot possible at each idx

        // Initialiazation
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            // (robbing the current house + robbing the house two steps back), and (skipping the current house and robbing the previous house)
            dp[i] = Math.max((nums[i] + dp[i-2]), dp[i-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] arr = {1};           // {2,1,1,2}
        System.out.println(maxLoot(arr, 0, new HashMap<Integer, Integer>()));

        System.out.println(maxLoot(arr));
    }
}

//FOLLOW UP : SOLVE IT USING THE BRUTE FORCE METHOD USING ONLY FOR LOOPS.
// BELOW IS THE CODE FOR SAME CHECK OUT HOW IT IS FRAMED "AND WHETHER IT IS CORRECT OR NOT".

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 0) return 0; // If there are no houses, return 0
        
//         int maxAmount = 0;
        
//         // Iterate through all possible combinations of houses to rob
//         for (int i = 0; i < n; i++) {
//             int amount = 0;
//             int prevRobbed = 0;
//             int prevNotRobbed = 0;
            
//             // Calculate the maximum amount of money we can get starting from the current house
//             for (int j = i; j < n + i; j++) {
//                 int curr = nums[j % n]; // Handle wrap-around
                
//                 int temp = amount;
//                 amount = Math.max(prevRobbed + curr, prevNotRobbed);
//                 prevRobbed = temp;
//                 prevNotRobbed = amount;
//             }
            
//             // Update maxAmount if necessary
//             maxAmount = Math.max(maxAmount, amount);
//         }
        
//         return maxAmount;
//     }
// }
