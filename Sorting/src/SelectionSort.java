import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {45, -32, -21, 0, 6, 1, 2, 3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) { //arr.length-1 itne bar me sare elements sort ho jaenge
            int maxIndex = 0;  //Initially 0 ko th index ko max element maan lete h like we do max = 0, when finding max element
            for (int j = 1; j < arr.length - i; j++) { // arr.length - i to prevent iterating on well placed elements
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j; //here finding the index of max element not max element itself.
                }
            }
            //Swap the max element with the last element of the unsorted array
            int lastIndex = arr.length - i - 1;
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[lastIndex];
            arr[lastIndex] = temp;
        }
    }
//-----------If you want to choose smallest element and replace it with the 1st element------------//
//    int n = arr.length;
//    for (int i = 0; i < n - 1; i++) {
//        int minIndex = i;
//        for (int j = i + 1; j < n; j++) {
//            if (arr[j] < arr[minIndex]) {
//                minIndex = j;
//            }
//        }
//        // Swap the minimum element with the first element of the unsorted part
//        int temp = arr[minIndex];
//        arr[minIndex] = arr[i];
//        arr[i] =
//}
}