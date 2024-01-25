
/*
https://leetcode.com/problems/shortest-path-in-binary-matrix/

⭐⭐THIS QUESTION IS VERY EASY BUT THE IDEA OF ADDING IT AS IMPORTANT QUESTION IS BECAUSE 
I GOT STUCK IN THIS QUESTION FOR 2-3 HOURS BECAUSE IT WAS GIVING ME TLE IN OPTIMIZED APPROACH TOO
"THE REASON WAS I WAS MAKING A SLIGHT MISTAKE IN BFS AND THAT WAS I WAS NOT MARKING THE VISITED[][] TRUE
JUST WHEN I WAS ADDING THE CELL IN TEH QUEUE INSTEAD I WAS MARKING IT TRUE AFTER THE FOR LOOP ENDS (JUST AFTER WHILE
LOOP WHICH)" THIS RESULTS IN UNNECESSARY ADDITION OF CELLS WHICH ALREADY GOT ADDED IN THE QUEUE.
THIS THING I DISCUSSED WHILE LEARNING DFS BUT I FORGOT THAT. AFTER SOME TIME I REALIZED IT XD.

SO ALWAYS MARK THE CELL/NODE AS VISITED JUST WHEN YOU ARE ADDING IT TO THE QUEUE.

WHY BFS BECAUSE HERE WE NEED TO GO LEVEL WISE THATS HOW WE CAN FIND THE SHORTEST DISTANCE FROM SRC TO TARGET efficiently.

We don't need priority queue here bcz distances are increasing constant for each cell. So there is no point
in using pq. Hence we will use Dijkstra Algo using queue.
*/

package Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class Imp2 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        
        boolean[][] visited = new boolean[n][n];
        int[][] direction = new int[][] {{-1,0}, {-1,-1}, {0,-1}, {1,-1}, {1,0},
        {1,1}, {0,1}, {-1,1}};
        Queue<int[]> q = new LinkedList<>(); // {row, col, lenSofar}
        q.add(new int[] {0, 0, 1});  
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.remove();
            int row = curr[0];
            int col = curr[01];
            int lenSofar = curr[2];
            if(row == n-1 && col == n-1) {
                return lenSofar;
            }
            // visit all the neighbors 8 directionally
            for(int[] d : direction) {
                int nR = row + d[0];
                int nC = col + d[1];
                if(nR >= 0 && nR < n && nC >= 0 && nC < n && !visited[nR][nC] && 
                grid[nR][nC] == 0) {
                    q.add(new int[] {nR, nC, lenSofar+1});
                    visited[nR][nC] = true;
                }
            }
        }
        return -1;
    }
}
// HERE I AM USING QUEUE WHICH IS STORING VALUE OF INT[] TYPE.
// YOU CAN USE PAIR CLASS TOO.
// NOTE: YOU CAN LEVERAGE THE GRID TO MARK THE VISITED CELLS INSTEAD OF
// USING BOOLEAN ARRAY JUST MARK THE VISITED GRID 1,2 OR ANYTHING EXCEPT 0.

// Time & Space : O(n*n)