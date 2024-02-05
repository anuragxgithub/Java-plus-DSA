package RecursionOnStrings;

import java.util.List;
import java.util.ArrayList;

public class SubSetRecursion {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = new ArrayList<>();   //2d list
        subsetRecursion(nums, 0, new ArrayList<>(), subsets);
        System.out.println(subsets);
    }

    static void subsetRecursion(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        if (index == nums.length) {     //baseCase
            subsets.add(new ArrayList<>(current));
            return;
        }

        subsetRecursion(nums, index + 1, current, subsets);
        current.add(nums[index]);
        subsetRecursion(nums, index + 1, current, subsets);
        current.remove(current.size() - 1);
    }
}
