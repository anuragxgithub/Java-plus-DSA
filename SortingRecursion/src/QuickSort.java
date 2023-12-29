//SEE NOTES ⭐⭐⭐⭐⭐
import java.util.Arrays;
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,2,5,1,2,4,5,5,6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {   //base condition
            return;
        }
        int pIndex = partition(arr, low, high);

        quickSort(arr, low, pIndex - 1);   //for left
        quickSort(arr, pIndex + 1, high);   //for right
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];   //taking last element as pivot.
        int i = low - 1;        // you can take it from low only no need to increment like at line 25
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //now increment i by 1, and it will have correct index value for pivot.
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;           //pivot index value
    }



}

//------------------------------------------------------------------------------------------//

        //<<<<<<<<<<<<<<SECOND APPROACH (TAKING MID ELEM. AS PIVOT)>>>>>>>>>>>>>>>>>>>//

//    static void quickSort(int[] nums, int low, int high) {
//        if(low>=high) {
//            return;
//        }
//        int s = low;
//        int e = high;
//        int m = s+(e-s)/2;
//        int pivot = nums[m];
//        while(s<=e) {
//            while(nums[s] < pivot) {
//                s++;
//            }
//            while(nums[e] > pivot) {
//                e--;
//            }
//            if(s<=e) {
//                int temp = nums[s];
//                nums[s] = nums[e];
//                nums[e] = temp;
//                s++;
//                e--;
//            }
//        }
//        //Now pivot is at correct index sort the two halves
//        quickSort(nums, low, e);
//        quickSort(nums, s, high);
//    }
