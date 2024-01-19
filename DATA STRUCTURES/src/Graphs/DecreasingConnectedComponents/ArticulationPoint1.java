/*
 * ----> ARTICULATION POINT <----
 * "A vertex v is an articulation point (also called cut vertex) if removing v (& its edges) increases the number of
 * connected components."
 * 
 * APPLICATIONS OF ARTICULATION POINT:
 * Articulation points represent vulnerabilities in a connected network – single points whose failure would split
 * the network into 2 or more components. They are useful for designing reliable "networks".
 * 
 * HERE WE'LL DISCUSS THE NAIVE APPROACH:
 * In this approach we would simply just remove 1 vertex and check how many connected components are there in the graph
 * after removing it. If it woud be greater than 1 than obviously it would be called as an Articulation Point.
 * And we'll repeat the same thing for each vertex. Simple.
 * 
 * So here is my own implementation of finding AP in a graph using naive appraoch and this appraoch is correct.
 * 
 * So only thing in this approach is that how to actually remove the node, lol its simple just before the dfs mark it
 * as visited. The problem is solved now dfs will not consider this node and hence it is kind of removed.
 * Also calculate the components on removing the current node. DONE
 * 
 * But is is not efficient bcz the time complexity is : O(V * (V+E)).
 * 
 */



package Graphs.DecreasingConnectedComponents;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoint1 {
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

        /*
            1 -- 0 -- 3
            |   /     |
            |  /      |
            | /       |
            2         4

            Here there is 2 Articulation Points in graph and those are : 0 and 3

        */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int curr) {
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            int neighbor = graph[curr].get(i).dest;

            if(!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    public static void getAP(ArrayList<Edge>[] graph, int V) {
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++) {

            Arrays.fill(visited, false);
            visited[i] = true;
            int connectedComponents = 0;

            for(int j = 0; j < V; j++) {
                if(j != i && !visited[j]) {     // if all nodes are not getting visited at first time that means more than 1 components are there 
                    connectedComponents++;
                    dfs(graph, visited, j);
                }
            }
            if(connectedComponents > 1) {
                System.out.println("AP : " + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);

        getAP(graph, V);
    }
}
/*
 * The optimised version of this (finding AP in a graph) is implemented in ArticulationPoint2.java
 * 
 * We use Tarjan's Algorithm to find the AP in optimised wayO(V+E).
 */