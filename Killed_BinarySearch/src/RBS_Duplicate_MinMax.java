//NOTE: THIS ALGORITHM DEALS WITH RBS QUESTIONS IN WHICH TARGET IS NOT GIVEN INSTEAD
//WE NEED TO FIND THE MAXIMUM OR MINIMUM VALUE IN THE GIVEN ARRAY (SLIGHT MODIFICATION
//IN ALGO. OF NON DUPLICATES ELEMENTS)

//NOTE: IT ALSO HANDLES THE SPECIAL CASE WHEN THE ARRAY AFTER ROTATION REMAINS UNCHANGED
// EG: [0,1,4,4,5,6,7] AFTER 7 ROTATION --> [0,1,4,4,5,6,7] IT BECOMES LIL BIT DIFFICULT TO HANDLE THIS CASE
// BUT THIS ALGO. HANDLES THIS :)
// <<------LEETCODE Q.154------>>
public class RBS_Duplicate_MinMax {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4,4,4,5,0};  /*Try this too {0,1,4,4,5,6,7}*/
        System.out.println(findMin(nums)); //To find min element
        System.out.println(findMax(nums)); //To find max element
    }
    static int findMin(int[] nums) {
        int n = nums.length;
        int start = 0, end= n-1, mid;
        while(start<end-1) {
            mid = start+(end-start)/2;
            if(nums[mid] > nums[end]) {
                start = mid;
            } else if(nums[mid] == nums[end]) {
                //Skip that end
                end--;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }

    //<--------------To find maximum element------------------>
    static int findMax(int[] nums) {
        int n = nums.length;
        int start = 0, end= n-1, mid;
        while(start<end-1) {
            mid = start+(end-start)/2;
            if(nums[mid] >= nums[end]) {  //Just extra equal to sign change in duplicacy case(See maximum in distinct array ques. to get better idea)
                end--;
            } else {
                start = mid;
            }
        }
        return Math.max(nums[start], nums[end]);
    }
}