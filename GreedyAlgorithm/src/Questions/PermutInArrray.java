/*

https://www.geeksforgeeks.org/problems/permutations-in-array1747/1
*/

package Questions;

import java.util.Arrays;
import java.util.Collections;

public class PermutInArrray {
    public boolean isPossible(long a[], long b[], int n, long k) {
        // Here just simple trick you need to find out the 
        Arrays.sort(a);
        Long[] B = new Long[n];
        int idx = 0;
        for(long e : b) B[idx++] = e;
        Arrays.sort(B, Collections.reverseOrder());
        
        for(int i = 0; i < n; i++) {
            if(a[i] + B[i] < k) return false;
        }
        return true;
    }
}
