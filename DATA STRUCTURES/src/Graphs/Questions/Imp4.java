
/*

https://leetcode.com/problems/cheapest-flights-within-k-stops/

Use pen and paper easy.

Important algo many webstes use this.
*/


package Graphs.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Imp4 {
    static class Edge {
        int dest;
        int wt;

        public Edge(int d, int w) {
            this.dest = d;
            this.wt = w;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Creating a adjacency list
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][1], flights[i][2]));
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {src, 0, 0});   // {node, cost(price), stopsTaken}
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) if(i != src) prices[i] = (int)(1e9);

        while(!q.isEmpty()) {
            int[] info = q.remove();
            int curr = info[0];
            int cost = info[1];
            int stops = info[2];

            if(stops > k) break;  // at this point the curr node may be the dest (or any node) but we don't need to move further bcz we can't affort extra stop now
            // visit the neighors
            for(int i = 0; i < graph[curr].size(); i++) {
                int neigh = graph[curr].get(i).dest;
                int edgeWt = graph[curr].get(i).wt;
            
                if(cost + edgeWt < prices[neigh] && stops <= k) {
                    prices[neigh] = cost + edgeWt;
                    q.add(new int[] {neigh, prices[neigh], stops+1});
                }
//NOTE: you can't use prices[curr] instead of 'cost' while relaxation bcz it may be possible that cost 
//of that node in future got updated for different path. So using cost bcz it will remain same
            }
        }
        if(prices[dst] != (int)(1e9)) return prices[dst];
        return -1;
    }

    public static void main(String[] args) {
        int[][] flights = new int[][] {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        System.out.println(findCheapestPrice(4, flights, 0, 3, 1));
    }
}
/*
Time : O(E) {flights.size()}
Space: O(n)
*/