/* ORDER-AGNOSTIC SEARCH (variant of the traditional B.S. algorithm)
   (when u don't know whether the given array is sorted in asc. or desc. order) */
// See notes to understand better.

//NOTE: Here array should be sorted whether Asc. or Desc. order.
public class BinarySearch_2 {
    public static void main(String[] args) {
//        int[] arr = {-6,-1,2,5,6,7,11,13,17,25,46,70}; // Lets assume that we don't know the order.
        int[] arr = {70,46,25,17,13,11,7,6,5,2,-1,-6};
        int target = 17;
        System.out.println(binarySearch(arr, target));
    }
    static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        boolean isAsc = arr[start] < arr[end];  // return T or F value (written in short without using if else stt.)

        while(start <= end) {
            int mid = start + (end-start)/2;
            if(arr[mid] == target) {
                return mid; // Answer is here.
            }

            if(isAsc) {
                if(target > arr[mid]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {         //if not ascending
                if(target < arr[mid]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1; // Not found.
    }
}
