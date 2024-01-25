

/*
https://leetcode.com/problems/path-with-maximum-probability/

EASY PEASY DID IT EASILY JUST PAY EXTRA ATTENTION
SIMPLE DIJSKTRA ALGO WILL BE USED But here we need longest path.
*/

package Graphs.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraREVERSE {
    static class Edge {
        int dest;
        double wt;

        public Edge(int d, double wt) {
            this.dest = d;
            this.wt = wt;
        }

    }
    static class Pair implements Comparable<Pair> {
        int node;
        double probabSofar;
        
        public Pair(int n, double d) {
            this.node = n;
            this.probabSofar = d;
        }
        
        @Override
        public int compareTo(Pair p2) {
            return Double.compare(p2.probabSofar, this.probabSofar);  // sorts the Prob in DESC. order
        }
    }
    
    public static double dijkstraAlgo(ArrayList<Edge>[] graph, int V, int src, int end) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair (src,1.0));   // bcz probab of traver. from src to src is 1
        double[] probab = new double[V];
        Arrays.fill(probab, 0.0); // minimum prob is 0
        probab[src] = 1.0;
        
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            int curr = p.node;
            if(curr == end) return probab[end]; 
            // visit the neighbors and update the their distances with relaxation
            for(int i = 0; i < graph[curr].size(); i++) {
                int neigh = graph[curr].get(i).dest;
                double edgeWt = graph[curr].get(i).wt;
                    
                if(probab[curr] * edgeWt > probab[neigh]) {   // relaxation
                    probab[neigh] = probab[curr] * edgeWt;
                    pq.add(new Pair(neigh, probab[neigh]));
                }
            }
        }
        return probab[end];
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Creating adjacency list
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new Edge(edges[i][1], succProb[i]));
            graph[edges[i][1]].add(new Edge(edges[i][0], succProb[i]));
            // undirected don't forget
        }

        double ans = dijkstraAlgo(graph, n, start_node, end_node);
        return ans;
    }
}
/*
Time complexity: O((V+E)logV))
Space complexity: O(V+E) 
*/