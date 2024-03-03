/*

Question: "MOUNTAIN RANGES"  ORR  "MOUNTAIN AND VALLEYS"
You are given pairs of up stroke(/) and down stroke(\). 
Form all number of possible mountains. Using upstroke and down stroke.
NOTE: At any moment: "number of down stroke can't be greater than the number of up strokes".
      Bcz jameen ke andr to nahi jana hai na that's why.

-> lets say we have 0 pair so we don't take any stroke in this case we can arrange mountain
   in one way. So if n == 0. Ans is 1
-> lets say we have 1 pair so ther is one way we can make the mountain and valley and that is
   /\. So if n == 1. Ans is 1
-> for n = 2, two ways are possible:
            /\  
   /\  and /  \
-> lets say we are give n = 3.  (that means 3 pairs are given)

    lets see the possible mountain which can be made
    / \
     ↑  ↑
     0  n-1   -->  refers the case where we put 0 pair in middle and n-1 = 2 pairs in right
     1  n-2   -->  refers the case where we put 1 pair in middle and n-2 = 1  pair in right 
     2  n-3   -->  similarly this..
    
So for 1st case : 
   /\ 
/\/  \  /\/\/\      2 possible ways
For the 2nd case : 
 /\
/  \/\              1 possible way   
For the 3rd case :
  /\     
 /  \    /\/\
/    \  /    \      2 possible way

similarly you can calculate for n = 4 pairs. ans would be 14.

If you see carefully in the above example where we decided the possible ways to put pairs
either in middle or right side. This eq. is getting formed:
M0M2 + M1M1 + M2M0
1.2 + 1.1 + 2.1 = 5 Ans.   For n = 3 pars

Same as catalan number formula:
[ Cn = C0.Cn-1 + C1.Cn-2 + C2.Cn-3 + C3.Cn-4 .... Cn-1.C0  ]
*/

package CatalanClassics;

import java.util.Arrays;

public class MountainRanges {

    // RECURSIVE + MEMOIZATION  O(n^2)
    public static int memo(int n, int[] dp) {
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];

        int ans = 0;   // Cn
        for(int i = 0; i <= n-1; i++) {
            ans += memo(i, dp) * memo(n-i-1, dp);
        }
        return dp[n] = ans;
    }

    // Tabulation  O(n^2)
    public static int tab(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
 
        for(int i = 2; i <= n; i++) {   // recursive calls
            for(int j = 0; j < i; j++) {  // loop inside recursion
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        // code will be of catalan number
        int n = 4;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(memo(n, dp));


        System.out.println(tab(n));
    }
}