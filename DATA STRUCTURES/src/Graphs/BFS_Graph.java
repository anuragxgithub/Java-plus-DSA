/*
Here we'll traverse through the graph using BFS(Breadth First Search) or Level Order Traversal
Graph here is implemented using Adjacency List (Array of ArrayList).
*/
package Graphs;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


public class BFS_Graph {
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

    static void createGraph(ArrayList<Edge>[] graph) {
        // Never forget to initialise the arraylist first
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

    public static void bfs(ArrayList<Edge>[] graph) {    // O(V + E)
        // create a queue
        Queue<Integer> q = new LinkedList<>();
        // create a visited array of size V to monitor visited nodes
        boolean[] visited = new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()) {
            int current = q.poll();
            if(!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;
                // add its all adjacent/immediate neighbours to the queue
                for(int i = 0; i < graph[current].size(); i++) {
                    Edge e = graph[current].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // THIS IS JUST A SLIGHT VARIATION OF THE ABOVE BFS IMPLEMENTATION "THIS ONE IS BETTER THAN THE ABOVE" ONE BCZ IT ELIMINATES ALREADY VISITED
    // VERTICES TO GET ADDED IN THE QUEUE (as it first checks whether neighbor is visited or not then adding it) "USE THIS ONE"
    // NOTE: ⭐⭐⭐ ALWAYS USE THIS METHOD OF BFS DUE TO THIS I GOT STUCK IN A QUESTION (SEE IT IN QUESTIONS-> Imp2.java)
    public static void bfs2(ArrayList<Edge> graph[], boolean[] visited, int source) {
        // create a queue
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()) {
            int current = q.poll();
            
            System.out.print(current + " ");

            // add all the adjacent vertices of the current vertex to the queue
            for(int i = 0; i < graph[current].size(); i++) {
                int neighbor = graph[current].get(i).dest;
                if(!visited[neighbor]) {            // check if the neighbor is visited or not if not visited then visit it and add it to the queue
                    visited[neighbor] = true;
                    q.add(neighbor);
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
        bfs(graph);

        System.out.println();
        bfs2(graph, new boolean[V], 0);

    }
    
}
