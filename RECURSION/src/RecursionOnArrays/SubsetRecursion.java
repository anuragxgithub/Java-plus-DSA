package RecursionOnArrays;

import java.util.List;
import java.util.ArrayList;

public class SubsetRecursion {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = new ArrayList<>();   //2d list
        subsetRecursion(nums, 0, new ArrayList<>(), subsets);
        System.out.println(subsets);
    }

    static void subsetRecursion(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        if (index == nums.length) {     //base Case
            subsets.add(new ArrayList<>(current));
            return;
        }
        // not including
        subsetRecursion(nums, index + 1, current, subsets);

        // including
        current.add(nums[index]);
        subsetRecursion(nums, index + 1, current, subsets);
        current.remove(current.size() - 1);  // back tracking bcz it(current) will remain same for all call
    }
}
