package RecursionOnArrays;//NOTE: SEE THIS AFTER SUBSET_ITERATIVE.JAVA
//Easy Peasy.
//SEE NOTES ⭐⭐
// Here we need to return the subset but, we have to make sure that we do not return duplicate subsets
// like {1,4} or {4,1} for {1,4} not allowed

// just like normal subset finding approach using iteration
// only change is while adding to the answer simply check if the current subset already exist or not.

import java.util.List;
import java.util.ArrayList;
public class SubsetDuplicatesIter {
    public static void main(String[] args) {
        int[] arr  = {1,2,2};
        // Arrays.sort(arr);        // see footer
        List<List<Integer>> ans = subsetDuplicate(arr);
        for(List<Integer> lists : ans) {
            System.out.println(lists);
        }
    }

    static List<List<Integer>> subsetDuplicate(int[] arr) {
        List<List<Integer>> outerList = new ArrayList<>(); //2d list is created
        outerList.add(new ArrayList<>());  //Initially empty list added
        for(int num : arr) {
            int n = outerList.size(); //size is considered, so, that much of new copy is created.
            for (int i = 0; i < n; i++) {
                List<Integer> innerLists = new ArrayList<>(outerList.get(i)); //copies will be created
                innerLists.add(num);  //num will be added in copied elements
                if(!outerList.contains(innerLists)) {
                    outerList.add(innerLists);
                }
            }
        }
        return outerList;
    }
}
/*
This will fail for:
Input
nums = [4,4,4,1,4]
Output
[[],[4],[4,4],[4,4,4],[1],[4,1],[4,4,1],[4,4,4,1],[4,4,4,4],[1,4],[4,1,4],[4,4,1,4],[4,4,4,1,4]]

1,4 and 4,1 are also getting included.

You just need to sort the given array initially and then pass it to the method simple.
This makes sure that duplicates look same so that our method can easily eliminate these.
*/