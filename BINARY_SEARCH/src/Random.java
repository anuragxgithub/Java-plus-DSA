public class Random {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(find(nums));
    }
    static int find(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return Math.min(nums[left], nums[right]);
    }
}