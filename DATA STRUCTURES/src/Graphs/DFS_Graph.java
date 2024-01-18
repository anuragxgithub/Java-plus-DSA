/*
Graph here is implemented using Adjacency List (Array of ArrayList).
DFS
Depth-First Search (DFS) is a graph traversal algorithm that systematically explores as deeply as possible along each
branch of a graph before backtracking. It starts from a chosen vertex and visits adjacent vertices, moving deeper into the graph
until there are no more unvisited vertices. If a dead-end is reached, the algorithm backtracks to the most recent unexplored
branch and continues the exploration. DFS can be implemented using recursion or a stack and is used for tasks like finding
connected components, topological sorting, and pathfinding in graphs.

Here's a step-by-step explanation of DFS in the context of a graph:

START AT A SOURCE NODE:
Choose a starting vertex (or node) as the source node.
Mark the source node as visited.

EXPLORE ADJACENT NODES:
Visit an unvisited neighbor of the current node. If there are multiple neighbors, choose one arbitrarily.
Mark the visited node as visited.
Recursively apply the same process to the chosen neighbor.

BACKTRACK:
If a node has no unvisited neighbors, backtrack to the previous node.
Repeat the process for the previous node, exploring other unvisited neighbors if available.

CONTINUE EXPLORATION:
Continue the process until all nodes in the graph are visited.

OR JUST REMEMBER ONE THING KEEP GOING FOR THE NEXT NEIGHBOUR OF EACH VERTEX AND CHECK WHETHER IT IS VISITED OR NOT. KEEP
CHECKING UNTIL ALL VERTICES ARE VISITED.

NOTE: ⚠️
There can be multiple valid orders of visiting nodes in a Depth-First Search (DFS) if the source node is the same.
The order in which DFS visits nodes depends on the specific implementation details, such as the order in which neighbors
are processed and the data structures used for tracking visited nodes.

*/ 

package Graphs;

import java.util.*;

public class DFS_Graph {
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

    // DFS USING RECURSION
    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int curr) {  // can also be implemented using stack as recursion itself represt stack d.s.
        System.out.print(curr + " ");
        visited[curr] = true;
        // find the neighbour and call dfs for it so that it also got visited
        for(int i = 0; i < graph[curr].size(); i++) {  // till number of edges connected to current graph
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) {              // check whether first neighbor is already visited or not
                dfs(graph, visited, e.dest);
            }
        }
    }

    // DFS USING STACK -1       (This is my own implementation)
    public static void dfsUsingStack(ArrayList<Edge>[] graph, boolean[] visited, int curr) {  // O(V+E)
        Stack<Integer> stack = new Stack<>();
        stack.push(curr);
        System.out.print(curr + " ");
        visited[curr] = true;

        while(!stack.isEmpty()) {
            for(int i = 0; i < graph[curr].size();) {
                Edge e = graph[curr].get(i);
                if(!visited[e.dest]) {
                    System.out.print(e.dest + " ");
                    visited[e.dest] = true;
                    stack.push(e.dest);
                    i = 0;
                    curr = e.dest;
                } else {
                    i++;
                }
            }
            if(!stack.isEmpty()) {
                curr = stack.pop();
            }
        }
    }

    // DFS USING STACK -2
    public static void DFS_Stack(ArrayList<Edge>[] graph, int curr) {   // O(V+E)
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        // Mark the current node as visited and push it onto the stack
        visited[curr] = true;
        stack.push(curr);

        while (!stack.isEmpty()) {
            // Pop a vertex from the stack and print it
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            // Get all adjacent vertices of the popped vertex
            // If an adjacent vertex has not been visited, mark it as visited and push it onto the stack
            for (Edge e : graph[currentVertex]) {
                int neighbor = e.dest;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
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
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        boolean[] visited = new boolean[V];
        dfs(graph, visited, 0);  // 0 is current node/vertex    Time : O(v+e) where, vertices and edges
        System.out.println();
        boolean[] visited2 = new boolean[V];
        dfsUsingStack(graph, visited2, 0);
        System.out.println();
        DFS_Stack(graph, 0);
        }
}
