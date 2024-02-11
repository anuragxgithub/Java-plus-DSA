package RecursionOnArrays;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumEqualsK2 {
    static int mod = (int)(1e9) + 7;

    public static int perfectSumCount(int[] arr, int target, int idx, long sum) {
        if(idx == arr.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        // not including
        long countWithoutCurrent = perfectSumCount(arr, target, idx+1, sum);
        // including
        long countWithCurrent = perfectSumCount(arr, target, idx+1, sum+arr[idx]);
        return (int)((countWithoutCurrent + countWithCurrent) % mod);
    }
    // The other approach you can use is that keep subtracting the current idx value instead of adding
    // and when sum reaches to zero that means target sum is possible. (but here carefully use the base
    // case like first check the idx == n only then check for sum became 0 or not)


//------------------------Returning the combinations-------------------------------//

    public static void subsetsReturn(int[] arr, int target, int idx, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if(idx == arr.length) {
            int sum = 0;
            for(int e : temp) {
                sum += e;
            }
            if(sum == target) ans.add(new ArrayList<>(temp));
            return;
        }

        // not including
        subsetsReturn(arr, target, idx+1, temp, ans);
        // including
        temp.add(arr[idx]);
        subsetsReturn(arr, target, idx+1, temp, ans);
        temp.remove(temp.size()-1);    // backtrack to remove the last element bcz temp will be same for all recursive calls
    }

    public static void main(String[] args) {
        // 1
        int[] arr = new int[] {5, 2, 3, 10, 6, 8};
        int sum = 10;
        System.out.println(perfectSumCount(arr, sum, 0, 0));

        // 2
        List<List<Integer>> ans = new ArrayList<>();
        int target = 10;
        subsetsReturn(arr, target, 0, new ArrayList<>(), ans);
        for(List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
