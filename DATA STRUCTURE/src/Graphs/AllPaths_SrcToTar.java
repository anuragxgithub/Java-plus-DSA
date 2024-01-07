package Graphs;

import java.util.*;

public class AllPaths_SrcToTar {
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

    public static void createGraph(ArrayList<Edge>[] graph) {
        // first of all initialising each indices of array
        for(int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));
    }

    // O(V^V)
    public static void allPaths(ArrayList<Edge>[] graph, boolean[] visited, int current, int target, String path) {
        if(current == target) {
            System.out.println(path);
            return;
        }

        for(int i = 0; i < graph[current].size(); i++) {
            int neighbor = graph[current].get(i).dest;
            if(!visited[neighbor]) {
                visited[current] = true;        // should be inside this if block bcz make it true only when the neigbor is not visited yet other wise if you do it earlier in code backtracking of this would not be possible
                allPaths(graph, visited, neighbor, target, path+" -> "+neighbor);
                visited[current] = false;  // backtracking
            }
        }
    }

    public static void main(String[] args) {
        /*
              1 --------- 3
             /            | \
            0             |  5
             \            | /  \
              2 --------- 4     6

              This is unweighted graph but we will still take weight of each node as 1 to follow standard. We can skip it too.
        */
        int V = 7; 
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // we will use dfs algo to solve this problem (we are given with src and destination)
        allPaths(graph, new boolean[V], 0, 5, "0");

    }
} 
