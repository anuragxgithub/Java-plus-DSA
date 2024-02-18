
// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?

package KnapSackClassic;

public class SubsetSumEqualsK {
    class Solution{
        // MEMOIZATION :   time : O(N*sum)
        public static boolean ansbhejo(int[] arr, int n, int sum, int idx, Boolean[][] memo) {
            if(sum == 0) return true;  // THIS BASE CASE SHOULD COME FIRST
            
            if(idx==n || sum < 0) return false;
            if(memo[idx][sum] != null) return memo[idx][sum];
            
            // include and don't include
            boolean included = ansbhejo(arr, n, sum-arr[idx], idx+1, memo);
            boolean excluded = ansbhejo(arr, n, sum, idx+1, memo);
            
            memo[idx][sum] = included || excluded;
            return memo[idx][sum];
        }
    
        static Boolean isSubsetSum(int N, int arr[], int sum){
            Boolean[][] memo = new Boolean[N][sum+1];
            return ansbhejo(arr, N, sum, 0, memo);
        }

        // TABULATION
        public static boolean ansbhejo(int[] arr) {
            return false;
        }
    }
}
