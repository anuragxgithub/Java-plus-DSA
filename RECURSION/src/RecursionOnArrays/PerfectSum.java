package RecursionOnArrays;

import java.util.ArrayList;
import java.util.List;

public class PerfectSum {
    static int mod = (int)(1e9) + 7;

    public static void perfectSumCount(int[] arr, int target, int idx, int sum, int[] count) {
        if(idx == arr.length) {
            if(sum == target) count[0]++;
            return;
        }

        // not including
        perfectSumCount(arr, target, idx+1, sum, count);
        // including
        perfectSumCount(arr, target, idx+1, (sum+arr[idx]) % mod, count);
    }

    public static int perfectSum(int arr[],int n, int sum)
    {
        int[] count = {0};  // other way is to add all sum to any list and then count one by one
        perfectSumCount(arr, sum, 0, 0, count);
        return count[0];
    }
//------------------------Returning the combinations-------------------------------//

    public static void combinations(int[] arr, int target, int idx, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if(idx == arr.length) {
            int sum = 0;
            for(int e : temp) {
                sum += e;
            }
            if(sum == target) ans.add(new ArrayList<>(temp));
            return;
        }

        // not including
        combinations(arr, target, idx+1, temp, ans);
        // including
        temp.add(arr[idx]);
        combinations(arr, target, idx+1, temp, ans);
        temp.remove(temp.size()-1);    // backtrack to remove the last element
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 2, 3, 10, 6, 8};
        int sum = 10;
        System.out.println(perfectSum(arr, arr.length, sum));

        List<List<Integer>> ans = new ArrayList<>();
        int target = 10;
        combinations(arr, target, 0, new ArrayList<>(), ans);
        for(List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
