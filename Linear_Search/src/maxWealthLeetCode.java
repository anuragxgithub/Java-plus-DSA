// LeetCode question 1672.
public class maxWealthLeetCode {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {3,2,1}};
        int ans = maxWealth(arr);
        System.out.println(ans);
    }
    static int maxWealth(int[][] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            if(sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }
}
