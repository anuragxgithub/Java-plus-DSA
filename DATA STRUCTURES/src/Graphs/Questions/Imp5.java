/*

https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

First understand the solution.

Due to large testcases we have to do multiple conversion. It can be improved may be.
*/


package Graphs.Questions;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Imp5 {
    static class Edge {
        long dest;
        long wt;

        public Edge(long d, long w) {
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        long node;
        long dist;

        public Pair(long n, long d) {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return (int)this.dist - (int)p2.dist;
        }
    }

    public int countPaths(int n, int[][] roads) {
        // creating adjacency list
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int[] r : roads) {
            graph[r[0]].add(new Edge(r[1], r[2]));
            graph[r[1]].add(new Edge(r[0], r[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));    // {node, dist}
        long[] ways = new long[n];
        long[] dist = new long[n];
        for(int i=0; i<n; i++) {
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        long mod = (int)(1e9+7);

        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            long node = p.node;
            long d = p.dist;

            // visit the neighbors
            for(Edge e : graph[(int)node]) {
                long neigh = e.dest;
                long edgeWt = e.wt;

                if(d + edgeWt < dist[(int)neigh]) {
                    dist[(int)neigh] = d + edgeWt;
                    pq.add(new Pair(neigh, d + edgeWt));
                    ways[(int)neigh] = ways[(int)node];
                } else if(d + edgeWt == dist[(int)neigh]) {
                    ways[(int)neigh] = (ways[(int)neigh]+ways[(int)node])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}
