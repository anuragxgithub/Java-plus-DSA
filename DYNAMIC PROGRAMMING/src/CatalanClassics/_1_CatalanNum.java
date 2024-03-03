/*
CATALAN NUMBER
C0 = 1,   C1 = 1,   C2 = C0.C1 + C1.C0 = 2,   C3 = C0.C2 + C1.C1 + C2.C0 = 5
C4 = 14 , C5 = 42

Basically:
  [ Cn = C0.Cn-1 + C1.Cn-2 + C2.Cn-3 + C3.Cn-4 .... Cn-1.C0  ] REMEMBER THIS

Cn = CiCn-i-1

// visulaize recursion tree like this

            n = 3
        /\     /\   /\
       /  \   | |   | |
      0 * 2 + 1*1 + 2*0
    // further calls    
            
https://www.geeksforgeeks.org/problems/nth-catalan-number0817/1

*/

package CatalanClassics;

import java.util.Arrays;

public class _1_CatalanNum {
    // RECURSIVE  O(n!)
    public static int catalanRec(int n) {
        if(n == 0 || n == 1) return 1;

        int ans = 0;   // Cn
        for(int i = 0; i <= n-1; i++) {
            ans += catalanRec(i) * catalanRec(n-i-1);
        }
        return ans;
    }

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
        int n = 4;
        System.out.println(catalanRec(n));

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(memo(n, dp));


        System.out.println(tab(n));
    }
}
