// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//<*******AMAZON INTERVIEW EXPERIENCE*****>
//Imagine a array that contains infinite no of elements technically not
//possible just imagine.So u can't use length method of array.Return the index of target.

//So the approach would be like manually give position to start and end ptr
//starting from beginning and keep increasing their gap.
public class Q3InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}; //Asc. Order
        int target = 100;
        int ans = confirmIndex(arr, target);
        System.out.println(ans);
    }
    static int confirmIndex(int[] arr, int target) {
        int start = 0, end = 1; //Not using arr.length
        while (target>arr[end]) {  // means aage badho left side me nhi milne wala b/z asc order
            start = end+1;  //very simple these two line itna to logic hoga hi
            end = start*2;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(target>arr[mid]) {
                start = mid+1;
            } else if(target < arr[mid]) {
                end = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    } //Important thing in footer//
}
// Note: Here index out of bound error bhi aa skta hai b/z solution is designed in such
// a way that it is assuming infinite number of elements simple logic hai yr dimaag nhi hai kay?