/*
Question : MIN ABSOLUTE DIFFERENCE PAIRS
Given two arrays A and B of equal length n. Pair each element of array A to an element
in array B, such that "sum S of absolute differences of all the pairs is minimum".
*/

import java.util.Arrays;

public class MinAbsDiff {
    public static void main(String[] args) {
        int[] A = {4,1,8,7};
        int[] B = {2,3,6,5};

        // Greed criteria : Find the closest value to the current value

        // For that we can sort the array and then find min abs. diff
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for(int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println(minDiff);
    }
}
// https://www.geeksforgeeks.org/problems/minimum-sum-of-absolute-differences-of-pairs/1