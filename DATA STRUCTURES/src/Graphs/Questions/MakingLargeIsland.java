
/*
https://leetcode.com/problems/making-a-large-island/

Steps / Approach
Since here we will dynamically connect islands so we will use DSU.
Here also we will consider each cell as a single node. Because this is the nature of DSU.
1. First convert all the 1's into connected components. 
2. Union by size will help us here.
3. Now keep checking for each 0s and check for its neighbors if any of its neighor is 1 that mean it will 
   belong to some component (now simply add neighbor's root in a set data structure) do this for all its 4 neighbors.
   Why set data struc.?? bcz what if the left and right of any 0 has same component's 1 so we don't want to count
   size of 1 compo two times.
   Now keep checking for all 0s and lastly return the largestIsland size.

   Remember cover the edge case where all elements in grid is 1. 
*/

package Graphs.Questions;

import java.util.HashSet;
import java.util.Set;

public class MakingLargeIsland {
    static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        // finds the ultimate parent/root of i
        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);  // path compression
        }

        public void unionBySize(int rootX, int rootY) {
            if(size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                // for other two cases make rootX as root/repres. of rootY
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    static boolean isValid(int nr, int nc, int n) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }

    public int largestIsland(int[][] grid) {
        // First of all connect the connected islands
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[][] directions = new int[][] {{-1,0}, {0, -1}, {+1, 0}, {0, +1}};
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 0) continue;
                for(int[] d : directions) {
                    int nr = row + d[0];
                    int nc = col + d[1];
                    if(isValid(nr, nc, n) && grid[nr][nc] == 1) {
                        int nodeNo = (n*row)+col;
                        int adjNodeNo = (n*nr)+nc;
                        if(ds.find(nodeNo) != ds.find(adjNodeNo)) {
                            
                            ds.unionBySize(ds.find(nodeNo), ds.find(adjNodeNo));
                        }
                    }
                }
            }
        }
        // After this we have all the connected components pointing to their respective root
        // Now we will change all 0 to 1 one by one and find out the largest island formed
        int largestIsland = 0;
        Set<Integer> set = new HashSet<>(); //this will make sure we don't count the size of same component two so here if we add tow roots many times it will be 1 always
        //or more time
        
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 1) continue;
                for(int[] d : directions) {
                    int nr = row + d[0];
                    int nc = col + d[1];
                    if(isValid(nr, nc, n)) {
                        if(grid[nr][nc] == 1) {
                            int adjNodeNo = (n*nr)+nc;
                            set.add(ds.find(adjNodeNo)); // will store the root of the adjNode
                        }
                    }
                }
                int sizeTotal = 1;  // bcz we are adding island of size 1
                for(int root : set) {
                    sizeTotal += ds.size[root];
                }
                largestIsland = Math.max(sizeTotal, largestIsland);
                set.clear();
            }
        }
        // Edge case what if all the cell has 1??
        largestIsland = Math.max(ds.size[0], largestIsland);

        return largestIsland;
    }
}
// Time : O(n^2)
// Space : O(n^2)