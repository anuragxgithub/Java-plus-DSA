// if there is no 0s in the jump array that means we will surely reach 
// to our destination bcz just taking 1 step we can reach anywhere lol XD

// Greed Criteria : If from any idx we can reach to our final position that means
//                  we can reach out destination.
// We will keep updating our final destination and bringing it near to the start

// Dp would take O(n^2)

package Questions;

public class JumpGame {
    public boolean canReach(int[] nums) {    
        int n = nums.length;
        int finalPosition = n-1;
        for(int i = nums.length-1; i >= 0; i--) {
            // for the curr idx keep checking whether we can reach our final pos. or not
            if(i + nums[i] >= finalPosition) {
                finalPosition = i;
            }
        }
        if(finalPosition == 0) {
            return true;
        }
        return false;
    }


    
    public boolean canJump(int[] nums) {
        return canReach(nums);
    }
}
// Time complexity : O(n)
