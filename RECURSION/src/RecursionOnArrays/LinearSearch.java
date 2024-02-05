package RecursionOnArrays;

public class LinearSearch {
    // return true or false based on the existence
    public static boolean linearSearch(int arr[], int target, int idx) {
        if(idx == arr.length) return false;
        if(arr[idx] == target) return true;
        return linearSearch(arr, target, idx+1);
    }

    // return the index of the target
    public static int linearSearch2(int arr[], int target, int idx) {
        if(idx == arr.length) return -1;
        if(arr[idx] == target) return idx;
        return linearSearch2(arr, target, idx+1);
    }

    // print all the indices where target is present
    public static void linearSearch3(int arr[], int target, int idx) {
        if(idx == arr.length) return;

        if(arr[idx] == target) System.out.println(idx);
        linearSearch3(arr, target, ++idx);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,56,4,743,89,2, 743, 9, 0, 743};
        int target = 743;
        System.out.println(linearSearch(arr, target, 0));  // returning boolean value

        System.out.println(linearSearch2(arr, target, 0));  // returning idx value if present otherwise -1
        linearSearch3(arr, target, 0);                      // print the indices all target
    }
}
