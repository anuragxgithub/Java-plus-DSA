
/*
Not Much important.

FLOYD WARSHALL ALGORITHM:
-> It is a "multi-source" shortest path finding algorithm.
-> Detects negative cycles as well.

"FROM SOURCE NODE GO VIA EVERY VERTEX/NODE TO THE DESTINATION NODE AND FIND OUT THE SHORTEST PATH AMONG THEM."
Lets say we want to find shortest path from 0 to 4. Then think of 0 as (i) and 4 as (j). Then
Min(dist[i][k] + dist[k][j])  {i to k + k to j}                i to k could be already computed.
See below graph for to know what is k.

The algorithm is not much intuitive as the other ones. It is more of a brute force, where all combination
of paths have been tried to get the shortest paths.
Nothing to be panic much on the intuition, it is a simple brute on all paths. Focus on the three for loops.
*/


package Graphs.ShortestPathAlgos;

import java.util.Arrays;

public class FloydWarshallAlgo {
    public static void main(String[] args) {
        /* 
        Here instead of Adjacency list we will use adjacency matrix to store the graph.
        WHY?? Because here we will store minimum distance of all nodes from every other nodes(multisource) so
        this reprentation helps us we can in place modify it and return the ans.

                        (1)
                    0 -----> 1
                    ↑    ↑   |
                    |   /    | (3)
                (3) |  /(5)  |
                    | /      ↓
                    3 -----> 2
                       (4)

                Adjacency Matrix
                {        0  1  2  3

                    0   {0, 1, ∞, ∞},
                    1   {∞, 0, 3, ∞},
                    2   {∞, ∞, 0, ∞},
                    3   {3, 5, 4, 0}
                }

                {0,0} represents distance/cost from going 0 to 0 similarly {1,2} represent distance from going 1 to 2
                
                // Note there can be dual graph too like 1 to 2 and 2 to 1 with same or diff. cost.
        
        AS WE KNOW TO FIND THE SHORTEST DISTANCE B/W i to j WE ARE GOING TO DO:
        Min(dist[i][k] + dist[k][j]) here k is intermediary via which we go to k. At max we can go from one node to
        other via all vertext if we include src and dest. So this k would be 0 to n.
        For every vertext we go to every other vertex via all k(all nodes) and find out the shortest path. Simple.
        */

        int[][] graph = new int[][] {
                                        {0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE},
                                        {Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE},
                                        {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
                                        {3, 5, 4, 0}
                                    };
        int n = graph.length;
        
        // FLOYD WARSHALL
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    // comparing already stored distance to new one
                }
            }
        }

        // HOW TO DETECT -ve CYCLE??
        // Simple if any node's distance from itself to itself only becoms negative that means that cycle is part
        // of negative cycle (ideally distance from one node to itself is 0 and it should remain this only)
        for(int i = 0; i < n; i++) {
            if(graph[i][i] < 0) {
                System.out.println("NEGATIVE CYCLE EXIST!!!");
                break;
            }
        }


        for(int[] arr : graph) {
            System.out.println(Arrays.toString(arr));
            // There will be only one change here bcz graph hi aisa hai.
        }

    }
}

/*
NOTE: WE CAN USE DIJSKTRA FOR EACH NODE INSTEAD OF THIS IF -VE CYCLE DON'T EXIST.
ITS TIME COMPLEXITY WOULD BE O(N * Elogv) WHICH IS STILL BETTER THAN FLOYD WARSHALL.

TIME COMPLEXITY : O(N^3)
SPACE COMPLEXITY : O(1)             but if you consider graph too then O(n^2)
*/