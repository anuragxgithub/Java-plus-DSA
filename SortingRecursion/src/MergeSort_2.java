//In-place means that the algorithm does not use extra space for manipulating the
//input but may require a small though non-constant extra space for its operation.
//Usually, this space is O(log n), though sometimes anything in O(n) (Smaller than linear) is allowed.
//Note: Merge sort is not an in place sorting algorithm.
//This on eis better approach than MergeSort_1 b/z here we are dividing the array through index and
//not copying its value to new array.we are passing index of divided array in merge fn.

//SEE NOTES⭐⭐⭐& u can also check for 1st approach tht is good for understanding the flow control
//and how & why here s,m,e indices are passed.
import java.util.Arrays;

public class MergeSort_2 {
    public static void main(String[] args) {
    int[] arr = {5,4,7,8,2,3,1};
    mergeSort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end) {
        if(start>=end) {
            return;
        }
        int mid = start+(end-start)/2;
        mergeSort(arr, start, mid);         //divide for left part
        mergeSort(arr, mid+1, end);  //divide for right part

        merge(arr, start, mid, end);
    }
    //Pay Attention to <, <=.
    static void merge(int[] arr, int s, int m, int e) {
        int[] merged = new int[e-s+1];  //Plus one b/z indexing starts from 0 of array.
        //Now let's create variables for accessing and comparing elements
        int i = s, j = m+1, k = 0;  // i for left part array j for right part array and k for merged array
        //Lets compare
        while(i<=m && j<=e) {
            if(arr[i] < arr[j]) {   //comparison of elements from two halves of array
                merged[k] = arr[i];
                i++;  //i ptr moves ahead 1 step
            } else {
                merged[k] = arr[j];
                j++;
            }
            k++;
        }
        //Now lets place the remaining elements from parts of array
        //Any one will execute
        while(i<=m) {
            merged[k] = arr[i];
            i++; k++;
        }
        while(j<=e) {
            merged[k] = arr[j];
            j++; k++;
        }

        //Now lets copy the elements from merged array to original array
        for (int l = 0; l < merged.length; l++) {
            arr[s+l] = merged[l];  //s+l b/z logical

//        System.arraycopy(merged, 0, arr, s + 0, merged.length);     Same thing
        }
    }
}
//Merge Sort is STABLE sorting algo.