// https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1#
// Union of 2 arrays
package Hashing;

import java.util.HashSet;

public class Q2 {
    public static void main(String[] args) {
        int[] nums1 = {4,5};
        int[] nums2 = {1,2,3,4,5};
        System.out.println(doUnion(nums1, nums2));

    }

    public static int doUnion(int a[], int b[]) 
    {
        // as we know our HashSet<> works same as a set.  TIME : O(n)
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : a) {
            set.add(num);
        }
        
        for(int num : b) {
            set.add(num);
        }
        System.out.println(set);

        return set.size(); 
        // https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1 
        // note is this question we need to return the union in sorted manner so lets not use the
        // HashSet rather leverage the property of sorted array which we are given with using 2 pointer
        // see the editorial solution(skipping the in a row recurring elements) and solve it that
        // way mine is complicated and comparitively less efficient
    }
}

// brute force approach 1
            // ArrayList<Integer> list = new ArrayList<>();
            // for(int num : a) {
            //     list.add(num);
            // }
            
            // for(int num : b) {
            //     if(!list.contains(num)) {
            //         list.add(num);
            //     }
            // }
            
            // return list.size(); 


// brute force Approach 2
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int num : a) {
        //     list.add(num);
        // }
        // for(int num : b) {
        //     list.add(num);
        // }

        // list.sort(null);
        // System.out.println(list);
        // int count = 1;    // bcz we are starting from 2nd element of the arraylist
        // for(int i = 1; i < list.size(); i++) {
        //     if(list.get(i) != list.get(i-1)) {
        //         count++;
        //     }
        // }

        // return count;