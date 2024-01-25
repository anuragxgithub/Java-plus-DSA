
/*
https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?
Easy peasy
*/

package Graphs.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUG {
    // static class Pair {
    //     int node;
    //     int distSofar;
        
    //     public Pair(int node, int d) {
    //         this.node = node;
    //         this.distSofar = d;
    //     }
    // }
    // public int[] shortestPath(int[][] edges,int n,int m ,int src) {
    //     // create a adjacency list
    //     ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //     for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
    //     for(int[] edge : edges) {
    //         graph.get(edge[0]).add(edge[1]);
    //         graph.get(edge[1]).add(edge[0]);
    //     }
        
    //     boolean[] visited = new boolean[n];
    //     int[] dist = new int[n];
    //     for(int i = 0; i < n; i++) {
    //         if(i!=src) dist[i] = Integer.MAX_VALUE;
    //     }
    //     Queue<Pair> q = new LinkedList<>();
    //     q.add(new Pair(src,0));  // distance of reaching src from src will be 0
        
    //     while(!q.isEmpty()) {
    //         Pair curr = q.remove();
    //         visited[curr.node] = true;
    //         // visit all the neighbors
    //         for(int i = 0; i < graph.get(curr.node).size(); i++) {
    //             int neigh = graph.get(curr.node).get(i);
    //             if(!visited[neigh]) {
    //                 if(dist[neigh] > curr.distSofar+1) {
    //                     dist[neigh] = curr.distSofar+1;
    //                 }
    //                 q.add(new Pair(neigh, curr.distSofar+1));
    //             }
    //         }
    //     }
    //     for(int i = 0; i < n; i++) {
    //         if(visited[i] == false) {
    //             dist[i] = -1;
    //         }    
    //     }
    //     return dist;
    // }
    
    //SIMPLE APPRAOCH WITHOUT PAIR CLASS
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // create a adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) {
            if(i!=src) dist[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src);  
        
        while(!q.isEmpty()) {
            int curr = q.remove();
            visited[curr] = true;
            // visit all the neighbors
            for(int i = 0; i < graph.get(curr).size(); i++) {
                int neigh = graph.get(curr).get(i);
                if(!visited[neigh]) {
                    if(dist[neigh] > dist[curr]+1) {
                        dist[neigh] = dist[curr]+1;
                    }
                    q.add(neigh);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                dist[i] = -1;
            }    
        }
        return dist;
    }
}

// TIME : O(V+E)   SIMPLE BFS
// SPACE : O(V+E)   DUE TO ADJACENCY LIST