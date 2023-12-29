// Very famous and many times asked by many big tech companies many times
// --->  "Subarray sum Equals K"  <---
// there are other subarray sum questions too solve them all.
// https://leetcode.com/problems/subarray-sum-equals-k/
// A Subarray is a contiguous non-empty sequence of elements within an array
package Hashing;

import java.util.HashMap;

public class QImp {
    public static void main(String[] args) {
        int k = 5;
        int[] arr = {1,-2,1,2,3,5};  // ans should be 3 bcz (1+-2+1+2+3 = 5 & 2+3 = 5 & 5 itself)

        int ans = subarraySum(arr, k);
        System.out.println(ans);

    }

    private static int subarraySum(int[] nums, int k) {

        // 3) OPTIMISED SOLUTION USING HASHMAP  (It also require some prefix sum concept)
        
        // basically what we are doing here is cheking the currentSum if it is equal to the k or not
        // and also checking if (currentSum-k) has already came before or not if yes then that means
        // a subarray with sum = k exist in b/w from the 0th idx to the idx of the currentSum
        // https://youtu.be/HbbYPQc-Oo4?si=vLiJyvJh6ikVem0H  (explanation watch carefully minor details)

        HashMap<Integer, Integer> map = new HashMap<>();
        // we'll store the currentSum/prefix sum of each idx as key and its freq. as value
        int count = 0;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if(currentSum == k) {
                count++;
            }
            if(map.containsKey(currentSum-k)) { // if T then subarray with sum k must had exist before
                count = count + map.get(currentSum-k);  // increase the count by the freq of that sum existed before
            }
            if(map.containsKey(currentSum)) {
                map.put(currentSum, map.get(currentSum) + 1);  // increase the freq. if that sum already exist before in the map
            } else {
                map.put(currentSum, 1); // if not then add the sum with freq. of one 
            }
        }

        return count;
// Important Observation to Note: If (currentSum-k) is equal to any value which had already exist in
// the prefixSum(or u can say currentSum of any past idx) before so that prefixSum which will
// present at any particular idx so from that idx to the idx where currentSum is checking
// (currentSum-k) till it: sum of all elements would be equal to the K.
// Eg: U are at idx 6 and checking wheter (currentSum-k) exist before and you found yes then the
// idx(lets say 3) where u found value = (currentSum-k) so from idx 3+1 to 6 sum of all elements
// would be equal to K.
// This verifies the pref(i,j) = pref(j) - pref(i-1) and prefix(i,j) is our
// subarray sum from i to j. So eq. can be written as : {pref(i-1) = pref(j) - k}
// prefix(j) is our currentSum/prefixSum till j. and prefix(j) somewhere in past was prefix(i-1) 

// One more thing i would like to mention here is that at line 36 we are checking currentSum == k
// again and again in each iteration this can be removed if at the starting we just put empty 
// subarray like put(0, 1) empty subArray's sub will be 0 this makes sure that while checking
// (currentSum - k) if currentSum == k then it will return true bcz ans would be zero and we already
// put 0 as empty subarray sum.

// DONE!! IF YOU REALLY UNDERSTOOD ALL THESE WHAT I CONVEYED THEN YOU ARE READY TO GO AND SMASH ANY
// QUESTION OF SUBARRAY SUMS solve QImp2.java

    }
}
// 1) Brute force approach O(n^3)  Wrote this without any help only brainstormed with pen and paper 
//    O(n^3) bcz for each subarray we are calculating its sum which will take O(n) time

        // int len = nums.length;
        // int count = 0;
        // int sum = 0;
        // for(int i = 0; i < len; i++) {
        //     if(nums[i] == k) {
        //         count++;
        //     }
        //     sum = nums[i];
        //     for(int j = i+1; j < len; j++) {
        //         sum = sum + nums[j];
        //         if(sum == k) {
        //             count++;
        //         }
        //     }
        // }
        // return count;

// 2) ANOTHER APPRAOCH CAN BE BY USING "PREFIX SUM" APPROACH THAT ALSO TAKEs O(n^2)

        // int count = 0;
        // int sum = 0;
        // int[] prefixSumArray = new int[nums.length];
        // for(int i = 0; i < nums.length; i++) {
        //     sum += nums[i];
        //     prefixSumArray[i] = sum;
        // }
        // System.out.println(Arrays.toString(prefixSumArray));
        // // we got our prefix sum array now use nested loop and find the subarray sum which is equal to k
        // for(int i = 0; i < prefixSumArray.length; i++) {
        //     for(int j = i; j < prefixSumArray.length; j++) {
        //         // keep checking for pref(i,j) is = or != to k
        //         int prefixItoJ = 0;
        //         if(i == 0) {
        //             prefixItoJ = prefixSumArray[j] - 0;
        //         } else {
        //             prefixItoJ = prefixSumArray[j] - prefixSumArray[i-1];   // if you don't know about prefix sum formula go and revise from arrays package
        //         }
        //         if(prefixItoJ == k) {
        //             count++;
        //         }
        //     }
        // }
        // return count;