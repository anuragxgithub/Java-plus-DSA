// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/


package Heap_PriorityQ;

import java.util.PriorityQueue;
import java.util.Arrays;

public class Q4 {
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if(this.soldiers == r2.soldiers) { // if soldiers are same of 2 obj then compare ob the basis of indices
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();
        int colLength = mat[0].length;
        for(int row = 0; row < mat.length; row++) {
            int sCount = 0;
            for(int i = 0; i < colLength; i++) {
                if(mat[row][i] == 1) {
                    sCount++;
                }
            }
            pq.add(new Row(sCount, row)); // storing obj. of class Row
            // insertion takes logn time in Pq and we are adding it row times T.C. -> O(rows*log(rows))
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
                Row r = pq.poll();   // poll takes logn time. So  T.C. k*log(rows)
                result[i] = r.idx;
        }
        return result;
    }



    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}};

        int[] result = kWeakestRows(mat, 3);
        System.out.println(Arrays.toString(result));
    }
}
// m - rows ; n - columns
// Worst case time complexity : O(m*n + rows*log(m)  + k*log(m))
// In the worst case, where k is close to m (k ≈ m), the time complexity can be approximated as O(m * (n + log(m))).
// space complexity O(m)  where m is the total no of rows.