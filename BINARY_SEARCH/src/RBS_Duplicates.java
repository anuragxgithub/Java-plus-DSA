//Rotated Sorted Array: Find the peak element and remember elements can
//be duplicates(i.e, can occur many times).
//Remember both side of pivot is ascending order array.
//Will Fail for [1,3,5]
public class RBS_Duplicates {
    public static void main(String[] args) {
        int[] arr = {2,3,9,2,2,2};
        int ans = findPivot(arr);
        System.out.println(ans);
    }
    //First do simple B.S. for Rotated sorted array but last two condition will be
    //changed and new conditions will also be added.
    static int findPivot(int[] arr) {
        int start = 0, end = arr.length-1, mid;
        while(start<=end) {
            mid = start+ (end-start)/2;
            if (mid<end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid>start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }
            //Now here comes the real game.
            if(arr[start] == arr[mid] && arr[end] == arr[mid]) {
                //When start,end & mid are at elements which are same.
                //Before skipping those duplicate elements check whether it is pivot.
                //Check if start is pivot?
                if(arr[start] > arr[start+1]) {
                    return start;
                }
                start++;
                //Check if end is pivot?
                if(arr[end] < arr[end-1]) {
                    return end-1;
                }
                end--;
            }
            //Two more conditions: if start, end and mid are not at same value then we apply
            //same conditions to find peak Rotated sorted array with lil bit modification.
            //As we know left side is sorted:
            //(To reduce the search space)
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                //True when you are in left part of array
                start = mid+1; //Ans will lie on right side
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}
