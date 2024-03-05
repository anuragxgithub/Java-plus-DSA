/*

https://leetcode.com/problems/bag-of-tokens/description/
*/ 
package Questions;

import java.util.Arrays;

public class BagOfTokens {
    class Solution {
        public int bagOfTokensScore(int[] tokens, int power) {
            int n = tokens.length;
            if(n == 0) return 0;
            int maxScore = 0;
            int score = 0;
            Arrays.sort(tokens);

            int i = 0, j = tokens.length-1;  // 100, 200
            while(i <= j) {
                if(tokens[i] <= power) {
                    score++;
                    maxScore = Math.max(score, maxScore);
                    power -= tokens[i];
                    i++;
                } else if(score > 0 && tokens[i] > power) {
                    score--;
                    power += tokens[j];
                    j--;
                } else {
                    break;
                }

            }
            return maxScore;
        }
    }


    public static void main(String[] args) {
        BagOfTokens b = new BagOfTokens();
        Solution s = b.new Solution();

        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        System.out.println(s.bagOfTokensScore(tokens, power));

    }
}