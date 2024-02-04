package RecursionOnArrays;

import java.util.ArrayList;

public class LinearSearch2 {
    public static ArrayList<Integer> linearSearch(int[] arr, int target, int idx) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(idx == arr.length) return ans;  // base case      {or you can simply return an empty arraylist (new ArrayList<Integer>())}

        if(arr[idx] == target) {
            ans.add(idx);
        }
        ArrayList<Integer> smallAns = linearSearch(arr, target, ++idx);
        ans.addAll(smallAns);
        return ans;         // basically we are collecting all indices at each call if any and returning
                            // it in every call so that at last(idx=0) it will have all the indices in it. (in short bharo bhejo)
        // if for eg ans is returned at idx 5 so, it will give its value to smallAns when idx is 4

    }
    public static void main(String[] args) {
        int arr[] = {3,4,2,5,4,4};
        // Return all the indices of target present in array in a LIST.
        int target = 4;
        ArrayList<Integer> ans = linearSearch(arr, target, 0);
        System.out.println(ans);
                                                 }
}
