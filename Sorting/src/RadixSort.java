/*
Radix meaning in Mathematics:  The number of symbols used to represent numbers in a particular base.
For example, the radix of the base 10 number system is 10 because it uses 10 digits (zero through nine).

Radix Sort is a "non-comparative integer sorting" algorithm that sorts elements by processing them digit by digit. It is
an efficient sorting algorithm for integers or strings with fixed-size keys(numbers or characters).
Rather than comparing elements directly, Radix Sort distributes the elements into buckets based on each
digit’s value. By repeatedly sorting the elements by their significant digits, from the least significant
to the most significant, Radix Sort achieves the final sorted order.

RADIX SORT ALGORITHM:
The key idea behind Radix Sort is to exploit the concept of place value. It assumes that sorting numbers
digit by digit will eventually result in a fully sorted list. Radix Sort can be performed using different
variations, such as Least Significant Digit (LSD) Radix Sort or Most Significant Digit (MSD) Radix Sort.
We'll do it by LSD i.e, from right to left side.
*/

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println("Arrays after sorting : " + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        // perform count sort for every digit of a max number
        for(int exp = 1; max/exp > 0; exp *= 10) {
            countSort(arr, exp);
            System.out.println();
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // array to store sorted items for each pass
        // now create a bucket for storing occurrences/frequency of digits (u can name it freqArr , bucket,
        // countArray, or anything you want) same as what we do in count sort (store digit freq. at idx which is  equal to digit itself)
        int[] count = new int[10];  // base 10 number system contains nums. from (0 to 9)

//        Arrays.fill(bucket, 0);
        for(int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        System.out.println("Count array for " + exp + " : " + Arrays.toString(count));

        // Modify count[i] to store the position of the next occurrence of that digit
        // now this modified count array basically represents the position of the last occurrence of its
        // corresponding digit: Eg:
        // count[0] is 2, so the last occurrence of digit 0 is at index 1 in the output array.
        // count[1] is 2, so the last occurrence of digit 1 is at index 1 in the output array.
        // count[2] is 4, so the last occurrence of digit 2 is at index 3 in the output array
        //... and so on.
        for(int i = 1; i < 10; i ++) {  // 0 to 9 basically
            count[i] = count[i] + count[i-1];
        }
        System.out.println("Updated count array : " + Arrays.toString(count));

        // build the output array
        for(int i = n-1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.out.println("Output array : " + Arrays.toString(output));

        // copy the output array to arr[] so that array now contains sorted elements
        // according to the current digit place or pass
        System.arraycopy(output, 0, arr, 0, n);  // or do it by simple for loop
    }
}
// https://chat.openai.com/share/ccc08602-cb8d-4a76-b480-8330167c222b  ⭐⭐

// Note: This printing stuff of 'count array', 'updated count' and 'output array' is for self understanding
// ignore this.
// If you are given to sort the string containing only alphabets then you can create a bucket/count array of
// size 26. TRY IT!!



/*
Time Complexity: ----> O(d * (n + b)) <----
where d is the number of digits, n is the number of elements,
and b is the base of the number system being used.

In practical implementations, radix sort is often faster than other comparison-based sorting algorithms,
such as quicksort or merge sort, for "LARGE DATASETS", especially when the keys have many digits. However,
its time complexity grows linearly with the number of digits, and so it is not as efficient for small
datasets.
https://chat.openai.com/share/ee0ccac2-5382-4b0e-aabe-e25a33da080b (Read last conv.)

Space Complexity : ----> O(n+b) <----
where b is the base of the no system being used.
This space complexity comes from the need to create buckets for each digit value and to copy the
elements back to the original array after each digit has been sorted.
 */