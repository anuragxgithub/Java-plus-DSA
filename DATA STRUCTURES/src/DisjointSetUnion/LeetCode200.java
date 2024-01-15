
// https://leetcode.com/problems/number-of-islands/description/

// To solve this question you should know how to convert a 2D coordinate of a grid/2D
// matrix into 1D idx
// using the formula  (i * cols + j)
// basically it assigns a number to each element which will help us to use it as
// nodes here in this problem while solving it using Union find method.
/*
 * for eg:
 *          {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}

            element at grid[0][3] will have 1D indx which would be 3
            and grid[1][2] 's  1D idx would be : 7
 */


package DisjointSetUnion;

import java.util.Arrays;

public class LeetCode200 {
    static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {       
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }

        // to find the ultimate parent/ root of i
        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }   
            return parent[i] = find(parent[i]);     // path compression
        }

        public void unionBySize(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;     // they belong to same set/graph
            }

            if(size[rootY] > size[rootX]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                // for other 2 cases, make x as leader of y
                parent[rootY] = parent[rootX];
                size[rootX] += size[rootY];
            }

        }
    }

    public static int numIslands(char[][] grid) {
        // APPRAOCH 1- UNION FIND

        int rows = grid.length;
        int cols = grid[0].length;
        DisjointSet ds = new DisjointSet(rows*cols);

        // O(m*n)
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {     // bcz grid is of m*n
                if(grid[i][j] == '1') {
                    // Convert 2D coordinates to 1D index
                    int index = i * cols + j;

                    // Union with righ cell
                    if(j+1 < cols && grid[i][j+1] == '1') {
                        ds.unionBySize(index, index+1);
                    }

                    // union with bottom cell
                    if(i+1 < rows && grid[i+1][j] == '1') {
                        ds.unionBySize(index, (i+1)*cols+j);   // NOTE: [(i+1) * index != (i+1)*cols+j]
                    }
                }
            }
        }

        // Count unique roots (representing islands)
        int uniqueRoots = 0;
        for(int i = 0; i<rows; i++) {
            for(int j = 0; j<cols; j++) {
                if(grid[i][j] == '1' && ds.find(i*cols+j) == i*cols+j) {
                    uniqueRoots++;
                }
            }
        }
        return uniqueRoots;
    }

    public static void main(String[] args) {
        
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
      
    }
}

 /*
 Time: 
 DisjointSet initialization: O(n)
 Union-Find Operations: O(rows * cols * 4α).   ~  O(rows * cols).
 Counting Unique Roots: O(rows * cols * 4α).   ~  O(rows * cols).

 Overall Time : O(n + row*cols)

 Space:
 O(rows*cols)
 */ 
