package RecursionOnArrays;

public class TargetSum {

    public static boolean isTargetSum(int[] arr, int idx, int target) {
        if(target == 0) return true;   // we can have a subset whose sum will be equal to target
        if(idx == arr.length || target < 0) return false;

                  // not including                        // including
        return isTargetSum(arr, idx+1, target) || isTargetSum(arr, idx+1, target-arr[idx]);

    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,8,7};
        int target = 19;
        // Find out if any subset has sum equals to target or not.

        System.out.println(isTargetSum(arr, 0, target));


    }
}
