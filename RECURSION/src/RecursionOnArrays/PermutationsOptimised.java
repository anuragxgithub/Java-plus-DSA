/*
Come here after solving permutations.java
HERE WE DO NOT USE EXTRA SPACE FOR VISITED AND TEMP VARIABLES
 */

/*
DRY RUN :
                        {1,2,3}
                     /     |     \
                    /      |      \
               1,2,3      2,1,3    3,2,1              (1 is swapped with 1, 2 and then 3) now idx will increase with 1 since we don't have any choice left for idx 1
             /   |        /   |     |   \
            /    |       /    |      \    \
         1,2,3  1,3,2  2,1,3 2,3,1  3,2,1  3,1,2     (2 is swapped with 2,3 in left call,  1 is swap w 1,3 in middle call & 2 is swapped with 2and1 in right call)
        /        |      |       |      |       \
       /         |      |       |      |        \
      1,2,3    1,3,2   2,1,3   2,3,1  3,2,1    3,1,2   (last idx guys got swapped with themselves bcz no other options are available before last idx every idx got all the possible positions)

      See dry run DryRunPermutationsOp.jpeg ⭐⭐
*/


package RecursionOnArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationsOptimised {

    // M1 PRINTING
    public static void permutationsOptimal(int[] arr, int idx) {
        if(idx == arr.length) {
            System.out.print(Arrays.toString(arr) + " ");
        }

        for(int i = idx; i < arr.length; i++) {
            // swap "current idx" with the choices available to it (itself is also a choice)
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
            permutationsOptimal(arr, idx+1);
            // now bro backtrack it to its original position so that we can use it for other permutes
            int tempo = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tempo;
        }
    }

    // M2 RETURNING ANS
    public static void permutationsOpReturn(List<Integer> arr, int idx, List<List<Integer>> ans) {
        if(idx == arr.size()) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int i = idx; i < arr.size(); i++) {
            // swap "current idx" with the choices available to it (itself is also a choice)
            Collections.swap(arr, idx, i);
            permutationsOpReturn(arr, idx+1, ans);
            // now bro backtrack it to its original position so that we can use it for other permutes
            Collections.swap(arr, idx, i);; // backtrack
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        // Here the idea is of simple permutation
        // as we know for each idx n, n-1, n-2,.. choices are possible we will leverage that by swapping
        // values in actual array.
        permutationsOptimal(arr, 0);    // this idx track the used idx (means indices before idx are got their different possible combinations)

        // RETURNING IN 2D ARRAY LIST
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // since array is given we'll take arr elements
        // to this list & then pass it rather than arr bcz we can't add arr into 2d arraylist
        for(int e : arr) list.add(e);
        permutationsOpReturn(list,0, ans);

        System.out.println();
        for(List<Integer> l : ans) {
            System.out.print(l + " ");
        }

    }
}
/*
REMEMBER THIS APPROACH ONLY DON'T GET CONFUSED EASY PEASY.
Time complexity : O(n*n!)
Space complexity : O(n)
 */