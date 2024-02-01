/*

https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

-> Imagine each connected stones(present in same row or column) as nodes of a connected component
   in graph.
-> In each connected component of graph we can remove at most (n-1) stone. [where n -> total no of
   nodes/vertices/stones]
-> We will treat each row as a node. Eg : 0th row is 0 node ;  1st row is 1st node and so on.
   Also we will treat each col as node but we'll shift the coordinates for all col by
   (col+n)  n is the total no of row and col can be 0,1,2 and so onn..
   So lets say we have 4 rows total(0,1,2,3) so the 0th col will be (0+4) i.e, 5th node and 1st col
   will be 6th node and so on. Why like this? bcz to prevent the overlapping of row num with col num.

   All the nodes present in same col and row will be part of the same component.

-> Now lets say we have total x stones. And our graph has 4 components.
    C1              C2               C3              C4
(x1 nodes/stones) (x2 nodes)      (x3 nodes)      (x4 nodes)

So total nodes/stones that can be removed from the graph is:
(x1-1) + (x2-1) + (x3-1) + (x4 -1)                      {x1+x2+x3+x4 = x}
-> (x1 + x2 + x3 + x4) - 1 -1 -1 -1
-> (x1 + x2 + x3 + x4) - (1+1+1+1)
-> [[     ans = x - num of connected componets    ]]

*/

package Graphs.Questions;

import java.util.HashMap;
import java.util.Map;

public class MaxStoneRemoval {
    static class DisjointSet {
        int[] parent;
        int[] size;
        
        public DisjointSet(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        // finds the root of i
        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }
        
        public void unionBySize(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if(rootX != rootY) {
                if(size[rootY] > size[rootX]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                } else {
                    // in other two cases
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                }
            }
        }
    }

    int maxRemove(int[][] stones, int n) {
        // here are not given the size of the grid lets find out
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow+1 + maxCol+1); 
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;  // shifting thing of col coordinate
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int cnt = 0;        //onnected components count
        for(Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if(ds.find(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n - cnt;
    }
}

// time complexity : O(n + mα(n))    or O(n + m*4α)
// space complexity : O(n + m)