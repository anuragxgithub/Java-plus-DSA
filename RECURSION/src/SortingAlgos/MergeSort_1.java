package SortingAlgos;//Note: In this merge sort algo when we are dividing the array and copying it to new array
//so this will take extra space. So this is not a good way to do merge sort look 🌟SortingAlgos.MergeSort_2.
//This approach is not required to know.
//But this one creates good intuition of merge sort.
import java.util.Arrays;

public class MergeSort_1 {
    public static void main(String[] args) {
        int[] arr = {6,5,9,2,3,4,1};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
     }
     static int[] mergeSort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));  //Exclusive i.e, [0,mid)
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));  //Copies the specified range of the specified array into a new array.

        return merge(left, right);
     }

     static int[] merge(int[] first, int[] second) {
        int[] mergedArr = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while(i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                mergedArr[k] = first[i];
                i++;
            } else {
                mergedArr[k] = second[j];
                j++;
            }
            k++;
        }
        //It may be possible that any one arr has some remaining elements .
        //Anyone while loop we be executed from both.
        while(i<first.length) {
            mergedArr[k] = first[i];
            i++;
            k++;
        }
        while(j<second.length) {
            mergedArr[k] = second[j];
            j++;
            k++;
        }
        return mergedArr;
     }
}
