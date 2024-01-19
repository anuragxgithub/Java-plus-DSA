/*
 * KRUSKAL'S ALGORITHM
 * It is used to find the the MST of a graph.
 * 
 * It uses Disjoint Set Data Structure in its implementation
 * 
 * Simple algorithm just follow these steps to implement the Kruskal's Algo:
 * 1- Sort the edges in ascending order according to their weights.
 * 2- Pick the lowest wt edge first and check if it forms a cycle with the spanning tree formed
 *    so far if cycle not formed then include it. Else discard it.
 *    (We take levarge of disjoint set data struture to detect the cylce)
 * 3- Keep doing the step 2 until there are (V-1) edges in the spanning tree.
 *
 * 
 */

package Graphs.MST_Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KruskalsAlgo {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int V) {
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));  

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class DisjointSet {
        int parent[];
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for(int i = 0; i < n; i++) {
                parent[i] = i;      // each subset initially is its own representative/root
            }
        }

        // find the ultimate parent/root/representative of x
        public int find(int x) {
            if(parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);     // path compression   (idea is flatten the tree)
        }

        public void unionBySize(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;         // x and y belong to same component
            }

            if(size[rootY] > size[rootX]) {
                // make y as leader of x
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                // in other two cases
                parent[rootY] = rootX;
                size[rootX] += size[rootY]; 
            }
        }
    }

    public static void kruskalsAlgo(ArrayList<Edge>[] graph, int V) {
        //Step 1- Sort all the edges according to wt
        ArrayList<Edge> edges = new ArrayList<>();
        for(ArrayList<Edge> adjList : graph) {
            edges.addAll(adjList);
        }
        edges.sort(Comparator.comparingInt(e -> e.wt));     // you can also create custom comparator to compare objects (here we created a object e of class Edge thats why we are accessing it with e too)
        // now the edge have lowest wt is at 0th idx ...
        int edgesCount = 0;

        // Step 2- Initialize the Disjoint Set data structure
        DisjointSet ds = new DisjointSet(V);

        // Step 3- Iterate through the sorted edges and include them in the MST if no cycle is formed
        for(Edge e : edges) {
            int rootSrc = ds.find(e.src);
            int rootDest = ds.find(e.dest);

            if(rootSrc != rootDest) {  // belong to different component (if cond is true)
                System.out.println("Edge included in MST: " + e.src + "--" + e.dest + "(" + e.wt +")");
                // you can have your ans in any format as you want
                ds.unionBySize(rootSrc, rootDest);  // combine the components
                edgesCount++;
            }   
            // If the above if is not execute that means cycle was detected so skipped it
            if(edgesCount == V-1) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int V = 4;
        /*
        *            0         
        *         /  |  \ 
        *   (10) /   |   \(15)
        *       /    |    \
        *      1     |30   2
        *       \    |    /
        *   (40) \   |   / (50)
        *         \  |  /
        *            3
        */
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);

        kruskalsAlgo(graph, V);
    }
}