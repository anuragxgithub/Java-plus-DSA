
/*
https://www.geeksforgeeks.org/problems/topological-sort/1
Used BFS ALGO FOR FINDING TOPOLOGICAL SORT (KAHN'S ALGO)
*/
package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Que1 {
    public static void calculateIndeg(ArrayList<ArrayList<Integer>> graph, int[] indeg) {
        // to calculate indegree simply calculate the number of times a node is becoming dest of other node
        for(int i = 0; i < graph.size(); i++) {
            for(int j = 0; j < graph.get(i).size(); j++) {
                indeg[graph.get(i).get(j)]++;
            }
        }
    }
    
    public static int[] topologicalSort(ArrayList<ArrayList<Integer>> graph, int V) {
        int[] indeg = new int[V];
        calculateIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indeg.length; i++) {
            //add the vertices whose indegree is 0 (that means which don't depend on any other node)
            if(indeg[i] == 0) {
                q.add(i);
            } 
        }
        int[] ans = new int[V];
        int idx = 0;
        
        // bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            ans[idx] = curr;   // topological sort order
            idx++;
            
            for(int i = 0; i < graph.get(curr).size(); i++) {
                int neigh = graph.get(curr).get(i);
                // decrement the in degree of the neigh node
                indeg[neigh]--;
                if(indeg[neigh] == 0) {
                    // if after decrementing neig's indeg value it becomes 0 add it to queue
                    q.add(neigh);
                }
            }
        }
        return ans;
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        return topologicalSort(adj, V);
    }
}
