
// https://leetcode.com/problems/number-of-provinces/description/

// Simple approach, if different nodes are connected to each other then it will be counted as 1 province.
// and one node connedted to itself then also it is counted as 1 province

// In these types of questions number of provinces and number of islands where union find
// algo is needed you should be able to draw the tree and visualise it.

package DisjointSetUnion;

import java.util.Arrays;

public class LeetCode547 {
    static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n];       // 1 BASED INDEXING
            size = new int[n];
            for(int i = 0; i < n; i++) {       
                parent[i] = i;      // as isConnected[i][i] == 1
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
                // for other 2 cases make x as leader of y
                parent[rootY] = parent[rootX];
                size[rootX] += size[rootY];
            }

        }
    }

    public static int findCircleNum(int[][] isConnected) {
        // Appraoch 1- Union Find

        int n = isConnected.length;   
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j] == 1) {
                    // i and j are directly connected
                    ds.unionBySize(i, j);
                }
            }
        }
        // Once the components are connected do the following
        // Count unique roots (representing provinces)
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(ds.find(i) == i) cnt++;  
            // NOTE: in if, you can do like this also (ds.parent[i] == i) bcz
            // after path compression each node will be directly storing its root / ultimate parent.
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        /*
         *     1  
         *     ↑     3
         *     2
         * 
         * So there will be 2 provinces city 1 and 2 and other province is city 3
         */

        System.out.println(findCircleNum(isConnected));
    }

    // NOTE: IN THIS ONE WE DON'T NEED TO IMPLEMENT THINGS BASED ON 1 IDEXED THINGS WILL
    // NOT AFFECT IF I RPRESENT 1,2,3 AS 0,1,2
    
}