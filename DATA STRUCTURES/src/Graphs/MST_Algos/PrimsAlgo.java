/*
 * Note: You should be able to tell the the approach or dry the this algo because "Interviewer can ask this".
 * Use the set appraoch of understanding/teaching the Prim's Algorithm.
 * 
 * ----- Prims' Algorithm -----
 * 
 */

package Graphs.MST_Algos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
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

    static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        public Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }

    }

    // O(E logE)  bcz of pq and its sorting thing
    public static void primsAlgo(ArrayList<Edge>[] graph) {
        // since we need minimum cost edge first so pq (same as dijkstras algo)
        PriorityQueue<Pair> pq = new PriorityQueue<>();     // u can visualise it as non-mst set
        boolean[] visited = new boolean[graph.length];      // u can visualise it as mst set
        pq.add(new Pair(0, 0));  // initially choose any src node(as we can reach every other node from it) and add it to pq
        int mstCost = 0;
        //H.W ArrayList<Edge> store the actual edges instead of cost
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
    
            if(!visited[curr.node]) {
                visited[curr.node] = true;
                mstCost += curr.cost;

                for(int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    // first check the neighbor is visited or not then add it to the pq
                    if(!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Minimum cost of MST is : " + mstCost);
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

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);

        primsAlgo(graph);   // O(E logE)  bcz of pq and its sorting thing
    }
    
}
// H.W. : You may be asked to STORE THE MINIMUM EDGES TOO NOT ONLY COST THIS TIME INSTEAD OF COST CREATE A ARRAYLIST
// AND STORE THE EDGES THERE WHICH WOULD BE INCLUDED IN MST.