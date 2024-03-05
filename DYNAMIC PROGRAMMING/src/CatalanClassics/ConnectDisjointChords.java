/*

QUESTION : You are given "n pairs" of points on the circumference of a circle.
           Find/Count the different possible ways by which we can connect them so that
           no chords intersect each other.
           NOTE: you can use one point only once.

On both the sides of a chord there must be even number of points otherwise if odd number is
left it may be possible some point left as it is without involving in making chord
that is why we are talking and taking in pair.

"  
    The chord of a circle can be defined as the line segment joining any two points on the
    circumference of the circle
                                    ""
DRY RUN AND EXPLANATION IS GIVEN IN THIS PACKAGE ONLY. ⭐⭐⭐


NOTE : ⭐⭐⭐
QUESTION CAN TWISTED LIKE : 
You are given with even number of points on the circumference of the circle.
(Instead of pair of points here you will be given even "number" of points)
SO HOW ANSWER WILL GET AFFECTED?? 
SIMPLE, 
For n = 2    there will be one way only
For n = 4    there will be 2 ways only
For n = 6 (means 3 pairs)    there will be 5 ways only

So if you can observe then answer will be (n/2)th Catalan number.

*/

package CatalanClassics;

public class ConnectDisjointChords {
    // Memoization
    public static long catalanMemo(int n, Long[] dp) {
        if(n == 0 || n == 1) return 1;
        if(dp[n] != null) return dp[n];

        long ans = 0;
        for(int i = 0; i <= n-1; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }
        return dp[n] = ans;
    }
    // Tabulation
    public static long catalanTab(int n) {
        long[] dp = new long[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;        // (8 points)
        if(n == 0) {
            System.out.println(1);
            return;
        }
        System.out.println("Number of ways to join the chords without intersection is : " + catalanTab(n));

        // If in question n represents "number" of points not pair
        System.out.println("Number of ways to join the chords without intersection is : " + catalanMemo(n/2, new Long[n+1]));
    }
}
