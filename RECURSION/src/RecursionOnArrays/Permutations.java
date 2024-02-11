/*
Note here we will be given array which contains distinct elements.
We need to find all possible permutations.

PERMUTATIONS:
All possible ways to represent the nums also there should not be repetitions.

 */

package RecursionOnArrays;

import java.util.ArrayList;

public class Permutations {

    public static void permutations(int[] arr, boolean[] visited, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {
        if(temp.size() == arr.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i<arr.length; i++) {
            if(!visited[i]) {
                temp.add(arr[i]);
                visited[i] = true;
                permutations(arr, visited, temp, ans);
                temp.remove(temp.size()-1);     // back track
                visited[i] = false;                 // back track after each recursive call
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        permutations(arr, new boolean[arr.length], temp, ans);

        for(ArrayList<Integer> l : ans) {
            System.out.print(l + " ");
        }
    }
}
// Dry run is given ⭐⭐⭐ in this package "DryRunPermutations1"
/*
Time complexity:
total no of calls * time take in one call
(n! * n)            // because for each level we are running a loop till arr size

Space Complexity:
max stack frames made + additional space used
O(n+n+n)  ~ O(n)     n->  temp, visited                // not including the ans size
 */

// NOTE⭐⭐ IN INTERVIEW IT CAN BE ASKED TO SOLVE THIS PERMUTATION THING WITHOUT
// USING THE TEMP AND VISITED DATA STRUCTURES.
// THIS IS COVERED IN PERMUTATIONS_OPTIMISED.JAVA      EASIER THAN THIS.
// Although this is also acceptable. You can do any. ⭐

//https://leetcode.com/problems/permutations/description/

