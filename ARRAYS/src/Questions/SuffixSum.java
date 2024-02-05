
// Suffix sum of a given index i in array is the sum of all elements from that idx to the end idx.
package Questions;

import java.util.Arrays;

public class SuffixSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        // suffix sum of idx 1 is = sum of all elements from i idx to end idx
        suffixSumArray(arr);
    }

    private static void suffixSumArray(int[] arr) {
        int[] suffixArray = new int[arr.length];
        int sum = 0;
        for(int i = arr.length-1; i >= 0; i--) {
            sum += arr[i];
            suffixArray[i] = sum;
        }
        System.out.println(Arrays.toString(suffixArray));
    }
}
