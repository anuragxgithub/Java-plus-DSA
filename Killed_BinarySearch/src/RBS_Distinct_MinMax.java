//NOTE: THIS ALGORITHM DEALS WITH RBS QUESTIONS IN WHICH TARGET IS NOT GIVEN INSTEAD
//WE NEED TO FIND THE MAXIMUM OR MINIMUM VALUE IN THE GIVEN ARRAY(WITH SLIGHT MODIFICATION)
//YOU CAN DO SAME THING IN DUPLICATE ELEMENTS ARRAYS. (NEXT FILE IS FOR THAT)

//NOTE: IT ALSO HANDLES THE SPECIAL CASE WHEN THE ARRAY AFTER ROTATION REMAINS UNCHANGED
// EG: [11,13,15,17] AFTER 4 ROTATION --> [11,13,15,17] IT BECOMES LIL BIT DIFFICULT TO HANDLE THIS CASE
// BUT THIS ALGO. HANDLES THIS :)
// <<------LEETCODE Q.153------>>
public class RBS_Distinct_MinMax {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,1,2,3};  /*Try this too {11,13,15,17}*/
        System.out.println(findMin(nums)); //To find min element
        System.out.println(findMax(nums)); //To find max element
    }
    static int findMin(int[] nums) {
        int n = nums.length;
        int start = 0, end = n-1, mid;
        while(start < end-1) { //Remember end-1 and strictly smaller
            mid = start+(end-start)/2;
            if(nums[mid]>nums[end]) {
                start = mid;  // b/z No meaning in finding left side (b/z smaller ans will lie right side)
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
    //<----------------To find Maximum Element------------------------>
    static int findMax(int[] nums){
        int n = nums.length;
        int start = 0, end = n - 1, mid;
        while (start < end - 1) { //Remember end-1 and strictly smaller
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                end--;    //Why not (end = mid) b/z what is the array is {2,3,4,5,6,7,1}
            } else {
                start = mid;
            }
        }
        return Math.max(nums[start], nums[end]);
    }
}