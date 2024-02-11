// IMPORTANT

package RecursionOnArrays;

import java.util.ArrayList;

public class SubsetWithREPETITION {

    public static void subsetRepetitions(int[] arr, int idx, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {
        if(temp.size() == arr.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(idx == arr.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // not including
        subsetRepetitions(arr, idx+1, temp, ans);

        // including        (but here we will not increase the idx rather we keep taking same element till max size) this is the little change
        temp.add(arr[idx]);
        subsetRepetitions(arr, idx, temp, ans);
        temp.remove(temp.size()-1);   // backtrack to remove the last element as it is passed by reference so it will same for all recursive call
    }

    public static void main(String[] args) {
        int[] arr = {3,4};

        // Here we need to find the subset of given array "BUT HERE ELEMENTS CAN REPEAT".
        // eg: Possible subsets/combinations are:
        // [2,2,2], [2,2,3], [2,2,4], [2,3,3], [3,3,3], [3,3,4]... and so  on
        // REMEMBER RELATIVE ORDER OF ELEMENTS WILL NOT CHANGE
        // ALSO HERE YOU CAN "USE ONE ELEMENT AT MAX" SIZE OF THE INPUT ARRAY. ⭐
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subsetRepetitions(arr, 0, temp, ans);

        for(ArrayList<Integer> l : ans) {
            System.out.print(l + " ");
        }
    }
}
// DRY RUN FOR SMALLER SIZE OF INPUT ARRAY LIKE {2,3};
// DRY RUN OF THIS IS PRESENT IN THIS PACKAGE. ⭐⭐