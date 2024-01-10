// https://leetcode.com/problems/majority-element/description/
package Hashing;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int ans = majorityElement(nums);
        System.out.println(ans);
    }

    public static int majorityElement(int[] nums) {
        // First approach would be a BruteForce -O(n^2)
        // Using HashMap the T.C. could be reduced to O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        // Taking elements as key and their frequency as key
        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {  // key already exist update its freq.
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        System.out.println(map);
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {   // e represents the key-value pair
            if(e.getValue() > n/2) {
                return e.getKey();
            }
        }

        return 0;
    }
}
// https://leetcode.com/problems/majority-element-ii/   
// same copy paste for this medium problem