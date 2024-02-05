package SortingAlgos;//PREREQUISITE:
// 1: KNOW HOW TO DO BUBBLE SORT USING LOOPS.
// 2: IF YOU KNOW PATTERN PRINTING USING RECURSION (LIKE INVERT RIGHT TRIANGLE) THEN THIS
// IS JUST HALUA.

//Tip: As always: perform recursion by thinking it as loop.
//Literally halua
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,7,6,7,4,9};
        sort(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int i, int j) {
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
            sort(arr, i+1, 0);
        }
    }
}
