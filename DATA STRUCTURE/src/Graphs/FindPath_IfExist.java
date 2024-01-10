package Graphs;


// https://leetcode.com/problems/find-if-path-exists-in-graph/

// NOTE: IN THIS QUESTION WITHOUT CLASS GRAPH WILL BE IMPLEMENTED THAT IS ALL CONNECTED NODES  FOR A PARTICULAR NODE
// IN GRAPH ARE DIRECTLY STORED IN INTEGER VALUES 
// EG: LETS SAY WE HAVE A NODE 1 AND ALL NODES CONNECTED TO IT ARE {3,4,6} THEN IN ARRAYLIST
// AT IDX 1 WE'LL DIRECTLY STORE VALUES 2,4,6 DONE.

import java.util.ArrayList;

public class FindPath_IfExist {

        public static boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int curr, int d) {
        if(curr == d) {
            return true;
        }

        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            int neighbor = graph[curr].get(i);
            if(!visited[neighbor] && dfs(graph, visited, neighbor, d)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {   // we are provided with this

        /*
         * APPRAOCH:
         * Since only edges are given we first have to create a graph.
         * That means we have to create a AdjacencyList.
         * There is only one thing to take care of in this problem and that is since the graph is bidirection so we have
         * to store "Node 2 as neighbor of Node 1 and Node 1 as neighbor of Node 2".
         * Now question would be how we can store source and destinations in our array list as we don't have Edge class
         * so thats simple you have to create Adjacency list as it represents its indices as vertex and at each indices 
         * ArrayList<Integer> will store how many neighbors does it connected with. Eg:
         * For Index 0: [1,2]  that means node/vertex 0 is connected to vertex 1 and 2. This is achieved using this 2 lines
         * for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]); // u -> v
            graph[edges[i][1]].add(edges[i][0]); // v -> u
            // Note : given edges[i].length == 2
           }
         */
        ArrayList<Integer>[] graph = new ArrayList[n];
        // Initialise arraylist to each array idx
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]); // u -> v
            graph[edges[i][1]].add(edges[i][0]); // v -> u
            // Note : given edges[i].length == 2
            // --OR--
            // for(int[] edge : edges) {
            //     graph[edge[0]].add(edge[1]);
            //     graph[edge[1]].add(edge[0]);
            // }
            
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination); // O(V+E)

/*
 * graph[edges[i][0]].add(edges[i][1]); // u -> v
 * graph[edges[i][1]].add(edges[i][0]); // v -> u
 * // Note : given edges[i].length == 2
 * ---OR----
 * for(int[] edge : edges) {
 *  graph[edge[0]].add(edge[1]);
 *  graph[edge[1]].add(edge[0]);
 * }
 * The above two lines basically doing that for each idx of i in edges/matrix 0th element and 1st element is taken as only two
 * will be present, for for each i in edges the element at 0th and 1st element is put as graph index one by one and at that
 * idx its neighbor value is added. Neighbor would be: For eg for element at 0th idx its one of the neighbor will be obviously
 * the 1st element at a given i so the value at 1st idx is added as neighbor for 0th element in graph. And neighbor of 1st 
 * element would be 0th element as graph is bidirectional. easy peasy      
 * 
 * 
 *  for these sets of input of edges : {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
 * 
 * Our graph/adjacencyList would look like:
 * Index 0: [1, 2]
 * Index 1: [0]
 * Index 2: [0, 3, 4]
 * Index 3: [2]
 * Index 4: [2]
 */ 

}




    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int start = 0;
        int end = 4;

        boolean isValidPath = validPath(n, edges, start, end);
        System.out.println(isValidPath);
    }
}



// SEE APPROACH 2 FOR THIS IN FindPath_IfExist2.java
