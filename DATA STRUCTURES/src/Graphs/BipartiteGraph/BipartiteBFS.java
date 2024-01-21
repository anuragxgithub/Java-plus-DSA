
/*
You can get graph in any formal here we are using Adjacency list Array of ArrayList.
Graph can be implemented using grid or Array of ArrayList
 
 
--------- BIPARTITE GRAPH ---------
Formal Definition-
A bipartite graph is a type of graph whose vertices can be divided into two disjoint sets (often called "left" and
"right" sets) such that every edge connects a vertex from one set to a vertex in the other set. In other words, there
are no edges that connect vertices within the same set.

Formally, a graph G = (V, E) is bipartite if it is possible to partition the set of vertices V into two disjoint sets
A and B, such that every edge in E connects a vertex in set A to a vertex in set B. Mathematically, this can be
expressed as:
V=A∪B
A∩B=∅
(u,v)∈E⟹u∈A and v∈B
In a bipartite graph, it is common to represent the two sets of vertices as two different colors (e.g., red and blue),
and edges only connect vertices of different colors.

Bipartite graphs have many applications, and they are often used to model relationships or interactions where
entities can be categorized into two distinct groups, and interactions only occur between entities of different
groups. The concept of bipartite graphs is fundamental in various areas, including network flow problems, matching problems, and certain types of scheduling problems.

SIMPLE FOR UNDERSTANDING-
If you take any two colors and try to color the nodes of graph such that color of adjacent nodes are not same
and if it is possible then it is a BIPARTITE GRAPH.
PROPERTIES-
1- All linear graph (Acyclic) are BIPARTITE GRAPH.
2- Graph which has cycle and the length of cycle(no of edges in cycle) is EVEN then it is a BIPARTITE GRAPH.
3- Graph which has cycle and the length of cycle is ODD then it is not a BIPARTITE GRAPH.


IMPLEMENTATION IS VERY EASY HERE "USING BFS"
*/

package Graphs.BipartiteGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        // first of all initialising each indices of array
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        /*
                0 ------- 1
                |         |
                |         |
                |         |
                3 ------- 2
        */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));

    }

    // Using BFS
    public static boolean isBipartite(ArrayList<Edge>[] graph, int[] color, int start) {
        // Here we are using two colors as 0 and 1
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()) {
            int curr = q.remove();

            // check for neighbors
            for(int i = 0; i < graph[curr].size(); i++) {
                int neigh = graph[curr].get(i).dest;

                if(color[neigh] == -1) {
                    color[neigh] = 1-color[curr];
                    q.add(neigh);       // don't forget to add the neighbor is queue
                } else if(color[neigh] == color[curr]) {
                    // if neigh is already colored and its color is same as its adjacent node then not a bp graph
                    return false;
                }
            }
        }
        return true;  // if all nodes are colored correctly then it is a bp graph
    }


    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int[] color = new int[V];
        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(!isBipartite(graph, color, i)) {
                    System.out.println("Not a Bipartite Graph!!");
                }
            }
        }
        System.out.println("Yes, a Bipartite Graph!!");;   // is a bipartite graph
    }
}
/*
Time : O(V+E)
Space : O(v)
*/