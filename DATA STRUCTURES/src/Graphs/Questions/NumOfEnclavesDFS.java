/*
https://leetcode.com/problems/number-of-enclaves/submissions/1154535613/

THIS ONE IS SAME AS ReplaceOtoX.java   Easy peasy see that first.

NOTE: YOUR H.W. IS TO SOLVE THIS PROBLEM USING BFS 
Use Pair class in Queue Pair(int row, int col){}   
For direction use this beautiful loop idea
for(int[] direction : new int[][] {{-1, 0}, {0, -1,}, {+1, 0}, {0, +1}})  up , left , bottom and right respectively
add these to the current Node to visit the neighbors in all 4 directions
*/

package Graphs.Questions;

public class NumOfEnclavesDFS {
    public static void dfs(int[][] grid, int n, int m, boolean[][] visited, int row, int col) {
        if(row >= 0 && row < n && col >=0 && col < m && !visited[row][col] && 
        grid[row][col] == 1) {
            visited[row][col] = true; // means this '0' can be changes to 'X'
            
            dfs(grid, n, m, visited, row-1, col);
            dfs(grid, n, m, visited, row, col-1);
            dfs(grid, n, m, visited, row+1, col);
            dfs(grid, n, m, visited, row, col+1);
        }
    }
    
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < m; i++) {
            // first row
            if(visited[0][i] == false && grid[0][i] == 1) {
                dfs(grid, n, m, visited, 0, i);
            }
            
            // last row
            if(visited[n-1][i] == false && grid[n-1][i] == 1) {
                dfs(grid, n, m, visited, n-1, i);
            }
        }
        
        for(int i = 0; i < n; i++) {
            // first col
            if(visited[i][0] == false && grid[i][0] == 1) {
                dfs(grid, n, m, visited, i, 0);
            }
            
            // last col
            if(visited[i][m-1] == false && grid[i][m-1] == 1) {
                dfs(grid, n, m, visited, i, m-1);
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == false && grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
Time : O(n*m)
Space : O(n*m)
*/