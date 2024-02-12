/*
https://www.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
SOLVED IT IN MY FIRST ATTEMPT

NOTE : ANSWER IS REQUIRED IN DECREASING ORDER SO ADD 1'S FIRST
OR SORT THE STRING BEFORE RETURNING SIMPLE
Prefix of 1101 is :
1
11
110
1101
*/

package Problems;

import java.util.ArrayList;

public class NbitBinary {
    public void find(int n, int zerosCount, int onesCount, String temp, ArrayList<String> ans) {
        if(n == 0) {
            if(zerosCount > onesCount) {
                return;
            }
            ans.add(temp);
            return;
        }
        // if at any point zeros count is greater return that it can't be our ans as it is given
        // for any(every) prefeix
        if(zerosCount > onesCount) {
            return;
        }
        // taking 1
        find(n-1, zerosCount, onesCount+1, temp+'1', ans);
        // taking 0
        if(onesCount != 0) {    // bcz we can't start with zero
            find(n-1, zerosCount+1, onesCount, temp+'0', ans);
        }


    }
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> ans = new ArrayList<>();
        find(N, 0, 0, "", ans);
        return ans;
    }
}
