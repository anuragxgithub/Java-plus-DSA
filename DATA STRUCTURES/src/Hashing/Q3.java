// https://leetcode.com/problems/intersection-of-two-arrays/
// Intesection of 2 arrays
package Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

public class Q3 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] arr = intersection(nums1, nums2);
        System.out.println(Arrays.toString(arr));
    }    

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int n : nums1) {
            set.add(n);
        }
        // now check which elements of arr2 present in arr1
        for(int n : nums2) {
            if(set.contains(n)) {
                list.add(n);
                set.remove(n);  // remove it otherwise it if that element occur multiple times in arr2 it will keep adding it to the list
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
// https://leetcode.com/problems/intersection-of-two-arrays-ii/
// nice question try without looking solution. Already solved it without any help.

// https://www.codingninjas.com/studio/problems/intersection-of-2-arrays_1082149
// again find the intersection of two sorted array. Sorted then we use 2 pointer and also we 
// need to return the elements in the sorted manner so obvioudly we need to use 2 pointer
// read Q. properly assume that elements that appear more than once in both arrays should be included multiple times in the final output..
// here I got to know that we can't ignore the equals() method (we should compare objects with equals() method eg Integer,str,etc)
// whenever everything is right in your code & u still getting error check for this.

// https://leetcode.com/problems/intersection-of-multiple-arrays/description/
// you can try this if u want