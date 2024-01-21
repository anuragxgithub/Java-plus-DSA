
/*
 * KOSARAJU's ALGORITHM is used to calculate number of Strongly connected Components in Directed Graph Obviously
 * b/z in indirected graph every connected component is strongly connected.
 * 
💠 KOSARAJU's Algorithm Explained: Finding Strongly Connected Components 💠
Kosaraju's Algorithm is a powerful tool for identifying and counting the number of Strongly Connected Components
(SCCs) in a Directed Graph. In directed graphs, not all connected components are strongly connected, making this
algorithm particularly valuable.
Obviously in Undirected Graphs all components are already strongly connected.

💠 Understanding Strongly Connected Components 💠
In graph theory, a strongly connected component is a "set of vertices" where there exists a directed path from any
vertex to any other vertex within the same component. Essentially, every vertex in the SCC is reachable from every
other vertex through directed edges.

💠 The 3-Step Algorithm 💠
1.Get Nodes in Stack (Topological Sort):
    Start by performing a topological sort to obtain a stack of nodes. This step ensures that nodes are processed in an 
    order conducive to identifying strongly connected components.
2.Transpose the Graph:
    Reverse the direction of edges in the original graph to create the transpose graph. This step is crucial for the
    subsequent DFS traversal.
3. DFS on Transpose Graph According to Stack Nodes:
    Perform a Depth-First Search (DFS) on the transpose graph using the nodes in the order they are stored in the stack.
    This traversal helps unveil the strongly connected components.

STEPS-
1. GET NODES IN STACK (TOPOLOGICAL SORT)
2. TRANSPOSE THE GRAPH       "(Reverse the direction of edges transpose is ready)"
3. DO DFS ACCORDING TO STACK NODES(in the order they are stored) ON "TRANSPOSE GRAPH".
*/
package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgo {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int V) {
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    // O(V+E)
    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            int neighbor = graph[curr].get(i).dest;
            if(!visited[neighbor]) {
                topSort(graph, neighbor, visited, stack);
            }
        }
        stack.push(curr);
    }

    // O(V+E)
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for(int i = 0; i < graph[curr].size(); i++) {
            int neighbor = graph[curr].get(i).dest;
            if(!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void kosarajusAlgo(ArrayList<Edge>[] graph, int V) {
        // STEP 1  (get nodes in stack)
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                topSort(graph, i, visited, stack);
            }
        }

        // STEP 2 (transpose the graph)    O(V+E)
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = new ArrayList[V];     // reverse the direction of edges to create transpose of a graph
        for(int i = 0; i < V; i++) {
            transpose[i] = new ArrayList<>();  // initialising
            visited[i] = false;                 // making visited again as normal for 3rd step(dfs)
        }

        // traverse the original graph and find out each vertices neighbors
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));  // make the dest as src
            }
        }

        // STEP 3   (do dfs according to stack nodes on tran. graph)
        while(!stack.isEmpty()) {
            int node = stack.pop(); 
            if(!visited[node]) {            // remember to update dfs after first step
                dfs(transpose, node, visited);      // remember dfs will be applied on transpose graph
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        /*
                1 ---> 0 ---> 3
                ↑     /       |
                |    /        |
                |   /         ↓
                2 <-          4

                will have 3 SSC : 1st -> {0,1,2} ; 2nd -> {3} and 3rd -> {4} 

        */

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);

        kosarajusAlgo(graph, V);        // Prints the SSC in each line
    }
}

/*
 * TIME COMPLEXITY : O(V+E)
 * SPACE COMPLEXITY : O(V)
 */