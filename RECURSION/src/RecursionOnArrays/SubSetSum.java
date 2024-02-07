package RecursionOnArrays;

public class SubSetSum {
    // 1
    public static void subsetSumPrinting(int[] arr, int idx, int sum) {
        if(idx == arr.length) {
            System.out.print(sum+" ");
            return;
        }

        // not including
        subsetSumPrinting(arr, idx+1, sum);
        //including
        subsetSumPrinting(arr, idx+1, sum + arr[idx]);

    }

    // 2
    public static int totalSubsetSum(int[] arr, int idx, int sum) {
        if(idx == arr.length) {
            return sum;
        }

        // not including
        int sumWithoutCurrent = totalSubsetSum(arr, idx+1, sum);
        //including
        int sumWithCurrent = totalSubsetSum(arr, idx+1, sum + arr[idx]);
        return sumWithoutCurrent + sumWithCurrent;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        subsetSumPrinting(arr, 0, 0);
        System.out.println();
        System.out.println(totalSubsetSum(arr, 0, 0));

        // you can take these sums in arraylist too by passing it as argument
    }
}
