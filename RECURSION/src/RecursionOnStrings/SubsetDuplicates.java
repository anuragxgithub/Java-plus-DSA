package RecursionOnStrings;//NOTE: SEE THIS AFTER SUBSET_ITERATIVE.JAVA
//Easy Peasy.
//SEE NOTES ⭐⭐
import java.util.List;
import java.util.ArrayList;
public class SubsetDuplicates {
    public static void main(String[] args) {
        int[] arr  = {1,2,2};
        List<List<Integer>> ans = subsetDuplicate(arr);
        for(List<Integer> lists : ans) {
            System.out.println(lists);
        }
    }

    static List<List<Integer>> subsetDuplicate(int[] arr) {
        List<List<Integer>> outerList = new ArrayList<>(); //2d list is created
        outerList.add(new ArrayList<>());  //Initially empty list added
        for(int num : arr) {
            int n = outerList.size(); //size is considered, so that much of new opy is created.
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
