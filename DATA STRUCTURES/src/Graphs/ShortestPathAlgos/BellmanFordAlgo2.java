

// In this algo everthing will be same only differece is that here we'll make edge list i.e, ArrayList of edges.
// In arraylist of edges one by one each edges are stored.

package Graphs.ShortestPathAlgos;

import java.util.ArrayList;

public class BellmanFordAlgo2 {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, -4));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 4, 4));
        edges.add(new Edge(4, 1, -1));
    }

    // O(V*E)
    public static void bellmanFordAlgo(ArrayList<Edge> edges, int src, int V) {
        int[] dist = new int[V];
        for(int i = 0; i < V; i++) {
            if(i != src) {
                dist[i] =  Integer.MAX_VALUE;
            }
        }

        for(int k = 0; k < V-1; k++) {    //O(V)
            for(Edge e : edges) {         // O(E)
                int u = e.src;
                int v = e.dest;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {      // relaxation
                    dist[v] = dist[u] + e.wt;
                }
            }
        }

        // detects -ve wt cycles
        for (Edge e : edges) {
            int u = e.src;
            int v = e.dest;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) { // relaxation
                System.out.println("\"Negative weight cycle exist.\"");
            }
        }

        for(int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        /*                  
         *          -> 1 <---------\
         *     (2) /   |            \ (-1)
         *        /    |             \
         *       0     |(-4)          -> 4
         *        \    |             /
         *     (4) \   ↓            / (4)
         *          -> 2 -------> 3
         *                  (2)
         */

         int V = 5;
         ArrayList<Edge> edges = new ArrayList<>();
         createGraph(edges);

        bellmanFordAlgo(edges, 0, V);
    }
}

// This one is easy to implement.