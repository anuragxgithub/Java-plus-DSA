//Find Ceiling of a number (See Notes)
public class Q1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 9, 14, 16, 18, 19, 22}; //Asc. order array
        int target = 12;  // return 20 or just larger element's INDEX.
        System.out.println(findTarget(arr, target));

    }
    // return the index of smallest number >= target
    static int findTarget(int[] arr, int target) {
        //What if the largest element is the target element and don't exist in array(No ceiling).See Notes
        if(target>arr[arr.length-1]) {
            return -1;
        }
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;  // to get ceiling of the target number. If target element is not present.
    }
}