
/*

https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1?

We don't need priority queue here bcz distances are increasing constant for each cell. So there is no point
in using pq. Hence we will use Dijkstra Algo using queue.
Easy Peasy
NOTE: I THINK WE CAN DO IT WITHOUT DIST[][] because and without the dijkstra thing bcz relaxation then will not happen
just keep updating the dist+1 every time you reaches to a valid cell and whenever you reach to the destination
it will be the shortest path always. But in this case you have to use visited[][] grid.
This is used in imp2.java
*/

package Graphs.Questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SDinBinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) {
    return -1;
}
        
        Queue<int[]> q = new LinkedList<>();    // row, col, dist
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[source[0]][source[1]] = 0;
        q.add(new int[] {source[0], source[1], 0});  // initially path length is 0
        int[][] directions = new int[][] {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()) {
            int[] curr = q.remove();
            int row = curr[0];
            int col = curr[1];
            
            if(row == destination[0] && col == destination[1]) {
                return dist[row][col];
            }
            // visit the neighbors
            for(int[] direction : directions) {
                int nR = row + direction[0];
                int nC = col + direction[1];
                
                if(nR >=0 && nR < n && nC >= 0 && nC < m && grid[nR][nC] == 1) {
                    if(dist[row][col] + 1 < dist[nR][nC]) {  // bcz each edge wt is 1
                        dist[nR][nC] = dist[row][col] + 1;   // relaxation
                        q.add(new int[] {nR, nC, dist[nR][nC]}); // remeber to +1
                    }
                }  
            }
        }
        return -1;
    }
}
