package RecursionOnArrays;

import java.util.ArrayList;

public class TargetSumRepetition {

    public static void combinations(int[] arr, int idx, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans)  {
        if(target == 0) {
            ans.add(new ArrayList<>(temp));   // don't forget to add by initialising new ArrayList
            return;
        }
        if(idx == arr.length || target < 0) {
            return;
        }

        // not including
        combinations(arr, idx+1, target, temp, ans);

        // including  (but in repetition case we know that we will "not increase idx" rather we'll keep taking the curr element)
        temp.add(arr[idx]);
        combinations(arr, idx, target-arr[idx], temp, ans);
        temp.remove(temp.size()-1);   // backtrack

    }


    public static void main(String[] args) {
        // FOLLOW UP OF SUBSET WITH REPETITION. Come here after studying that. ⭐
        /*
        Given an array of distinct integers "arr" and a "target" integer target, return a list of
        all unique combinations of candidates where the chosen numbers sum to target. You may return
        the combinations in any order.
        The same number may be chosen from arr an unlimited number of times. Two combinations
        are unique if the frequency of at least one of the chosen numbers is different.
         */
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        combinations(arr, 0, target, new ArrayList<>(), ans);
        for(ArrayList<Integer> l : ans) {
            System.out.println(l + " ");
        }
    }
}
// https://leetcode.com/problems/combination-sum/
// Similarly you can return the count of the combinations just by little tweak in the code.
// Time complexity more than 2^n