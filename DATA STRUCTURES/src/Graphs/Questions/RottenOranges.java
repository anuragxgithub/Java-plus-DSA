
/*

https://leetcode.com/problems/rotting-oranges/

Here we need to visit or check same step at same time so we will use BFS.
Easy Peasy
*/

package Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    // static class C {
    //     // represent coordinate
    //     int row;
    //     int col;
    //     int time;

    //     public C(int r, int c, int t) {
    //         this.row = r;
    //         this.col = c;
    //         this.time = t;
    //     }

    // }

    // public static int bfs(int[][] grid, int m, int n) {
    //     Queue<C> q = new LinkedList<>();
    //     boolean[] existingSimul = new boolean[m*n];
    //     int DOBinQ = 0;
    //     for(int i = 0; i < m; i++) {
    //         for(int j = 0; j < n; j++) {
    //             if(grid[i][j] == 2) {
    //                 q.add(new C(i, j, DOBinQ));
    //             }
    //         }
    //     }
    //     DOBinQ++;
    //     int time = 0;
    //     // bfs
    //     while(!q.isEmpty()) {
    //         C curr = q.remove();
    //         int currRow = curr.row;
    //         int currCol = curr.col;
    //         int madeRotten = 0;
    //         for(int[] direction : new int[][] {{-1,0},{0,-1},{0,1},{1,0}}) {
    //             int neigRow = currRow + direction[0];
    //             int neigCol = currCol + direction[1];
    //             if(neigRow >= 0 && neigRow < m && neigCol >= 0 && neigCol < n && 
    //             grid[neigRow][neigCol] == 1) {
    //                 madeRotten++;
    //                 grid[neigRow][neigCol] = 2;
    //                 if(existingSimul[curr.time] == false) {
    //                     DOBinQ++;
    //                 }
    //                 q.add(new C(neigRow, neigCol, DOBinQ));
    //                 if(madeRotten == 1 && !existingSimul[curr.time]) {
    //                     time++;
    //                     existingSimul[curr.time] = true;
    //                 }
    //             }
    //         }
            
    //     }
    //     for(int[] row : grid) {
    //         for(int j = 0; j < n; j++) {
    //             if(row[j] == 1) {
    //                 return -1;
    //             }
    //         }
    //     }
    //     return time;

    // }

    // // Funtion given by leetcode
    // public static int orangesRotting(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     return bfs(grid, m , n);
    // }

    /*
     * The above one is my own implementation it can be optimised little bit and can be done in clear way which is 
     * implemented below
    */


    
    // Funtion given by leetcode
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();    // {row, col, time}   you can use Pair class too
        boolean[][] visited = new boolean[m][n];

        // push the rooten orages in queue if any with time 0
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[] {i, j, 0});
                }
            }
        }
        int time = 0;

        int[][] directions = new int[][] {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
        // BFS
        while(!q.isEmpty()) {
            int[] info = q.remove();
            int r = info[0];
            int c = info[1];
            int t = info[2];
            time = Math.max(time, t);
            // visit the neighbors 4 directionally
            for(int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    q.add(new int[] {nr, nc, t+1});
                    visited[nr][nc] = true;   // marking only the 1's that I visited 
                }
            }
        }
        // check if any fresh orange is remaining or not
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && visited[i][j] == false) {
                    return -1; 
                }
            }
        }
        return time;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
// Time : O(n*m)
// Space : O(n*m)