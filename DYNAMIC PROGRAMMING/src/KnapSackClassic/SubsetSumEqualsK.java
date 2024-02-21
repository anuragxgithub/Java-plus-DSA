
// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?

package KnapSackClassic;

public class SubsetSumEqualsK {

        // MEMOIZATION :   time : O(N*sum)
        public static boolean memoization(int[] arr, int n, int sum, int idx, Boolean[][] memo) {
            if(sum == 0) return true;  // THIS BASE CASE SHOULD COME FIRST before other base cases
            
            if(idx==n || sum < 0) return false;
            if(memo[idx][sum] != null) return memo[idx][sum];
            
            // include and don't include
            boolean included = memoization(arr, n, sum-arr[idx], idx+1, memo);
            boolean excluded = memoization(arr, n, sum, idx+1, memo);
            
            memo[idx][sum] = included || excluded;
            return memo[idx][sum];
        }


        // TABULATION
        public static boolean tabulation(int[] arr, int target) {
            int n = arr.length;
            boolean[][] dp = new boolean[n+1][target+1];
            // base case initialization
            for(int i = 0; i < n+1; i++) {  // 0th col bcz we will always have a subset whose sum is zero and that is empty subset
                dp[i][0] = true;
            }
            // NOTE : Here we have to initialize 0th row to false also bcz if we do not have
            // any item to add so obviously we can't make it to the target sum
            // but in java already false values are present so not doing that
            // but dp[0][0] would be true from the 1st col 0th row start filling F
            // i items and j is target sum
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < target+1; j++) {
                    if(arr[i-1] <= j && dp[i-1][j-arr[i-1]] == true) {  // if including it gives true update the dp array to true otherwise its already false
                        dp[i][j] = true;
                    } else if(dp[i-1][j] == true) {
                        dp[i][j] = true;
                    }
                }
            }
            //you can do this to include, don't include way using || or
            print(dp);
            return dp[n][target];
        }

    public static void main(String[] args) {
        int[] arr = {4,2,7,1,3};
        int target = 10;
        Boolean[][] memo = new Boolean[arr.length][target+1];
        System.out.println(memoization(arr, arr.length, target, 0, memo));
        // print(memo);

        System.out.println(tabulation(arr, target));
    }










    public static void print(boolean[][] dp) {
        for(int i = 0; i < dp.length;i++) {
            for(int j = 0; j < dp[0].length;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}










