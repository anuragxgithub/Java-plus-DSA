/*
----------DIJKSTRA'S ALGORITHM----------
-> In dijkstra's algo implementation we'll be given with a directed or undirected graph and the graph will be weighted. And source is algo given.
-> We need to find shortest path for all the nodes in graph from source. 
-> Dijkstra's algo works on "BFS".
-> It is a "greedy algorithm".
-> We can use either Queue or PriorityQueue in bfs algo of Dijkstra but we'll choose PQ bcz it takes comparatively less time.

Before jumping to the algo know about this simple concept of Relaxation first:
if(dist[u] + wt < dist[v]) {            dist[u] -> is basically the dist. from src to the currentNode and dist[v] is dist. from currNode to neighbor node
    then update the dist[v]             and wt is the wt of that edge from currentNode to neighbor node.
    dis[v] = dist[u]+wt;    
}
this is knwon as relaxation, basically it assigns the new shortest path to that node(neighbor) if the old one is greater.

"
Dijkstra's algorithm is a shortest-path algorithm used to find the shortest distance between a source vertex and "ALL
OTHER VERTICES" in a weighted graph. It starts from the source vertex and iteratively selects the vertex with the 
smallest known distance, updating the distances to its neighbors. The process continues until the shortest paths to
all vertices are determined. The algorithm maintains a priority queue to efficiently select the next vertex to explore
based on the current known distances.
"

--> STPES/APPROACH <--

INITIALIZATION:
-> Create a priority queue (min heap) to "store vertices and their distances" from the source. Because we'll remove that neighbor first from pq which
has shorter path that's why pq will be more suitable.
-> Initialize an array to store the minimum distance from the source to each vertex.
-> Mark all vertices as unvisited.

SET INITIAL DISTANCE:
-> Set the distance of the src vertex from src vertex to 0 and add it to the priority queue.
    
MAIN LOOP:
-> While the priority queue is not empty:
    -Extract the vertex with the minimum distance from the priority queue.
    -For each current extracted vertex if it is not visited do the follow:
        1.Mark the vertex as visited.   
        2.Calculate the tentative distance from the source to the neighbor through the current vertex.
        3.If the tentative distance is smaller than the current known distance to the neighbor:
            -Update the distance of the neighbor.
            -Add the neighbor to the priority queue with the updated distance.

COMPLETION:
-> Once the priority queue is empty, the algorithm is complete.
-> The distance array now contains the shortest distances from the source to all other vertices in the graph.

Easy Peasy... only some slight logical change in bfs especially relaxation thing.

*/

package Graphs.ShortestPathAlgos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

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

    static class Pair implements Comparable<Pair> {
        int node;
        int distance;       // this is the distance from to src to this node

        public Pair(int n, int distance) {
            this.node = n;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair p2) {             // note this should not be a static fn otherwise error
            return this.distance - p2.distance;     // smallest element will be prioritized
        }

    }

    // O(E + E(logV))       ElogV comes from pq as it takes time in sorting (as min heap takes nlogn)
    public static void dijkstrasAlgo(ArrayList<Edge>[] graph, int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];    // this will store the paths for each vertices from src
        for(int i = 0; i < V; i++) {
            // initialise distance of each vertex as infinity except the src one which will be 0
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(src, 0));  // distance from src to src will be 0

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!visited[curr.node]) {
                visited[curr.node] = true;

                for(int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] + e.wt < dist[v]) {  // relaxation
                        dist[v] = dist[u] + e.wt;
                        // add the neighbor to the pq
                        pq.add(new Pair(v, dist[v]));      // always add after updating the distance(after relaxation)
                    }
                }   // remember while dry running that between 2 or more nodes the node with the least distance is selected first
            }
        }
        for(int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        // no outgoing edge from vertex 5
    }
    

    public static void main(String[] args) {
        /*                  (7)
         *          -> 1 -------> 3
         *     (2) /   |          ↑ \ (1)
         *        /    |          |  \
         *       0     |(1)    (2)|   -> 5
         *        \    |          |  /
         *     (4) \   ↓          | / (5)
         *          -> 2 -------> 4
         *                  (3)
         */

         int V = 6;
         @SuppressWarnings("unchecked")
         ArrayList<Edge>[] graph = new ArrayList[V];
         createGraph(graph);


         dijkstrasAlgo(graph, 0, V);
        //  Note : you can ignore the visited array thing in dijkstra
    }
}
/*
https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?

In Dijkstra's algorithm, choosing the shortest path first is essential to ensure the algorithm finds the shortest paths
from a source node to all other nodes in a weighted graph. By always selecting the shortest path at each step,
the "algorithm guarantees" that the distances assigned to each node are optimal.
The rationale behind this approach is to progressively explore and update the shortest known distances to reach each
node. By prioritizing the shortest paths, Dijkstra's algorithm efficiently converges to the optimal solution,
providing the shortest paths in non-negative weighted graphs.

 * In Dijkstra's algorithm, the source node is used as the starting point to find the shortest paths to all other nodes in the graph. If the source
 * node is not connected to any other nodes (i.e., it has no outgoing edges), it means that there are no valid paths from the source node to any
 * other nodes in the graph.
 * In such cases, Dijkstra's algorithm will still run, but the resulting distances for all other nodes (except the source) will remain at their
 * initial values (typically set to infinity). This reflects the fact that there is no valid path from the source node to those unreachable nodes.
 */

/*
 * NOTE: WE CAN ALSO USE QUEUE INSTEAD OF PQ IT WILL ALSO GIVE CORRECT ANS. BUT Q IS NOT PREFERRED BCZ 
 * WHEN WE USE Q IT DON'T CARE ABOUT THE SHORTEST PATH FIRST WITH WILL GO SEQUENTIALLY DUE TO WHICH IT CAN
 * ADD UNNECESSARY PAIR IN Q. BUT IF WE USE PRIORITY Q WE ARE BEING GREEDY AND AT EACH POINT WE ARE PICKING THE
 * SHORTEST PATH WHICH REDUCES THE ADDITION OF NON OPTIMAL PAIR IN QUEUE. HENCE SAVING US SOME TIME.
 * 
 *    EG:
 *       0
 *  (4)/   \(1)      Here if we use q it will add pairs {1,4}, {2, 1}, {3,7}, {3,2}
 *    /     \        But if we use pq pairs added will be : {2,1} & {3,2} other will not be added bcz get rejected while relaxation
 *   1       2 
 *    \     /
 *  (7)\   / (2)
 *       3 
 *         \....
 */  