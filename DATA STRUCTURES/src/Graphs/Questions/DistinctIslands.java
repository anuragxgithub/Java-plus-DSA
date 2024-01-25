
/*

AFTER SOLVING THE "NUMBER OF ISLANDS" QUESTION, TACKLE THIS PROBLEM:

https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
NOTE: THIS QUESTION NOW RESIDES IN LEETCODE PREMIUM.

SIMPLE PROBLEM:
THE KEY TO SOLVING THIS LIES IN DETERMINING IF ISLANDS ARE IDENTICAL.
OBSERVE THE FOLLOWING WHILE TRAVERSING THE GRID USING DFS:

ASSUME A SPECIFIC '1' AS A STARTING POINT FOR DFS. CONSIDER ITS ROW AND COLUMN AS BASE ROW AND BASE COLUMN.
WHEN MOVING TO NEIGHBORS IN ALL FOUR DIRECTIONS, SUBTRACT THE COORDINATES (ROW, COL) FROM THE BASE ROW AND BASE COLUMN
OF THE NEIGHBOR.
STORE THESE DIFFERENCES IN A LIST. BY DOING THIS FOR ALL ISLANDS IN THE GRID, IDENTICAL ISLANDS WILL HAVE SIMILAR
COORDINATE INFORMATION.

*/

package Graphs.Questions;

import java.util.ArrayList;
import java.util.HashSet;

public class DistinctIslands {
    public void dfs(int[][] grid, boolean[][] visited, int row, int col, ArrayList<String> list,
    int row0, int col0) { // row0 and col0 represents base row and column
        if(row>=0 && row < grid.length && col>=0 && col<grid[0].length && !visited[row][col] &&
        grid[row][col] == 1) {
            visited[row][col] = true;
            list.add(toString(row-row0, col-col0));  // subtract base r or c from neigh r or c
            
            // Check out for all the neighbors horizontally and vertically
            dfs(grid, visited, row-1, col, list, row0, col0);
            dfs(grid, visited, row, col-1, list, row0, col0);
            dfs(grid, visited, row+1, col, list, row0, col0);
            dfs(grid, visited, row, col+1, list, row0, col0);
        }
    }
    private String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ArrayList<String> list = new ArrayList<>();
                if(!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, visited, i, j, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
/*
Time : O(n*m)
Space : O(n*m)
*/