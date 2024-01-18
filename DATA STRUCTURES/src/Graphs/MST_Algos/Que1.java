
/*
 * NOTE: THE OLDER VESION OF THIS QUESTION ON GFG WAS LITTLE BIT DIFFERENT. ALL THE SOLUTIONS OVER THE INTERNET
 * IS OF THAT VERSION OF QUESTION BUT NOW THAT WAY WILL NOT WORK. PREVIOUSLY MATRIX (int[][]) was not given
 * instead arraylist of arraylsit of array list given that was easy to solve but now the matrix is given.
 * 
 * So this is my own implementation. I don't think we can also solve it without creating adjacency list 
 * BUT IT WAS 100% ACCURACY ON GFG :)
 */
package Graphs.MST_Algos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Que1 {
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
    
    public static int primsAlgo(ArrayList<Edge>[] graph) {
        // since we need minimum cost edge first so pq (same as dijkstras algo)
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        boolean[] visited = new boolean[graph.length];  
        pq.add(new Pair(0, 0));  // initially choose any src node(as we can reach every other node from it) and add it to pq
        int mstCost = 0;
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
    
            if(!visited[curr.node]) {
                visited[curr.node] = true;
                mstCost += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        return mstCost;
    }
    
    // User function Template for Java
	static int spanningTree(int V, int E, int edges[][]){
        @SuppressWarnings("unchecked")
	    ArrayList<Edge>[] graph = new ArrayList[V];
	    for(int i = 0; i < V; i++) {
	        graph[i] = new ArrayList<>();
	    }
	    for(int[] edge : edges) {
	        graph[edge[0]].add(new Edge(edge[0], edge[1], edge[2]));
	        graph[edge[1]].add(new Edge(edge[1], edge[0], edge[2]));  // bcz undirected graph
            // we have to do this bcz according to given matrix we can go to 1 to 2 but not 2 to 1
	    }
	     return primsAlgo(graph);
	}

    public static void main(String[] args) {
        int[][] edges = {{0,1,5}, {1,2,3}, {0,2,1}};
        System.out.println(spanningTree(3, -1, edges));


    }
}

/*
 Time : O(E log V)
 The space complexity is O(V + E)
*/