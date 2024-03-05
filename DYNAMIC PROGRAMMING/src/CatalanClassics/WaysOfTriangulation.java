/*

PROBLEM OVERVIEW:
The problem is to find the number of ways of triangulation in a polygon.

Let us first understand what is meant by triangulation of a polygon. Triangulation of a
polygon means partitioning the polygon so that each part of the polygon is a triangle.
Our aim is to find the "number of ways in which this partitioning" can be done.
Basically tell the number of ways by which we can triangulate the polygon.


SEE DRY RUN AND EXPLANATION PRESENT IN THIS PACKAGE ⭐⭐⭐


*/

package CatalanClassics;

public class WaysOfTriangulation {

    public static long catalanMemo(int n, Long[] dp) {
        if(n==0 || n==1) return 1;
        if(dp[n] != null) return dp[n];

        long ans = 0l;
        for(int i = 0; i <= n-1; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        } 
        return ans;
    }

    public static int catalanTab(int n) {
        if(n == 0) return 1;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for(int i = 2;i <= n; i++) {
            for(int j = 0; j < i ; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 2;
        if(n < 2) {
            System.out.println(0);
            return;
        }
        long ans = catalanTab(n-2);  // remember n-2
        System.out.println("Number of ways to triangulate the polygon with " + n + " vertices is : " + ans);
    }
}
