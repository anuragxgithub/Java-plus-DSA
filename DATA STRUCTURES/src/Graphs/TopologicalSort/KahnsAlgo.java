/*
"Toplogical sort is a linear order of vertices such that every directed edge u -> v, the vertex u comes before v
in order."
- Toplogical sort is only calculated for DAGs(Directed Acyclic Graph)
---- TOPOLOGICAL SORT USING BFS -- "KAHN'S ALGORITHM" ----

Previoulsy we performed topological sort using dfs now this is how we can do it using BFS

KAHN'S ALGORITHM:
Kahn's algorithm is based on in-degree and out-degree concept.
in-degree: num of incoming edges
out-degree: num of outgoind edges
FACT: "A DAG has atleast one vertex with in-degree 0 and atleast one vertex with out-degree 0

Steps to implement:
(Remember we want nodes with least dependency first bcz non dependent comes first only then dependent can exist)
1. Here we use indegree[] array to store the indegree of vertices which can be calculated by calculating 
   number of times a node is becoming some other node's dest.
2. Now after calculating indegree for each vertice we will add the veritces with 0 indegree in the q.
3. Now while q doesn't become empty remove node from q print it and decrement its neighbors indegree by one
   so that they will prepare to come in the q as soon as their indegree becomes 1. After decrementing also check
   if the neighbor's indgree becomes 0 ? if yes add it to q.

Here we don't need visited array as we are only adding elements in q whose indegree is 0 (no edge is present to take
you again to that node).
*/

package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgo {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        // initialise array list at each idx of array
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
            5 -----> 0 <------ 4
            |                  | 
            |                  | 
            ↓                  ↓  
            2 ------> 3 -----> 1

            NOTE: POSSIBLE ANSWERS ARE:
            5,4,3,2,1,0
            4,5,3,2,1,0
            5,4,0,2,3,1  ... and others too if possible
            All orders follow topological sort definition.
        */

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
    }

    public static void calculateIndeg(ArrayList<Edge>[] graph, int[] indeg) {
        // to calculate indegree simply calculate the number of times a node is becoming dest of other node
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    
    public static void topologicalSort(ArrayList<Edge>[] graph, int V) {
        int[] indeg = new int[V];
        calculateIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indeg.length; i++) {
            //add the vertices whose indegree is 0 (that means which don't depend on any other node)
            if(indeg[i] == 0) {
                q.add(i);
            } 
        }

        // bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");   // topological sort printing

            for(int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                // decrement the in degree of the current node
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) {
                    // if after decrementing neig's indeg value it becomes 0 add it to queue
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        topologicalSort(graph, V);

    }
}
