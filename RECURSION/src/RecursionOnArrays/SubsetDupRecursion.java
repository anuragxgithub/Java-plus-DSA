/*

Here we need to find the unique subsets. Because here in input array numbers can repeat
Just like normal subset finding approach.
Only change is while adding to the answer simply check if the current subset already exist or not.

But..
This will fail for:
Input
nums = [4,4,4,1,4]
Output
[[],[4],[4,4],[4,4,4],[1],[4,1],[4,4,1],[4,4,4,1],[4,4,4,4],[1,4],[4,1,4],[4,4,1,4],[4,4,4,1,4]]

1,4 and 4,1 are also getting included.

You just need to "SORT THE GIVEN ARRAY" initially and then pass it to the method simple.
This makes sure that duplicates look same so that our method can easily eliminate these.

THERE IS NO OPTIMISED APPROACH FOR THIS. IT IS THE ONLY WAY.
In "permutations", we can optimise the code initially to not go ahead and calculate duplicate permutes.
*/


package RecursionOnArrays;

import java.util.ArrayList;

public class SubsetDupRecursion {

    public static void findUniqueSubs(int[] arr, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans, int idx) {
        if(idx == arr.length) {
            if(!ans.contains(temp)) ans.add(new ArrayList<>(temp));
            return;
        }

        // not including current char
        findUniqueSubs(arr, temp, ans, idx+1);
        // including current char
        temp.add(arr[idx]);
        findUniqueSubs(arr, temp, ans, idx+1);

        temp.remove(temp.size()-1); // backtrack
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] arr = {2,1,2};
        findUniqueSubs(arr, new ArrayList<>(), ans, 0);
        for(ArrayList<Integer> list : ans) {
            System.out.print(list + " ");
        }
    }
}
