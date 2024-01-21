
/*
HERE WE WILL SEE HOW TO IMPLEMENT BIPARTITE CHECKING THING  "USING DFS"

You should be able to do with both the techniques althouth both are easy peasy.
*/

package Graphs.BipartiteGraph;

import java.util.ArrayList;

public class BipartiteDFS {
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

    // Using DFS
    public static boolean isBipartite(ArrayList<Edge>[] graph, int[] color, int start, int clr) {
        // Here we are using two colors as 0 and 1
        color[start] = clr;

        for(int i = 0; i < graph[start].size(); i++) {
            int neigh = graph[start].get(i).dest;
            if(color[neigh] == -1) {
                if(isBipartite(graph, color, neigh, 1-clr) == false) {
                    return false;
                }
            } else if(color[neigh] == clr) {   // you can replace clr with with color[start] also. 
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int[] color = new int[V];
        for(int i = 0; i < V; i++) {        // checking if multiple components exist
            if(color[i] == -1) {
                if(!isBipartite(graph, color, i, 0)) {
                    System.out.println("Not a Bipartite Graph!!");
                }
            }
        }
        System.out.println("Yes, a Bipartite Graph!!");   // is a bipartite graph
    }
}
/*
Time : O(V+E)
Space : O(v)
*/