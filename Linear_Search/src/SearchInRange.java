public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = {3,45,3,5,34,5,6,4,39,35,378,98,66};
        int target = 4;
        int index1 = 3, index2 = 8;
        int ans = search(arr, target, index1, index2);
        if(ans == -1) {
            System.out.println("Element not found!");
        } else {
            System.out.println("Target element is at index: " + ans);
        }
    }
    static int search(int[] arr, int target, int start, int end) {
        if(arr.length == 0) {
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
