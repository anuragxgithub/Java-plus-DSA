import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3,4,22,-12,-32,0,87};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = (i+1); j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break; // b/z no need to check further as lhs is already sorted.
                }
            }
        }
    }
}
