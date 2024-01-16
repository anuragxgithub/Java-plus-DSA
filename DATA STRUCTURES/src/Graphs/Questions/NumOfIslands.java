
/*
 * https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
 * 
 * In this question we have to visualise cell as a node/vertex.
 */
package Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslands {
    static class Pair {
        int row;
        int col;

        public Pair(int r , int c) {
            this.row = r;
            this.col = c;
        }
    }
    public static void bfs(char[][] grid, boolean[][] visited,  int i, int j) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;
        int m = grid.length;
        int n = grid[0].length;

        while(!q.isEmpty()) {
            int currRow = q.peek().row;
            int currCol = q.peek().col;
            q.poll();

            // traverse the neighbors and mark them as visited if its a land
            for(int row = -1; row <= 1; row++) {        // another way to visit all directions can be by the appraoch used in NumOfIslands2.java
                for(int col = -1; col <= 1; col++) {
                    int neighborRow = currRow + row;
                    int neighborCol = currCol + col; 
                    if(neighborCol >= 0 && neighborCol < n && neighborRow >= 0 && neighborRow < m && 
                       !visited[neighborRow][neighborCol] && grid[neighborRow][neighborCol] == '1') {
                        visited[neighborRow][neighborCol] = true;
                        q.add(new Pair(neighborRow, neighborCol));
                       }
                }
            }
        }
    }
    
    public static int numIslands(char[][] grid) {
        // APPROACH 2- BFS  (1st was union find in DisjointSet directory)

        int m = grid.length;
        int n = grid[0].length;          // m*n grid is given
        boolean[][] visited = new boolean[m][n];
        int cnt = 0; 
        for(int rows = 0; rows < m; rows++) {
            for(int cols = 0; cols < n; cols++) {
                if(!visited[rows][cols] && grid[rows][cols] == '1') {
                    cnt++;          // count the connected component
                    bfs(grid, visited, rows, cols);
                }
            }
        }
        return cnt;
    }

// ---------------------------------- HERE DFS APPROACH ------------------------------------------------//
    
    public static void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length 
        || grid[row][col] != '1' || visited[row][col] == true) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row-1, col);    // top
        dfs(grid, visited, row-1, col-1);  // top left diagonal
        dfs(grid, visited, row, col-1);    // left
        dfs(grid, visited, row+1, col-1);  // bottom left diagonal
        dfs(grid, visited, row, col+1);    // right
        dfs(grid, visited, row-1, col+1);  // top right diagonal
        dfs(grid, visited, row+1, col);    // bottom      
        dfs(grid, visited, row+1, col+1);  // bottom right diagonal      
    }

    public static int numIslandsDFS(char[][] grid) {
        // APPROACH 3- DFS

        int m = grid.length;
        int n = grid[0].length;          // m*n grid is given
        boolean[][] visited = new boolean[m][n];
        int cnt = 0; 
        for(int rows = 0; rows < m; rows++) {
            for(int cols = 0; cols < n; cols++) {
                if(!visited[rows][cols] && grid[rows][cols] == '1') {
                    cnt++;          // count the connected component
                    dfs(grid, visited, rows, cols);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
        System.out.println(numIslandsDFS(grid));
    }
}
/*
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */