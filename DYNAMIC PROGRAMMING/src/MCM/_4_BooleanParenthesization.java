/*
 
https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1
*/

package MCM;

public class _4_BooleanParenthesization {
    int [][][]dp;

    int solve(String s, int i, int j, Boolean isTrue) {
        if (i > j)
            return 0;
    
        if (i == j) {
            if (isTrue)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }
        
        if(dp[i][j][isTrue?1:0] !=-1)
            return dp[i][j][isTrue?1:0];
    
        int temp = 0;
    
        for (int k = i; k <= j - 2; k += 2) {
            int lt = solve(s, i, k, true);
            int lf = solve(s, i, k, false);
            int rt = solve(s, k + 2, j, true);
            int rf = solve(s, k + 2, j, false);
    
            if (s.charAt(k + 1) == '|') {
                if (isTrue)
                    temp += (lt * rt + lt * rf + lf * rt);
                else
                    temp += (lf * rf);
            } else if (s.charAt(k + 1) == '&') {
                if (isTrue)
                    temp += (lt * rt);
                else
                    temp += (lf * rf + lf * rt + lt * rf);
            } else {
                if (isTrue)
                    temp += (lt * rf + lf * rt);
                else
                    temp += (lt * rt + lf * rf);
            }
        }
        return dp[i][j][isTrue?1:0] = temp % 1003 ;
    }

    int countWays(int n, String s) {
        dp = new int[n+1][n+1][2];
        for(int i = 0 ; i<=n;i++)
            for(int j = 0 ; j<=n;j++)
                for(int k = 0 ; k<=1;k++)
                    dp[i][j][k] = -1;
        return solve(s, 0, n - 1, true);
    }
}
