
/*

https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
https://www.geeksforgeeks.org/problems/connecting-the-graph/1

We know if we have 2 things "number of connected components" and "number of extra edges" we can ans this question.
lets say there are n connected components then if we have extra edges >= n-1 we can connect the graph.
Always min. number of operations to connect the graph would be conncected comps. -1 bcz minimun tht many edge we require.

EXTRA EDGES WILL BE THE EDGE WHICH IS FORMING CYCLE. WE CAN CALCULATE IT USING DSU.
CONNECTED COMPONENTS WE KNOW ALREADY WE CAN CALCULATE IT USING DSU 
*/

package Graphs.Questions;

public class ConnectingGraph {

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

    public int Solve(int n, int[][] edge) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for(int[] e : edge) {
            int rootX = ds.find(e[0]);
            int rootY = ds.find(e[1]);

            if(rootX == rootY) {
                extraEdges++;
            } else {
                ds.unionBySize(rootX, rootY);
            }
        }
        // Now find the connected components (count the number of representatives or root)
        int cc = 0;
        for(int i = 0; i < n; i++) {
            if(ds.parent[i] == i) {
                cc++;
            }
        }

        if(extraEdges >=  cc-1) {
            return cc-1;            // min number of operations required would be connected com. -1
        }
        return -1;
    }
}
