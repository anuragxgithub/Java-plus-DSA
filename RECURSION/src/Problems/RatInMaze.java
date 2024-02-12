/*
https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

Easy Peasy

TIME : there are n^2 cells and in the worst case we will travel all the cells and for each cell
we will in worst case have 3 choices to go.
so  3*3*3*3....n^2 times
Therefore, time complexity would be -->  O(3^n^2)

Space complexity :
O(m*n), Maximum Depth of the recursion tree(auxiliary space).
 */


package Problems;

import java.util.ArrayList;

public class RatInMaze {
    public static void findRoutes(int[][] grid, int n, int row, int col,
                                  String temp, ArrayList<String> ans, boolean[][] visited) {
        if(row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        if(row == n-1 && col == n-1) {
            ans.add(temp);
            return;
        }
        visited[row][col] = true;

        findRoutes(grid, n, row-1, col, temp+'U', ans, visited);
        findRoutes(grid, n, row, col-1, temp+'L', ans, visited);
        findRoutes(grid, n, row+1, col, temp+'D', ans, visited);
        findRoutes(grid, n, row, col+1, temp+'R', ans, visited);
        visited[row][col] = false;          // after all 4 directions got checked now backtrack
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        if(m[n-1][n-1] != 1) return new ArrayList<>();

        ArrayList<String> ans = new ArrayList<>();
        findRoutes(m, n, 0, 0, "", ans, new boolean[n][n]);
        return ans;
    }
}
