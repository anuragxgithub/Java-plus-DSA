/*
Dynamic Programming (DP):
Dp is the optimised recursion.

How to identify :
1. Optimal Problem                  (Being Greedy, Just like in greedy algos)
AND
2. Some choice is given (multiple branches in recursion tree)               (Eg: finding finbonacci number)


<-- WAYS OF DP (MEMOIZATION and TABULATION) -->
1. MEMOIZATION (TOP-DOWN APPRAOCH): 
Memoization is one of the way to peform DP. In memoization we use extra space to perform dynamic programming.
- Recursion is used.
- Subproblems are calculated and stored in some storage for reuse.
- NOTE: FOR LARGE INPUTS(where lots of recursive calls are required) MEMOIZATION CAN FAIL BCZ OF STACKOVERFLOW.
        IN MOST CASES IT WORK BUT SOMETIMES IT FAILS. THAT'S WHY WE USE ANOTHER WAY OF DP i.e, TABULATION. 

2. TABULATION (BOTTOM UP APPROACH)        (imagine tree when bottom up or top down thing come)
Tabulation is another way to perform DP.
- Iteration is used instead of recursion.
- Table/Set is used. (basically storage)

OFFICIAL DEFINITION:
Dynamic Programming is a technique in computer programming that helps to efficiently solve a class of problems that
have 'overlapping subproblems' and 'optimal substructure' property.
*/

import java.util.Arrays;

public class Intro {

    public static int fib(int n, int[] f) {
        if(n == 0 || n == 1) return n;

        if(f[n] != 0) return f[n];    // return the already calculated ans no need to do more recusive calls

        f[n] = fib(n-1, f) + fib(n-2, f);
        return f[n];
    }

    public static int fibTabulation(int n) {
        // 3 Steps:     1. Initializtion    2. Meaning(in mind or pen paper)    3. Filling
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;          // initialization setting value which we already know

        for(int i = 2; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];          // filling (small to large)
        }
        return dp[n];
    }

    public static void main(String[] args) {    // O(2n) ~ O(n)   bcz of skewed recursive tree
        // Find the nth fibonacci number
        int n = 3;
        int[] f = new int[n+1];           // here store the calculations which is already calculated (memoization)

        System.out.println(fib(n, f));
        System.out.println(Arrays.toString(f));

        // https://www.geeksforgeeks.org/problems/nth-fibonacci-number1335/1 
        // SEE HERE MEMOIZATION FAILS BECAUSE OF LARGE INPUT AND RECURSIVE CALLS THAT'S WHY WE'LL USE TABULATION WAY OF DP.
        System.out.println(fibTabulation(3));
    }
}
// https://leetcode.com/problems/fibonacci-number/description/

