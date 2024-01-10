/*  You should know that : (u know it already)
if any number modulo by a specific num(lets say x) then if you and multiple of any x to the 
number and again modulo it the result will be same, basic thing. For eg:
23 % 7 = 2 now if you add any multiple of 7 to 23 and again modulo it results will be same i.e, 2 
23 + 21 = 44 % 7 = 2 again. SIMPIL So if any no is given and we calculated its modulo again 
after adding something to it if modulo comes same then the number which is added must be the
multiple of num by which was dividing.
*/

// https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
// Another subarray question similiar logic is used but here we have to deal with -ve numbers too. EasyPeasy

// Now all logic of multiples will be applied here we will here maintain a count var. but the
// problem arises bcz here -ve values present even still everything applies correct but the problem
// in coding is that if you do : 
// NOTE : In mathematics -5 % 7 = +2 which is true but in code if you do -5 % 7 it will give -2
// similary in maths -9 % 5 = +1 which is true but in code it will give -4 which is not correct

// So if we can find the actual remainder maths wala then everything will be on point and correct
// so simply we use this modular arithematic formula to find correct remainder if num is -ve and that
// is : ((num%k + k)%k) verify: -9%5-> -4 in code -> -4+5= 1 -> 1%5 = 1.Correct
package Hashing;

import java.util.HashMap;

public class QImp3 {
    public static void main(String[] args) {
        // TEST CASES 
        int[] nums1 = {4,5,0,-2,-3,1};  // k = 5
        int[] nums2 = {-1,2,9};         // k = 2
        int[] nums3 = {2,-2,2,-4};      // k = 6
        int[] nums4 = {5};              // k = 9

        System.out.println(subarraysDivByK(nums1, 5));
        System.out.println(subarraysDivByK(nums2, 2));
        System.out.println(subarraysDivByK(nums3, 6));
        System.out.println(subarraysDivByK(nums4, 9));
    }

    private static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // will be storing the modulo of prefix sum by k of each idx as key and their freq. as value
        map.put(0,1);  // empty subarray sum (initial prefix sum)
        int prefixSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int residual = (prefixSum % k + k) % k; // this handles case when num is -ve and we need to find correct remainder (residual is basically remainder)

            if(map.containsKey(residual)) {
                count += map.get(residual);
                map.put(residual, map.get(residual)+1); // update the freq.
            } else {
                // if residula doesn't already exist in map
                map.put(residual, 1);
            }
        }
        return count;
    }
}


// EASY PEASY