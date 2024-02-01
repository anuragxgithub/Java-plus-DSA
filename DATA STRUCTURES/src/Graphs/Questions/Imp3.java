
/*
https://leetcode.com/problems/path-with-minimum-effort/

EASY BUT GOOD QUESTION TRY TO SOLVE IT WITHOUT HELP EASY PEASY.

Here we use Dijkstra Algo but with slight modification.
- As we know Dijkstra Algo at the end gives us the shortest path from one point
  to every other point.

  But here we want to find the "minimum effort".
  Effort of a route is the max absolute difference in heights.
  So here if we imagine 'effort' as a distance b/w 2 node(cell) for each edge
  (connected cell). Then at the end of the Dijkstra Algo we will be having
  the minimum effort from from src cell to every other cell in effort[][]. SEE the printed array below.
*/


package Graphs.Questions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Imp3 {
    static class Pair implements Comparable<Pair> {
        int row;
        int col;
        int effortSofar;

        public Pair(int r, int c, int e) {
            this.row = r;
            this.col = c;
            this.effortSofar = e;
        }

        public int compareTo(Pair p2) {
            return this.effortSofar - p2.effortSofar;  // sorts effort in asc. order
        }
    }
    // LC
    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[][] effort = new int[n][m];
        for(int[] e : effort) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        pq.add(new Pair(0,0,0));
        int[][] directions = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int effortSofar = p.effortSofar;

            if(row == n-1 && col == m-1) {  // check this condition here only not while adding neighbors to the q bcz it
// may be possible that from other path effort can be updated so check this when removing the actual destination this 
//makes sure you get the minimum effort
                printEfforts(effort);
                return effortSofar; 
            }
            // visit the neighbors
            for(int[] d : directions) {
                int nr = row + d[0];
                int nc = col + d[1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newEffort = Math.max(Math.abs(heights[nr][nc] - 
                    heights[row][col]), effortSofar); // bcz path's effort is  maximum absolute difference in heights
                    if(newEffort < effort[nr][nc]) { // relaxation thing
                        effort[nr][nc] = newEffort;
                        pq.add(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }
        
        return 0;
    }
    public static void printEfforts(int[][] effort) {
        for (int[] arr : effort) {
            System.out.println(Arrays.toString(arr));
        }
        // Note:  at every cell its minimum effort is present like there must be some path through which you can
        // reach that cell in given minimum effort.
    }

    public static void main(String[] args) {
        int[][] heights = new int[][] {
            {1,2,2},
            {3,8,2},
            {5,3,5}
        };
        System.out.println(minimumEffortPath(heights));
    }
}
