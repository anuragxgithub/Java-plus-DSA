// See notes to understand theory part.
public class BinarySearch_1 {
    public static void main(String[] args) {
        int[] arr = {-6,-1,2,5,6,7,11,13,17,25,46,70}; // sorted in ascending order
        int target = 17;
        System.out.println(binarySearch(arr, target)); // print index of target element
    }
    static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length -1;
        while(start <= end) {
         // int mid = (start+end)/2;   can exceed the range of integer.
            int mid = start+ (end-start)/2;   //same thing
            if(target < arr[mid]) {
                end = mid-1;                  //go left side
            } else if(target > arr[mid]) {
                start = mid+1;                //go right side
            } else {
                return mid; // ans found.
            }
        }
        return -1; // Element not found.
    }
}

/*<-----------Similarly you can do for array sorted in descending order--------->*/

//public class BinarySearch_1 {
//    public static void main(String[] args) {
//        int[] arr = {70,46,25,17,13,11,7,6,5,2,-1,-6}; // sorted in descending order
//        int target = -6;
//        System.out.println(binarySearch(arr, target)); // print index of target element
//    }
//    static int binarySearch(int[] arr, int target) {
//        int start = 0, end = arr.length -1;
//        while(start <= end) {
//            int mid = start+ (end-start)/2;   //same thing
//            if(target < arr[mid]) {
//                start = mid+1;              //go right side
//            } else if(target > arr[mid]) {
//                end = mid-1;                //go left side
//            } else {
//                return mid; // ans found.
//            }
//        }
//        return -1; // Element not found.
//    }
//}

