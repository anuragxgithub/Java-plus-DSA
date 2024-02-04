/*

https://leetcode.com/problems/path-with-maximum-gold/

*/

package Graphs.Questions;

public class MaxGoldPath {
    class Solution {

        public int dfs(int[][] grid, boolean[][] visited, int r, int c) {
            if(r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || visited[r][c] || grid[r][c] == 0) {
                return 0;
            }
            visited[r][c] = true;
            int golds = grid[r][c];
    
            golds += Math.max(dfs(grid,visited,r+1,c),
                             Math.max(dfs(grid,visited,r-1,c),
                             Math.max(dfs(grid,visited,r, c+1),
                             dfs(grid,visited,r,c-1))));
            visited[r][c] = false;
            return golds;
        }
    
        public int getMaximumGold(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int maxGold = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] != 0) {
                        int x = dfs(grid, new boolean[m][n], i, j);
                        maxGold = Math.max(x, maxGold);
                    }
                }
            }
            return maxGold;
        }
    }
}
