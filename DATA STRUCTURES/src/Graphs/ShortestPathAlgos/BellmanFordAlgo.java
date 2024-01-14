/*
 * -> Dijkstra's algo does not guarantee correctness for cases when weight of the graphs can be negative.
 * -> So in this case we use Bellman Ford Algorithm.
 * -> Bellman Ford works on DP (Dynamic Programming).
 * -> Time complexity of Dijkstra's Algo(E+ Elog(V)) is less than Bellman Ford(V*E) algo so we'll always prefer
 * dijkstra when wt in graph is positive.
 * 
 * ---- BELLMAN FORD ALGO ----
 * "The Bellman-Ford algorithm is a dynamic programming-based approach for finding the shortest paths in a weighted 
 * graph. It starts by assuming an initial distance of infinity for all vertices except the source vertex, which is
 * set to zero. It then iteratively relaxes the edges (updating distance estimates) for each vertex until the shortest
 * paths are determined. The algorithm continues this process for a number of iterations equal to the number of vertices
 * minus one (V-1)."
 * 
 * STEPS / APPROACH
 * 1. Start with initialising the distance in dist arry for each vertex as infinity except the src.
 * 2. Now, just run a loop to visit all the edges and for all the edges peform relaxation(updating dist. estimates).
 * Do this until the shortest path get determined.
 * 3. And it will be determined if we do relaxation for each vertex V-1 times.
 * 
 */

package Graphs.ShortestPathAlgos;

import java.util.ArrayList;

public class BellmanFordAlgo {
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
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }

    // O(V*E)
    public static void bellmanFordAlgo(ArrayList<Edge>[] graph, int src, int V) {
        int[] dist = new int[V];
        for(int i = 0; i < V; i++) {
            if(i != src) {
                dist[i] =  Integer.MAX_VALUE;
            }
        }

        for(int k = 0; k < V-1; k++) {    //O(V)
            //O(E) both loop combined
            for(int i = 0; i < V; i++) {
                for(int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {      // relaxation
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }

        // detects -ve wt cycles    
        // come here after reading the explanations in bottom
        // for(int i = 0; i < V; i++) {
        //     for(int j = 0; j < graph[i].size(); j++) {
        //         Edge e = graph[i].get(j);
        //         int u = e.src;
        //         int v = e.dest;

        //         if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {      // relaxation
        //             System.out.println("\"Negative weight cycle exist.\"");
        //         }
        //     }
        // }

        for(int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }
    public static void main(String[] args) {
        /*                  
         *          -> 1 <---------\
         *     (2) /   |            \ (-1)
         *        /    |             \
         *       0     |(-4)          -> 4
         *        \    |             /
         *     (4) \   ↓            / (4)
         *          -> 2 -------> 3
         *                  (2)
         */

         int V = 5;
         ArrayList<Edge>[] graph = new ArrayList[V];
         createGraph(graph);

        bellmanFordAlgo(graph, 0, V);
    } 
}

/*
 * NOTE: 
 * -> BELLMAN FORD ALGO DOES NOT WORK FOR "NEGATIVE WEIGHT CYCLE".
 * -> Negative wt Cycle : means when cycle is getting formed from edges a,b and c. If wtOf(a+b+c) < 0 that is called 
 * negative weight cycle.
 * -> Why don't work? 
 * because any such cycles(negative wt cycles) in graph, it indicates that the graph has no well-defined shortest paths. 
 * if you try to find the path of such cycles it will keep updating everytime in loop everytime giving lesser dist.
 * 
 * Ideally there should not be any updation in dis of vertices after V-1 iterations.
 * If the values are still updating after V-1 updating that means negativ wt cycle exists. To know this just add one more
 * inner for loop after V-1's loop got end if the dist of nodes are still updating that means negative cycle exist.
 * 
 * 
 * ONE MORE QUESTION:
 * Why Bellman ford is telling us to iterate for V-1 ??
 * Simple, because for any two nodes(lets say 1 & 2) the maximun number of possible nodes required to reach from node 1
 * to 2 is (V-1) so it makes sures that we don't even miss the longest path. So it is designed so that we don't 
 * miss any path and bring the least dist required to reach node 2 after trying out all the paths.
 */