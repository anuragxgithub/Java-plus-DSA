
/* 
BRIDGES IN GRAPH:
Bridge is an "edge" whose deletion increases the graph's number of connected components.

----TARJAN'S ALGORITHM----
Tarjan's algo is more famous for find the strongly connected components.
 
But here we will see how to find "bridges" in a graph if any.
 
Tarjan's Algorithm has various applications not just only finding 'Bridges in graph' they are:
- Finding SCCs(Strongly connected components in directed graphs)
- Articulation Point
- Topological Sorting
 
But these are not important thing but the concept which we are goind to use in thins algo is important in itself.
It is a DFS based algo. (Finding bridges using Tarjan's algo)

FIND BRIDGES IN A GRAPH USING TARJAN’S ALGORITHM:
Before heading towards the approach understand which edge is termed as bridge. Suppose there exists a edge
from u -> v, now after removal of this edge if v can’t be reached by any other edges then u -> v edge is bridge.
Our approach is based on this intuition, so take time and grasp it.

ALGORITHM: –

To implement this algorithm, we need the following "data structures" –

visited[] = to keep track of the visited vertices to implement DFS
disc[] = to keep track when for the first time that particular vertex is reached
lowdt[] or low[] : is the lowest discovery time of a node. Lowest Discovery time of a node is the lowest discovery time among all the nodes
                   connected to it including itself but not the parent node. 
                   Eg: lowdt of v is the lowest lowdt among all the nodes connected to it directly or indirectly 
                   inclding itself but excluding its parent which is u.                                        
                             y  
                            /  
                     u --- v -- x
                            \
                             z

We will traverse the graph "using DFS" traversslight modial but with fications i.e. while traversing we will keep
track of the "parent node" by which the particular node is reached because we will update the 
low[node] = min(low[all it’s adjacent node except parent]) hence we need to keep track of the parent.

While traversing adjacent nodes let ‘v’ of a particular node let ‘u’ 3 cases arise –

1. v is parent of u then,   -> skip that iteration.
2. v is visited then,   -> update the low of v i.e. low[u] = min( low[u] , disc[v]) this arises when a node can be
                        visited by more than one node, but low is to keep track of the lowest possible time so
                        we will update it.
3. v is not visited then,  -> call the DFS to traverse ahead
-now update the low[u] = min( low[u], low[v] ) as we know v can’t be parent cause we have handled that case first.
-now check if ( low[v] > disc[u] ) i.e. the lowest possible to time to reach ‘v’ is greater than ‘u’ this means we
can’t reach ‘v’ without ‘u’ so the edge   u -> v is a bridge.


⭐⭐NOTE: there is a catch by which we'll be able to detect the bridge for eg here in this graph deleting the
edge 0--3 then graph will be in 2 connected components SO THE CATCH IS DISCOVERY TIME OF ALL THE NODES AT
RIGHT CONNECTED COMPONENT WILL BE GREATER THAN THE DISCOVERY TIME OF 0. see below:

     x            y  y
     \           /   |
      u ------- v ---
    / |          \
   x  x           y
    So simple, just look at the graph discovery time of u will always be greater than the dt of v and its
    neighbors because a single path exist b/w u and v so we must have to first travel u and then v.
    That is how we are gonna find the bridge using tarjan's algo.

*/

package Graphs.DecreasingConnectedComponents;

import java.util.ArrayList;

public class TarjansAlgo {
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
            |   /     | \
            |  /      |  5
            | /       | /
            2         4

            Here there is only one bridge in graph and that is edge: (0 to 3) or (3 to 0) bcz undirected 

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
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

        /*
            1 -- 0 -- 3
            |   /     |
            |  /      |
            | /       |
            2         4

            Here there is 2 bridges in graph and that are edge: (0 to 3) & (3 to 4).
            don'v forget to updat V in main
        */

        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));

        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));

        // graph[3].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 3));
    }


    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int[] dt, int[] low, int time, int curr, int parent) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;      // initially discovery time and lowest discovery time will be same
                                            // while backtracking we'll update (lowest disco. time)

        for(int i = 0; i < graph[curr].size(); i++) {
            int neighbor = graph[curr].get(i).dest;
            
            if(neighbor == parent) {
                continue;       // in this case we don't know whether this edge would be a bridge or not
            } else if(!visited[neighbor]) {
                dfs(graph, visited, dt, low, time, neighbor, curr);
                // update the lowest discovery time for current node
                low[curr] = Math.min(low[curr], low[neighbor]);
                if(dt[curr] < low[neighbor]) {
                    System.out.println("Bridge is : " + curr + "----" + neighbor);
                }

            } else {
                // already visited and not parent of current node
                // that means there are other path(s) already to reach that node so this edge will not be our bridge
                // obviously bcz bridge uniquely connects two nodes there are no other edges that connects those nodes
                low[curr] = Math.min(low[curr], dt[neighbor]);      // updating lowest discovery time
            }
        }
    }

    public static void tarjansAlgo(ArrayList<Edge>[] graph, int V) {
        boolean[] visited = new boolean[V];
        int[] dt = new int[V];      // 'discovery time'    basically keeps track of time taken to reach a particular vertex
        int[] low = new int[V];     // 'lowest discovery time' of all neighbors other than parent. Basically keeps track for lowest time to reach that particular node
        int time = 0;
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs(graph, visited, dt, low, time, i, -1);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);

        tarjansAlgo(graph, V);
                
    }
}
/*
    ⭐⭐ NOTE: I observed that no edge of a cycle can be a bridge. And cycles are the only case where 'lowest discovery time' low[] value is
    start decreasing making this condition (dt[curr] < low[neighbor]) of bridge detection false for each "edge" in cycle.

    And any edge which is not part of any cycle will be a bridge. ⭐⭐

 * space complexity: O(V)
 * time complexity:  O(V + E)
 */