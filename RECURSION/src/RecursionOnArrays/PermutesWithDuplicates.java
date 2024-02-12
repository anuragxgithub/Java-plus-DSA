/*
Here the input array/list can contain duplicate elements.
So how will the permutation got affected. Let's see

{1,1,2}
by the formula we can say that there should be n! unique permutes but this is not true there will be
n!/2! unique permutations  bcz 1 is repeating two times. So 3!/2! = 3. These permutations are:
{1,1,2} , {1,2,1},  {2,1,1}

Similarly for {1,1,2,2}. There will be : 4!/2!*2! = 24/4 = 6 unique permutations.

NOTE : THERE IS ONLY A LITTLE LOGICAL TWEAK IN NORMAL PERMUTATIONS FINDING APPROACH.
here i applied this tweak to all (2-3) methods which we used to find the permutations.
But care for swapping way only.
--------------- Coming to question ------------------

1. Approach 1: Same as we used to do in the normal permutations with distinct nums.
   by eliminating the permutation which had already present in ans. {using contains() method}
   But in this method we are calculating same thing again and again. Not efficient.

2. Approach 2: Use the swapping way but this time you will not swap num which is already used
   at that idx and at that level of recursion. This will eliminate the redundant calculation for the
   same unique permutation. How we can achieve this? It can be achieved if we have the track of num used
   at the current idx if a num is already placed/swapped to that idx we will not make any other
   swap which will bring the same num at that idx.
   So at every lv we will check that this num is already used at that idx. Simple
   Leverage the constrain       -10 <= arr[i] <= 10    total 21 digits possible make boolean array using
   this.

3. Approach 3: Using the temp and visited approach looping from 0 till n for each level. But the little
   change would be again same to not include the same num at same idx at each level of recursion.
   So for this we will use the same thing as we used in 2nd approach to track this.

 NOTE: FORM APPROACH 2 AND APPROACH 3 YOU CAN USE ANY.
 But I will choose 2 (swapping bcz its easy to visualise and don't uses extra ds)
 DRY RUN FOR any input ⭐⭐
*/

package RecursionOnArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PermutesWithDuplicates {

    // METHOD 1
    public static void permutDup1(int[] arr, int idx) {
        if(idx == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        boolean[] visited = new boolean[21];  // why creating here bcz we want same num do not come in
// same idx only and this will only happen for the same level and after that we have to backtrack the changes so here
        for(int i = idx; i < arr.length; i++) {
            if(!visited[arr[i]+10]) {
                visited[arr[i]+10] = true;
                // now usual work swap the current idx num with all the possible options
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
                permutDup1(arr, idx+1);
                int tempo = arr[idx];  // back track for array only not visited one hehe
                arr[idx] = arr[i];
                arr[i] = tempo;
            }
        }
    }

    // METHOD 2   (swapping way)  Remember this only because we will follow this approach only
    public static void permutDup2(ArrayList<Integer> arr, int idx, ArrayList<ArrayList<Integer>> ans) {
        if(idx == arr.size()) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        boolean[] visited = new boolean[21];  // why creating here bcz we want same num do not come in
// same idx only and this will only happen for the same level and after that we have to backtrack the changes so here
        for(int i = idx; i < arr.size(); i++) {
            if(!visited[arr.get(i)+10]) {
                visited[arr.get(i)+10] = true;
                // now usual work swap the current idx's num with all the possible options
                Collections.swap(arr, idx, i);
                permutDup2(arr, idx+1, ans);
                Collections.swap(arr, idx, i);
            }
        }
    }

    // METHOD 3  (using temp and visited approach)
    public static void permutDup3(int[] arr, boolean[] visited, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {
        if(temp.size() == arr.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        boolean[] used = new boolean[21];
        for(int i = 0; i<arr.length; i++) {
            if(!used[arr[i]+10] && !visited[i]) {  // is any char is not repeated at particular lv go ahead
                temp.add(arr[i]);
                used[arr[i]+10] = true;
                visited[i] = true;
                permutDup3(arr, visited, temp, ans);
                temp.remove(temp.size()-1);     // back track
                visited[i] = false;         // back track
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        // METHOD 1 PRINTING
        //boolean[] visited = new boolean[21];   // idx (0-9) represent value (-10,-1) && idx (10,20)
        // represent value (0,10) so if arr[i] = 1 we can mark this as visited[arr[i]+10] so 11th idx
        // will be marked
        // why this bcz to check which num. we have used for that particular idx it will make sure
        // that no num will come at "same idx" more than one time bcz both will generate the same unique
        // permutation.
        permutDup1(arr, 0);


        // METHOD 2 RETURNING ANS IN 2D ARRAYLIST
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();  // since array is given we'll take arr elements
        // to this list & then pass it rather than arr bcz we can't add arr into 2d arraylist
        for(int n : arr) list.add(n);
        permutDup2(list, 0, ans);

        for(ArrayList<Integer> l : ans) {
            System.out.print(l + " ");
        }

        System.out.println();
        // METHOD 3 (Normal permutation finding approach using temp and at every lev loop till size of arr)
        // only change will obviously be to not include the num at same idx more than 1 time
        // so, we will make visited in method itself like in Method 2
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        permutDup3(arr, new boolean[arr.length], temp, answer);

        for(ArrayList<Integer> l : answer) {
            System.out.print(l + " ");
        }
    }
}
// https://leetcode.com/problems/permutations-ii/description/
// What if this is not given -10 <= arr[i] <= 10
// then we can simply use hashset. ⭐⭐