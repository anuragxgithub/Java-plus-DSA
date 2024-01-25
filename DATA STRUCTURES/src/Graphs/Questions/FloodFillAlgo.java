

// https://leetcode.com/problems/flood-fill/
// Easy Peasy..
package Graphs.Questions;

public class FloodFillAlgo {
    public int[][] dfs(int[][] image, int sr, int sc, int color, int sPixelClr, boolean[][] visited) {
        if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length &&
        image[sr][sc] == sPixelClr && !visited[sr][sc]) {
            image[sr][sc] = color;      // color the pixel with given colr
            visited[sr][sc] = true;
        
             // Recursively call dfs for the neighboring pixels
            dfs(image, sr-1, sc, color, sPixelClr, visited);  // up
            dfs(image, sr, sc-1, color, sPixelClr, visited);  // left
            dfs(image, sr+1, sc, color, sPixelClr, visited);  // bottom
            dfs(image, sr, sc+1, color, sPixelClr, visited);  // right
        }
        return image;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sPixelClr = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        return dfs(image, sr, sc, color, sPixelClr, visited);
    }
}
// Time : O(m*n)
// Space : O(m*n)