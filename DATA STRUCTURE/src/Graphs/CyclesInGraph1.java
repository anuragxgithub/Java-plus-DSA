/*
 * In this file we will discuss How to detect cycles in Undirected Graph.
 * 
 * NOTE: Cycles in undirected graph can be detected using three appraoches:
 * 1. DFS
 * 2. BFS
 * 3. DSU (DISJOINT SET UNION)
 * 
 * WHILE PERFORMING CYCLE DETECTION (DFS & BFS) IN UNDIRECTED GRAPH JUST REMEMBER THIS ONLY:
 *  For each node/vertex in graph there can be three possibilities:
 *      1. Neighbor is already visited && Neighbor is not parent of the current vertex. (THIS MEANS CYCLE MUST BE PRESENT SO "RETURN TRUE")
 *      2. Neighbor is already visited && Neighbor is parent of the current node.  (DO NOTHING FOR THIS AS THIS DOES NOT REPRESENT ANY CYCLE)
 *      3. Neighbor is not visited yet.  (THEN VISIT IT)
 *  NOTE: parent is the just previous node/vertex from where current is derived.
 */

package Graphs;

import java.util.*;

public class CyclesInGraph1 {

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

    static void createGraph(ArrayList<Edge>[] graph) {
        // Never forget to initialise the arraylist first
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 4, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 4, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));

        // 3 vertex
        graph[3].add(new Edge(3, 2, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 0, 1));
        // graph[4].add(new Edge(4, 1, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 vertex
        graph[5].add(new Edge(5, 4, 1));

}

    // METHOD 1- CYCLE DETECTION USING DFS
    public static boolean isCyclicUsingDFS(ArrayList<Edge>[] graph, boolean[] visited, int current, int parent)  {
        visited[current] = true;
        
        for(int i = 0; i < graph[current].size(); i++) {
            int neighbor = graph[current].get(i).dest;
            if(visited[neighbor] && neighbor != parent) {    // neighbor is already visited and it is not the parent
                return true;
            } 
            else if(!visited[neighbor]) {    // neighbor is not visited yet. So visit it now
                if(isCyclicUsingDFS(graph, visited, neighbor, current)) {  // parent of neighbor would be current
                    // if above condition return false that means cycle does not found at that node then we will go
                    // ahead thats why putted in if codition so that we can check for all nodes
                    return true;
                }
            }
            // As we know we do nothing when : neighbor is visited and it is parent.
        }
        return false;
    }

    // METHOD 2- CYCLE DETECTION USING BFS
    public static boolean isCyclicUsingBFS(ArrayList<Edge>[] graph, int source) {    
        // create a queue
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        // create a parent array which will hold the parent node/vertex for each vertex
        int[] parent = new int[graph.length];
        Arrays.fill(parent, -1);    // fill all indices -1 
        q.add(source);
        visited[source] = true;     // mark the source as visited

        while(!q.isEmpty()) {
            int current = q.poll();
            // add its adjacent/immediate neighbours to the queue

            for(int i = 0; i < graph[current].size(); i++) {
                int neighbor = graph[current].get(i).dest;
                if(!visited[neighbor]) {                // if neighbor not visited visit it
                    visited[current] = true;
                    q.add(neighbor);
                    parent[neighbor] = current;     // add the parent of neighbor as current vertex Simple.
                } 
                // if neighbor is already visited
                else if(neighbor != parent[current]) {    
                // then check if it is not a parent vertex and if not, then cycle must present in the graph
                // (as neighbor is already visited and not parent)
                // and if it is parent then we skip that condition because that does not represent loop
                    return true;
                }
            }
        }
        return false;
    }

    // METHOD 3- CYCLE DETECTION USING DSU (DISJOINT SET UNION) If you don't know about dsu first learn it(useful concept)
    /// https://youtu.be/Kptz-NVA2RE?si=HOChBSakiSLMGizi
    public static boolean isCyclicUsingDSU(ArrayList<Edge>[] graph) {
        // Create a parent array
        int[] parent = new int[graph.length];

        // Initialize all subsets as single element sets (Mark all elements as parent of themsleves)
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // Iterate through all edges of graph, find subset
        // of both vertices of every edge, if both subsets
        // are same, then there is cycle in graph.
        for(int i = 0; i < graph.length; i++) {         // it would be better to use for each loop
            ArrayList<Edge> al = graph[i];
            for(int j = 0; j < al.size(); j++) {      
                Edge e = al.get(j);
                int rootSource = find(parent, e.src);
                int rootDest = find(parent, e.dest);

                if(rootSource == rootDest) {
                    return true;
                }

                union(rootSource, rootDest, parent);
            }
        }
        return false;
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }        
        return parent[i] = find(parent, parent[i]);  
    }

    public static void union(int x, int y, int[] parent) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if(rootX != rootY) {
            parent[rootX] = rootY;
        }
    }


    public static void main(String[] args) {
        /*
               1 -------- 2
             / |          |
            0  |          |  
             \ |          3 
               4
                \__ 5     

              This is unweighted graph but we will still take weight of each node as 1 to follow standard. We can skip it too.
        */

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // METHOD 1- CYCLE DETECTION USING DFS
        System.out.println(isCyclicUsingDFS(graph, new boolean[V], 0, -1));

        // METHOD 2- CYCLE DETECTION USING BFS
        if(isCyclicUsingBFS(graph, 0)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        // METHOD 3- CYCLE DETECTION USING DSU
        System.out.println(isCyclicUsingDSU(graph));


    }
    
}
