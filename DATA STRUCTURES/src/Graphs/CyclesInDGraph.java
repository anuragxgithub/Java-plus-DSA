/*
 * HERE WE'LL DISCUSS HOW TO DETECT CYLE IN UNDIRECTED GRAPHS
 * 
 * We can't use the parent thing here as we used to do in undirected graph. Becuase in directed graphs you may not be able to visit all the nodes
 * from any node unlike undirected gaphs. Eg:
 *
* EG:
*      0 -----> 1 <----- 2
*                      /  ^
*                     /    \
*                    !      \
*                   3 -----> 4
     So here lets say I visited 1 so its would be 0 and from 2 if I see then 1 is already visited and 2 is not parent of 1 is that mean cycle exist 
     there no that's why we don't use parent stuff here in directed graph rather we "leverage call stack".
 * 
 * STEPS:
 * 1) CHECK FOR IF THE NEIGHBOR ALREADY EXIST IN THE CALL STACK AND IS ALREADY VISITED. "THEN CYCLE EXIST"
 * 2) IF NOT THEN GO AHEAD.
 */


package Graphs;

import java.util.*;

public class CyclesInDGraph {

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

    public static void createGraph(ArrayList<Edge>[] graph) {
        // initialise array list at each idx of array
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
        1 -----> 0<--
                 |   \
                 |    3
                 |   /
                 2-->
        */

        // graph[0].add(new Edge(0, 2, 1));
        // graph[1].add(new Edge(1, 0, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[3].add(new Edge(3, 0, 1));

        /*
         *      0 -----> 1 <----- 2
         *                      /  ^
         *                     /    \
         *                    !      \
         *                   3 -----> 4
         */

        graph[0].add(new Edge(0, 1, 1));
        // graph[1].add(new Edge(0, 1, 1));         1 is not pointing to any node
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 2, 1));
    }

    // cycle detection in directed graph    O(V+E)
    public static boolean isCyclicDirected(ArrayList<Edge>[] graph, boolean[] visited, int curr, boolean[] callStack) {
        visited[curr] = true;
        callStack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            int neighbor = graph[curr].get(i).dest;
            if(callStack[neighbor] == true) {       // if exist in callStack then it will definately be visited so no need to check that 
                // cycle exist
                return true;
            } else if(!visited[neighbor]) {
                // if not visited then visit it
                if(isCyclicDirected(graph, visited, neighbor, callStack)) { // checking for if neighbor's neighbor has cycle then it will return true
                    return true;
                }
            }
        }
        // backtrack to remove removed elements from your call stack too
        callStack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // modified dfs is used for cycle detection

        // System.out.println(isCyclicDirected(graph, new boolean[V], 0, new boolean[V]));

        // it may be possible that we can't reach to all vertices/nodes from one node in directed graph that's why this:
        /*
         * EG:
         *      0 -----> 1 <----- 2
         *                      /  ^
         *                     /    \
         *                    !      \
         *                   3 -----> 4
         */
        boolean[] visited = new boolean[V];
        boolean[] callStack = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                boolean isCyclic = isCyclicDirected(graph, visited, i, callStack);
                if(isCyclic) {
                    System.out.println(isCyclic);
                    break;      // bcz we care for any one cyle
                }
            }
        }
    }
}
