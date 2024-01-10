/*
Here we will implement graph using Adjacency List (Array of ArrayList).
Easy Peasy.
Here I implemented the graph using Adjacency List (Array of ArrayList). Which is commonly used in many
cases for implementing graph because it has advantage like:
- it does not store any unnecessary info.
- it can perform common operation like finding neighbor in almost constant time.
*/
package Graphs;

import java.util.Arrays;
import java.util.ArrayList;

class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
        this.src = s;
        this.dest = d;
        this.wt = w;
    }
}

public class GraphImplementation {
    public static void main(String[] args) {
/*
                (5)
            0 ------ 1
                    / \
               (1) /   \ (3)
                  /     \
                 2 ----- 3
                 |  (1)
             (2) |
                 |
                 4
 */
        // The size of our array will be the total num. of Vertices
        int V = 5;
        // int[] arr = new int[];
        ArrayList<Edge>[] graph = new ArrayList[V];  
        // graph will store values of type ArrayList. And ArrayList is of type Edge(i.e, at each idx of ArrayList value of type edge is stored).
        // Very Imp. thing : Now at each idx of our array of arraylist "null" is stored
        // no arraylist is present there we have to initialse it first.

        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 -vertex
        graph[0].add(new Edge(0, 1, 4));
        System.out.println(Arrays.toString(graph));

        // 1 -vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 -vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 -vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 -vertex
        graph[4].add(new Edge(4, 2, 2));

        System.out.println(graph[1].size());

        // 1's neighbour
        for(int i = 0; i < graph[1].size(); i++) {          // Time : O(k), in worst case, where k is the total number of edges of node (almost const.)
            System.out.println("Neighbour " + (i+1) + " : " + graph[1].get(i).dest); 
        }
    }
}

// NOTE : YOU CAN CREATE ADJACENCY LIST OF INTEGER WITHOUT THE EDGE CLASS. FOR THAT YOU HAVE TO STORE THE NUMBER OF 
// VERTICES CONNECTED TO EACH ith NODE/VERTEX OF GRAPH[i] IN INTEGER VALUES.
// EG: LETS SAY WE HAVE A NODE 1 AND ALL NODES CONNECTED TO IT ARE {3,4,6} THEN IN ARRAYLIST
// AT IDX 1 WE'LL DIRECTLY STORE VALUES 2,4,6 DONE.