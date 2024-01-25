
/*
Here we will find the shortest Path of a DAG (DIRECTED ACYCLIC GRAPH) using TOPOLOGICAL SORT.
As we know we can perform TopoSort using BFS(KAHN'S ALGO) OR WITH DFS. Here I will use DFS approach.

SHORTEST PATH USING TOPO SORT IS OF TWO STEP ALGO:
1. Perform topo sort and take vertices in the stack in topological order.
2. Now create a dist[] array to store the shortest distances of each node form the src node. You can select any src node
   Initially distance of each node from src node is "infinity", only distance of src node will be 0 bcz of obvious thing
   Now for each node in stack visit its neighbors and update the distance of neighbor by performing relaxation
   dis[u] + wt < dist[v]; . 
   Simple.
*/

package Graphs.ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class UsingTopoSort {
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
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        /*                 (7)
         *          -> 1 -------> 3
         *     (2) /   |          ↑ \ (1)
         *        /    |          |  \
         *       0     |(1)    (2)|   -> 5
         *        \    |          |  /
         *     (4) \   ↓          | / (5)
         *          -> 2 -------> 4
         *                 (3)
         */

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        // no outgoing edge from vertex 5
    }

    // O(V+E)
    public static void topoSort(ArrayList<Edge>[] graph, boolean[] visited, int curr, Stack<Integer> stack) {
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            int neigh = graph[curr].get(i).dest;
            if(!visited[neigh]) {
                topoSort(graph, visited, neigh, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < V; i++) {  // in dfs topo sort we have to check for all components
            if(!visited[i]) {
                topoSort(graph, visited, i, stack);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // Now we have topological order of our vertices in the stack
        // Now mark the dist[] of src node as 0 bcz of obvious reason. Here I am taking my src node as 1
        // so I will make dist[1] = 0. Now we need to find shortest dis of all node from src node.
        dist[1] = 0;
        
        // Now while the stack don't become empty pop out nodes from it and check for their neighbor nodes
        // and update their distance by performing RELAXATION
        while(!stack.isEmpty()) {
            int curr = stack.pop();

            for(int i = 0; i < graph[curr].size(); i++) {
                int neigh = graph[curr].get(i).dest;
                int u = curr;
                int v = neigh;
                int wt = graph[curr].get(i).wt;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;        // relaxation
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }
}
/*
Time and Space complexity analysis:
TIME : O(V+E) for topoSort and O(V+E) for relaxation of vertices  so ~ O(V+E)
Space : O(V+E) if we consider the adjacency list space otherwise O(V)

NOTE: IN THE CASE OF DAGs TOPO SORT WAY OF FINDING SHORTEST PATH IS MORE EFFICIENT. 
BCZ TIME COMP. OF STANDARD ALGO LIKE DIJKSTRA IS O(E + E(logV))

https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?  ⭐⭐
Here i modified the edge class.
*/