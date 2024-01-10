// https://leetcode.com/problems/continuous-subarray-sum/description/
// Again from subarray sum topic. Almost solved it by myself 90 % in first attempt with pen and paper.
/*  You should know that :
if any number modulo by a specific num(lets say x) then if you and multiple of any x to the 
number and again modulo it the result will be same, basic thing. For eg:
23 % 7 = 2 now if you add any multiple of 7 to 23 and again modulo it results will be same i.e, 2 
23 + 21 = 44 % 7 = 2 again. SIMPIL. So if any no. is given and we calculated its modulo, now again 
after adding something to it if modulo comes same as before then the number which is added must be
the multiple of num by which was getting divided.
*/

package Hashing;

import java.util.HashMap;

public class QImp2 {
    
    public static boolean subarraySum(int[] nums, int k) {
/*
we'll store currentSum/prefixSum 's modulo by k of each idx as key in HashMap since we don't need
to check how many such subarrays are present so instead of storing their freq. we'll be storing
their indices as value at which they occur.
 */
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);  // remember: empty subarray if we put this in hashmap first we don't need to write a seperate 'if' for when currenSum % k == 0
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int moduloValue = currentSum % k;   // if it comes out to be 0 we already added empty subarray's sum as zero in map it will return true thus we successfully avoided using that extra if which i was talking about on line 17. NOTE: if you not comfortable putting empty subarrays value np then use extra if 
            
            if(map.containsKey(moduloValue)) {
                if(i - map.get(moduloValue) >= 2) { // you know it why >=2 and not >=1 bcz map.get(moduloValue) will give prefix(i-1) wala index and our k lies lies from (i to pref(j))
                    return true;
                }
            }
            if(!map.containsKey(moduloValue)) { // if already contains leave it no problem
                map.put(moduloValue, i); // if do not contains then add it and its idx
            } 
        }
        return false;
    }

    public static void main(String[] args) {
        // TEST CASES
        int[] nums1 = {5,0,0,0};     // k=3   // true bcz [0+0] = 0 and is multiple of all number also size >=2
        int[] nums2 = {1,2,6,0};    // k=7    // false
        int[] nums3 = {23,2,4,6,7};  // k=6   // true
        int[] nums4 = {23,2,6,4,7};  // k=13  // false
        System.out.println(subarraySum(nums1, 3));
        System.out.println(subarraySum(nums2, 7));
        System.out.println(subarraySum(nums3, 6));
        System.out.println(subarraySum(nums4, 13));
    }
}
/*  
COME HERE AFTER UNDERSTANDING AND SOLVING THE ABOVE PROBLEM
-> NOTE : NOTE HERE WE ARE GIVEN ONLY +VE VALUES IF THERE WOULD BE -VE VALUE WE MUST HAVE TO
MODIFY OUR WAY OF FINDING REMAINDER bcz :
in maths -9 % 5 = +1 which is true but in code it will give -4

-> Now solve question of QImp3.java to tackle -ve values.
*/