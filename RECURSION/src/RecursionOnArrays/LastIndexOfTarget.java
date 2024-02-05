package RecursionOnArrays;

public class LastIndexOfTarget {

    public static int lastOccurence(int[] arr, int target, int idx) {
        if(idx < 0) {
            return -1;
        }

        if(arr[idx] == target) {
            return idx;
        }
        return lastOccurence(arr, target, --idx);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {12,4,5,6,8,4,2,4,1};
        System.out.println(lastOccurence(arr, 4,  arr.length-1));
    }
}
