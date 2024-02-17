/*
QUESTION : MAX LENGTH CHAIN OF PAIRS
You are given n pairs of numbers. In every pair, the first num is always smaller than the second number. A pair (c,d)
can come after pair(a,b) if b < c.
Find the longest chain which can be formed from a given set of pairs.
*/

import java.util.Arrays;
import java.util.Comparator;

public class MaxLenChairPair {
    public static void main(String[] args) {
        int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        /*
        This is just a variation of activity selection question (starting time < ending time). We can easily verify 
        why greedy will always work by drawing testcases on number line.
        Greed Criteria : At each step find the pair which has least ending point so that we can further connect more
        available options.
        */

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));  // sort based on ending

        int len = 1;  // taking the first pair's length
        int lastEnd = pairs[0][1];

        for(int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] > lastEnd) {
                len++;
                lastEnd = pairs[i][1];
            }
        }
        System.out.println(len);
    }
}
// https://leetcode.com/problems/maximum-length-of-pair-chain/description/