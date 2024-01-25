
/*

https://leetcode.com/problems/redundant-connection/
Note here we have to return the cycle forming edge which comes last in the input of edges[][] so keep findding
for the cycle using union find and return the last edge which formed cycle. Simple.
*/

package Graphs.Questions;

public class RedundantConnection {
    static class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int size) {
            parent = new int[size];
            rank = new int[size];   // initially rank would be 0 for each node
            for(int i = 0; i < size; i++) {
                parent[i] = i;   // initially root/represen. of each subset is the subset itself
            }
        }
        // finds the root/represen. of i
        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);   // path compression
        }

        public void unionByRank(int rootX, int rootY) {  // here directly taking roots of X and y
            if(rank[rootX] < rank[rootY]) {
                // make y as leader of x
                parent[rootX] = rootY;
            } else if(rank[rootX] > rank[rootY]) {
                // make x as leader of y
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;  // in this case your choice
                rank[rootX]++;  // bcz it is where we are combining
            }
        }
    }


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] res = new int[2];
        // Here we will be using DisjointSet Data Structure
        DisjointSet ds = new DisjointSet(n+1);   // because 1 based indexing
        for(int[] edge : edges) {
            int rootX = ds.find(edge[0]);
            int rootY = ds.find(edge[1]);

            if(rootX == rootY) {  // cycle exist
                res[0] = edge[0];
                res[1] = edge[1];
            } else {
                ds.unionByRank(rootX, rootY);
            }
        }
        return res;
    }
}
/*
Time : almost O(n)  or O(n*4alpha)  or O(n*logn) where logn is amoritzed
Space : O(n)
*/