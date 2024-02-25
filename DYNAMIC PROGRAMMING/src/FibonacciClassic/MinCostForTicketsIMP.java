
/*
https://leetcode.com/problems/minimum-cost-for-tickets/
*/

package FibonacciClassic;

import java.util.Arrays;

public class MinCostForTicketsIMP {
    
    // Memoization
    public static int memoization(int[] days, int[] costs, int idx, int n, Integer[] dp) {
        if(idx >= days.length) return 0;

        if(dp[idx] != null) return dp[idx];

        // day 1 pass
        int option1 = costs[0] + memoization(days, costs, idx+1, n, dp);
        // day 2 pass
        int i = 0;
        for(i = idx; i<n && days[i] < days[idx]+7; i++); // i will point to day numb. after 7 days
        int option2 = costs[1] + memoization(days, costs, i, n, dp);
        // days 3 pass
        i = 0;
        for(i = idx; i<n && days[i] < days[idx]+30; i++);
        int option3 = costs[2] + memoization(days, costs, i, n, dp);
        
        
        return dp[idx] = Math.min(option1, Math.min(option2, option3));

    }
    // Tabulation
    public static int tabulation(int[] days, int[] costs, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case initialization
        dp[n] = 0;

        for(int k = n-1; k >= 0; k--) {
            // 1 day pass
            int option1 = costs[0] + dp[k+1];
            
            // 2 day pass
            int i = k;
            while(i < n && days[i] < days[k]+7) i++;
            int option2 = costs[1] + dp[i];

            i = k;
            while(i < n && days[i] < days[k]+30) i++;
            int option3 = costs[2] + dp[i];

            dp[k] = Math.min(option1, Math.min(option2, option3));
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        int[]days = {1,4,6,7,8,20};
        int costs[] = {2, 7, 15};
        int n = days.length;
        Integer[] dp = new Integer[n+1];  //store what is min cost for travelling at given day
        System.out.println(memoization(days, costs, 0, n, dp));


        System.out.println(tabulation(days, costs, n));
    }
}
