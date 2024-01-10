package Graphs;
// https://leetcode.com/problems/find-if-path-exists-in-graph/

// ---------- SECOND APPRAOCH ---------- //
    // IF WE OBSERVE, THEN WE CAN SAY THAT IF OUR SOURCE AND DESTINATION ARE IN DISJOINT GRAPHS ONLY THEN THERE WILL
    // BE NO PATH FROM SOURCE TO DESTINATION SO WE CAN APPLY "DISJOINT SET UNION" DATA STRUCTURE HERE THAT WILL BE MORE
    // EFFICIENT.

/*
APPRAOCH 2- USING DISJOINT SET UNION DATA STRUCTURE EFFICIENT ONE 
Time: O(n * 4α) ~ O(n)
Space: O(n)
*/
import java.util.Arrays;

public class FindPath_IfExist2 {
    static class DisjointSet {
        private int[] parent;
        private int[] size;
        
        public DisjointSet(int n) {         
            parent = new int[n];
            // initially every element is representative of its own set
            for(int i = 0; i < n; i++) {                    // O(n)
                parent[i] = i;
            }
            
            size = new int[n];
            Arrays.fill(size, 1); // initially every set has size of 1
        }
    
        // finds the root/representative of i
        public int find(int i) {                            // almost O(1)
            if(parent[i] == i) {
                return i;
            }
            
            return parent[i] = find(parent[i]);   // path compression 
        }
        
        // merge/unite two nodes
        public void unionBySize(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if(rootX == rootY) { 
                return; // both node belong to same set
            }
            
            if(size[rootY] > size[rootX]) {
                // make y leader of x
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
            else {
                // make x as leader of y in other two cases
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }


    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet ds = new DisjointSet(n);

        for(int[] edge : edges) {
        // since edges[i].length == 2
            int v1 = edge[0]; 
            int v2 = edge[1];
            
            ds.unionBySize(v1, v2);
            
        }
        // if root of souce node/vertex and destination node/vertex is same then not disjoint set
        // hence path will exist.
        if(ds.find(source) == ds.find(destination)) {
            return true;
        }

        return false;   // if disjoint then path does not exist
    }





    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1}, {2,3}};
        int start = 0;
        int end = 3;

        boolean isValidPath = validPath(n, edges, start, end);
        System.out.println(isValidPath);
    }
}
