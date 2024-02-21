/*
Q) Given an array, count all the possible subsets (two subsets after partition) whose diff
   comes out to be the diven "diff". Basically divide the array into two subsets
   whose difference come out to equal to given diff. Count all such subsets possible.
   Eg: [1,1,2,3]  diff = 1
   Ans: 2
   Explanation : 
   [1,1,2] - [3]
   [1,3] - [1,2]
   [1,3] - [1,2]  // bcz there is 2 different 1
   s1 = (diff + sum(arr))/2           Mathematical proof.
   So, Number of "subsets whose sum is equal to s1" is our ans.
*/
package KnapSackClassic;

import java.util.Arrays;

public class CntSubsetSumDiff {
    public static int memoization(int[] arr, int sum, int idx, int[][] memo) {
        if(sum == 0) return 1;
        if(idx == arr.length) return 0;
        
        if(memo[idx][sum] != -1) return memo[idx][sum];


        if(sum - arr[idx] >= 0) {
            return memo[idx][sum] = memoization(arr, sum-arr[idx], idx+1, memo) + 
                   memoization(arr, sum, idx+1, memo);  // included count and excluded count
        } else {
            return memo[idx][sum] = memoization(arr, sum, idx+1, memo);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int diff = 1;

        int sumArray = 0;
        for(int e : arr) sumArray += e;

        if((diff+sumArray) % 2 == 1) System.out.println(0);; // odd value not possible to get a subset whose sum is in decimal

        int sum = (diff + sumArray)/2;

        int[][] memo = new int[arr.length][sum+1];
        for(int i = 0; i < arr.length; i++) Arrays.fill(memo[i], -1);

        System.out.println(memoization(arr, sum, 0, memo));
    }
}
