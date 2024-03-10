/*
Counting Sort is a "non-comparison-based" sorting algorithm that works well for integers when the range
of possible values (the difference between the minimum and maximum values) is not significantly larger than
the number of elements in the input array(basically for smaller elements). The basic idea is to count the
number of occurrences of each element and then use this information to place the elements in sorted order.
(STABLE SORTING ALGORITHM.)

NOTE: NOT SUITABLE FOR LARGE NUMBERS, DECIMAL NUMBERS and NEGATIVE NUMBERS

(Frequency Array: Used to count frequency or occurrence of elements in an array)

APPROACH OF THE BELOW CODE OF COUNT SORT:
1. First find the largest element from the input array. Why? .. B/z we will then create a frequency arr.
of size maxElement+1.
2. Frequency array will store the frequencies of elements of input array at the idx which is EQUAL TO THE
ELEMENT ITSELF.
3. Now we will again create a sorted array of length equal to input array size pretty obvious. Now we'll
place all indices(indices itself) one by one their frequency times in the result array.

*/

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        // Implementation using array
        int[] arr = {1,2,4,7,3,4,2,9,8,2};
        System.out.println("Array before sorting : " + Arrays.toString(arr));
        countSort(arr);
        System.out.println("Array after sorting : " + Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }
        // find max element
        int maxItem = findMax(arr);

        // create array of size = maxItem+1
        int[] freqArray = new int[maxItem+1];

        // store the frequencies of elements "at" idx which is equal to the "element itself"
        for(int i = 0; i < arr.length; i++) {
            freqArray[arr[i]]++;
        }

        // now place all idxs with non-zero value one by one (freq times) in original input array.
        int idx = 0;
        for(int i = 0; i < freqArray.length; i++) {
            while(freqArray[i] > 0) {
                arr[idx] = i;
                idx++;
                freqArray[i]--;
            }
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for(int num : arr) {
            if(num > max) {
                max = num;
            }
        }
        return max;
    }
}
/*
Here's a breakdown of the time complexity of PLACING ELEMENTS TO RESULT ARRAY: (bcz it is dominant from all)

The outer loop iterates over the freqArray, which has a length of k (the range of possible values).
In the worst case, this loop runs k times.
The inner loop runs for each non-zero entry in freqArray. The number of iterations of the inner loop
is proportional to the frequency of the current element. Since the sum of all frequencies is "equal to
the number of elements in the array (n)", the total number of iterations of the inner loop across all
iterations of the outer loop is also n.
Therefore, the overall time complexity is O(n + k),

Space complexity O(k) bcz it is dominant one. (k is size of freqArray)
*/