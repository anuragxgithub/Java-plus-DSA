/*
-----TOPOLOGICAL SORTING-----
Topological sorting is used only for DIRECTED ACYCLIC GRAPHS (DAGs). And not for (non DAGs)
(DAGs are grpahs which are directed and not cyclic)

"It is a linear order of vertices such that every directed edge u -> v, the vertex u comes before v in the order."

EG:
  a --> b
   \    |
    \   |
     \  ↓ 
     -> c ----> d

     u  |  v
     a  -> b
     b  -> c
     a  -> c
     c  -> d
    For every u -> v, u should come first in order. 
    The topological order for this DAG would be a b c d

    IT SHOWS DEPENDENCY HOW 1 NODE IS DEPENDENT ON OTHER (OR which node is coming first and which one coming later).
    A real world example would be:
    Action 1 : buy a laptop 
    Action 2 : install os 
    Action 3 : install code editor 
    Action 4 : install java
    Action 5 : write code

    The graph would look like this:
         1
         ↓
         2               for os there must be a laptop
       /   \
      ↓     ↓  
      3     4            for action 3 and 4 os should be installed first (insatlling java don't need code editor to be installed)
      \     /
       \   /
         ↓
         5              for writing code code editor and java should be present first

         Look a DAG is formed showing dependency.
         Topological order for this graph would be: 1 2 3 4 5  (3 and 4 can be interchanged)

NOTE:
1. IT MIGHT BE POSSIBLE THAT MULTIPLE POSSIBLE ORDERS CAN BE PRESENT.
2. CODE OF TOPOLOGICAL SORT IS VERY EASY YOU JUST NEED TO PUT ONE EXTRA LINE IN ACTUAL DFS CODE.

ALGORITHM:
Here we will use actual stack data structure to store the vertices so that we can use those to create our TS order.
The idea to use stack is that: store the dependent elements first and the less dependent one will be stored in last(from
where other nodes are originating) so in this way the non dependent nodes will be printed first and then other nodes will
be printed. (IN SHORT : "Take one node store its dependents first and then add it do this for each node".)
*/

package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
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

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
    }

    // O(V+E)
    private static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            int neighbor = graph[curr].get(i).dest;
            if(!visited[neighbor]) {
                topSortUtil(graph, neighbor, visited, stack);
            }
        }
        stack.push(curr);
    }

    public static void topSort(ArrayList<Edge>[] graph, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        // call dfs for each vertex
        for(int i = 0; i < V; i++) {
            if(!visited[i])
            topSortUtil(graph, i, visited, stack);
        }

        // print the vertices from the stack
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        } 
    } 
    public static void main(String[] args) {
        /*
            5 -----> 0 <------ 4
            |                  | 
            |                  | 
            ↓                  ↓  
            2 ------> 3 -----> 1           (2 should come before 3 and 1, 5 & 4 should come before 0 ,2,3 and 1)

            NOTE: POSSIBLE ANSWERS ARE:
            5,4,3,2,1,0
            4,5,3,2,1,0
            5,4,0,2,3,1  ... and others too if possible
            All orders follow topological sort definition.
        */

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        topSort(graph, V);
    }

}
/*
 * One specific algorithm that combines topological sorting with finding shortest paths is the "Shortest Path in a
 * Directed Acyclic Graph" algorithm. This algorithm works on a DAG and computes the shortest paths from a single 
 * source vertex to all other vertices. It achieves this by topologically sorting the vertices and then relaxing the
 * edges in the topological order. The algorithm is more efficient than algorithms like Dijkstra's or Bellman-Ford for
 * acyclic graphs. 
 * So, while topological sorting itself is not a shortest path finding algorithm, it can be a key component in
 * algorithms designed for finding shortest paths in certain scenarios, particularly when dealing with directed acyclic
 * graphs.
 */