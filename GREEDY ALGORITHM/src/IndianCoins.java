/*
QUESTION : INDIAN COINS
We are given an infinite supply of denominations [1,2,5,10,20,50,100,500,2000]
Find min no of coins/notes to make change for a value V.
*/

import java.util.Arrays;

public class IndianCoins {
    public static void main(String[] args) {
        int[] denominations = {186,419,83,408};
        int V = 6249;
        // ans = 3 : 100 + 20 + 1

        /*
        Greed criteria : At each step find the maximum coins so that V can be reduced by
        largest amount possible.
        */

        Arrays.sort(denominations);
        int cnt = 0;

        for(int i = denominations.length-1; i >= 0; i--) {
                while(denominations[i] <= V) { 
                    cnt++;
                    V = V-denominations[i];
                }
        }
        System.out.println(cnt);

    }
}
// https://www.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1

// NOTE: This greedy appraoch works only for canonical coin/number system. You can not directly apply
// greedy to other random denominations. For that you have to use DYNAMIC PROGRAMMING. 
// https://www.sciencedirect.com/science/article/abs/pii/S0304397523001354#:~:text=A%20currency%20system%20for%20which,been%20characterized%20in%20previous%20studies.