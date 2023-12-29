//PREREQUISITE:
// 1: KNOW HOW TO DO BUBBLE SORT USING LOOPS.
// 2: IF YOU KNOW PATTERN PRINTING USING RECURSION (LIKE INVERT RIGHT TRIANGLE) THEN THIS
// IS JUST HALUA.

//Tip: As always: perform recursion by thinking it as loop.
//Literally halua
import java.util.Arrays;
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,8,9,7,2,4};
        sort(arr, 0, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr, int i, int j, int max) { //Taking first element of array as maximum initially
        if(i == arr.length) {
            return;
        }
        if(j < arr.length-i) {
            if(arr[j] > arr[max]) {
                sort(arr, i, j+1, j);     //or just max = j; and put else's condition open(means not inside else i.e, remove the else but not its condition)
            } else {
                sort(arr, i, j+1, max);
            }
        } else {
            //swap max with last element first
            int temp = arr[max];
            arr[max] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
            sort(arr, i+1, 0,  0);
        }
    }
}