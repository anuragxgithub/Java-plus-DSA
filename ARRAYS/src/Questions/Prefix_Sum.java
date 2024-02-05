// see the pw lecture Manvi mam lecture on prefix sum if you have any doubt.
// prefix sum or running sum is the sum of elements of an array from the 0th idx to the given idx.
// for i > 0   -->  prefix[i] = prefix[i-1] + arr[i];   You can verify this easy peasy(same as factorial)
// for i = 0 prefix[i or 0] = arr[0]

// one more formula you can find is : prefix(i,j) = prefix(j) - prefix(i-1);
// above:  prefix(i,j) means prefix sum from idx i to idx j ; and prefix(j) = prefix sum from idx 0 to j.

package Questions;

import java.util.Arrays;

public class Prefix_Sum {
    public static void main(String[] args) {
        // find the prefix of this array
        int[] arr = {1,4,2,6,8,5,9};
        int[] ans = findPrefix(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] findPrefix(int[] arr) {
        int[] prefixSumArr = new int[arr.length];
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prefixSumArr[i] = sum;
        }
        return prefixSumArr;
    }
}
