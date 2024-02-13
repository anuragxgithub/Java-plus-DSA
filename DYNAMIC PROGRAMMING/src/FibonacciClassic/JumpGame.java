
/*
https://leetcode.com/problems/jump-game/description/
Note: 
The dp approach is not much efficient here.
Becuase it will still take O(n^2).
and the recursive appraoch would take O(n^n).

We can solve it using simple greedy algo in one pass.
*/

package FibonacciClassic;

import java.util.HashSet;

public class JumpGame {
    // METHOD 1:       MEMOIZATION (Top Down Appraoch)
    public static boolean canReach(int[] nums, int idx, HashSet<Integer> memo) {    
        if(idx == nums.length-1) {
            return true;
        }
        if(idx >= nums.length) return false;
        if(memo.contains(idx)) {
            return false;
        }

        for(int i = 1; i <= nums[idx]; i++) { 
            if(canReach(nums, idx+i, memo)) {
                return true;
            }
        }
        memo.add(idx);
        return false;
    }
    public static boolean canJump(int[] nums) {
        return canReach(nums, 0, new HashSet<>());
    }


    // Method 2    TABULATION (bottom up appraoch)
    // The idea is can we reach to the next true spot from the current idx starting from end
    // if from end to begin we can reach to a true spot that means we can reach our dest.
    public static boolean canReachTabu(int[] nums) {    
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;     // initialization
        

        for(int i = n-2; i >= 0; i--) {
            for(int j = 1; j <= nums[i]; j++) {
                if(i+j < n && dp[i+j])  {
                    dp[i] = true; // If we can reach a true index from here, mark this index as true
                    break;
                }
            }
        }
        return dp[0];

    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,0,4};
        System.out.println(canJump(nums));

        System.out.println(canReachTabu(nums));

    }
}
