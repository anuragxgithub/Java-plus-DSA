
/*
https://leetcode.com/problems/is-graph-bipartite/
https://www.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph

*/

package Graphs.BipartiteGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Que {
    public static boolean isBT(int[][] graph, int[] color, int start, int V) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()) {
            int curr = q.remove();
            // check for neighbors
            for(int i = 0; i < graph[curr].length; i++) {
                int neigh = graph[curr][i];
                if(color[neigh] == -1) {

                    color[neigh] = 1 - color[curr];
                    q.add(neigh);
                }
                // if colored and color of neigh and curr node same then not a bp graph
                else if(color[neigh] == color[curr]) {
                    return false;
                }
            } 
        }
        return true;
    }

    // LC
    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {  // check for all components
                if(!isBT(graph, color, i, V)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {{1,3},{0,2},{1,3},{0,2}};

        System.out.println(isBipartite(graph));
    }
}
/*
Time : O(V+E)
Space : O(v)
*/