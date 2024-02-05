package RecursionOnArrays;

public class isSorted {

    public static boolean isSorted(int[] arr, int idx) {
        if(idx == arr.length-1) return true;

        if(arr[idx] <= arr[idx+1]) {
            return isSorted(arr, idx+1);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,5,6};
        if(isSorted(arr, 0)) {          // Check for ascending order
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
