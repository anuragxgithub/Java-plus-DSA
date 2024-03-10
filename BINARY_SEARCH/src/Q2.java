// Floor of a number (See notes)
public class Q2 {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18}; //Asc. order
        int target = 12;  // return 15 or just smaller element's INDEX.
        System.out.println(findFloor(arr,target));

    }
    //return the index of largest no. <= target
    static int findFloor(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(arr[mid]==target) {
                return mid;
            }
            if(target>arr[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return end; // to get floor of the target number. If target element is not present.
    }
}
//What if the smallest element in array is the target element and does not exist(in this que. 1 lets say) it will automatically return -1
//simple logic see notes if u don't get it.