// Linear search in integer ARRAY.
public class LinearSearch_1 {
    public static void main(String[] args) {
        int[] arr = {1,132,3,22,34,23,56,78,89,77,6,5,4,45,8,332,54};
        int target = 22;
        int ans = linearSearch(arr, target);
        System.out.println(ans);
    }
    static int linearSearch(int[] arr, int target) {
        if(arr.length == 0) {
            return -1;  // Not found b/z index can't be -1;
        }
        for (int i = 0; i < arr.length; i++) { // i here is index
            int element = arr[i];
            if(element == target) {
                return i;
            }
        }
        //This statement is going execute when none of the above statements are executed
        return -1;  //again meaning same not found
    }
}
// If u want to give output in T or F use boolean type simpil.
