package Foundation;

//Binary Search using recursion.
public class Recursion_BS {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,66,69,75,80}; //Obviously sorted array
        int target = 80;
        System.out.println(binarySearch(arr, target, 0, arr.length-1));
    }

    static int binarySearch(int[] arr, int target, int s, int e) {
        if(s>e) {
            return -1; //Target not found
        }
        int m = s + (e-s)/2;
        if(arr[m] == target) {
            return m;
        }
        if(arr[m] > target) {
            return binarySearch(arr, target, s, m-1);
        }
        return binarySearch(arr, target, m+1, e);
    } //NOTE : The given 'binarySearch' fn is a tail recursive fn as no operation needs to be performed after the recursive calls.
}
