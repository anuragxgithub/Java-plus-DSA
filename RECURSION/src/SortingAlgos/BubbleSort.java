package SortingAlgos;//PREREQUISITE:
// 1: KNOW HOW TO DO BUBBLE SORT USING LOOPS.
// 2: IF YOU KNOW PATTERN PRINTING USING RECURSION (LIKE INVERT RIGHT TRIANGLE) THEN THIS

//Tip: As always: perform recursion by thinking it as loop.

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,7,6,7,4,9};
        sort(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int i, int j) {
        // As we know in bubble sort after one complete iteration biggest is at the last idx and so on
        // that means sorting starts from end in bubble sort.
        if(i == arr.length-1) {
            return;
        }
        if(j < arr.length-i-1) {
            if(arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            sort(arr, i, j+1);
        } else {
//            System.out.println(Arrays.toString(arr));  // proof that recursion is correct
            sort(arr, i+1, 0);
        }
    }
}
