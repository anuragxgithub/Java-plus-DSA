package RecursionOnStrings;//subset 2^n.
//Easy Peasy
//SEE NOTES ⭐⭐
import java.util.ArrayList;
import java.util.List;

public class Subset_Iterative {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = subset(arr);
        for(List<Integer> lists : ans) {
            System.out.println(lists);   //or print ans directly
        }
    }

    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outerList = new ArrayList<>();  //Creating outer list that will contain the subsets inside it in sub-lists basically 2D list
        outerList.add(new ArrayList<>()); //Initially adding an empty list to outer list(it is also a subset)
        for(int num : arr) {
            int n = outerList.size();  //at 1st, size is 1 b/z of empty list
            for (int i = 0; i < n; i++) {
                List<Integer> innerLists = new ArrayList<>(outerList.get(i)); // get() method is basically in constructor will be covered later (it creates the copy of given list)
                innerLists.add(num);  //num will be added in copied elements
                outerList.add(innerLists);
            }
        }
        return outerList;
    }
}
//According to Kunal.
//T.C.:  O(n * 2^n)
//S.C.: O(n * 2^n)

//According to GPT.
//The time complexity of the given RecursionOnStrings.Subset_Iterative algorithm is O(2^n) where n is the length of the input
//array 'arr'. This is because for each element in the input array, we are doubling the number of subsets
//that we have so far. This leads to a total of 2^n subsets.

//The space complexity of the algorithm is also O(2^n) because we are storing 2^n subsets in the
//'outerList' list. Specifically, for each element in the input array, we are adding a copy of the
//existing subsets that we have so far to 'outerList', which means that the size of 'outerList' grows
//exponentially with respect to the input size.