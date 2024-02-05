
// Question : Write a program to check if an array can be partitioned into sub-arrays with equal sum.
//            Or more formally check if the prefix sum of a part of the array is equal to the suffix sum
//            of rest of the array.
// source :  https://www.youtube.com/watch?v=5_DFKL4zYLc&t=2222s
package Questions;

public class Prefix_Sum_3 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,-2,8,2};  // ans would be true. bcz(1+2+4+5-2 = 10 & 2+8 = 10)
        System.out.println(isEqualSum(arr));
    }

    private static boolean isEqualSum(int[] arr) {
        int len = arr.length;
        int[] prefixSumArray = new int[len];
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += arr[i];
            prefixSumArray[i] = sum;
        }
        int prefixSum = 0;
        int suffixSum = 0;
        for(int i = 0; i < len; i++) {
            prefixSum = prefixSumArray[i];
            suffixSum = prefixSumArray[len-1] - prefixSum;   // u can store the value of prefixSumArray[len-1] in a variable bcz it is same for all iterations
            if(prefixSum == suffixSum) {
                return true;
            }
        }
        return false;
    }
}
