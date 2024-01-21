
/*
https://leetcode.com/problems/possible-bipartition/
SOLVED IT IN FIRST ATTEMPT WITHOUT HELP :)

 So the intuition is to store all person and their haters/disliker and make a graph
 conneting people whose dislike each other adjacently. Why??
 Becaue now we can apply bipartite finding algo to this graph so now the adjecent guys will go to different set. 
 (bcz they will get different color)
 So if bipartite algo return true that the graph is bipartite that means we can split all person
 into two groups successfully.
*/
package Graphs.BipartiteGraph;

import java.util.ArrayList;
import java.util.Arrays;

public class Que2 {
    // using dfs  (Taking 0 and 1 as colors)
    public boolean isBipartite(ArrayList<Integer>[] graph, int[] color, int curr, int clr) {
        color[curr] = clr;

        for(int i = 0; i < graph[curr].size(); i++) { // here we will start from 0 logical reason bcz we will find each node's neighbor from 0th idx
            int neigh = graph[curr].get(i);
            if(color[neigh] == -1) {
                if(isBipartite(graph, color, neigh, 1-clr) == false) {
                    return false;
                }
            } else if(color[neigh] == clr) {
                return false;
            }
        }
        return true;
    } 


    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Create a adjacency list each idx denotes node(person) and it stores people
        // who dislike him
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[n+1];  // bcz 1 based indexing is required
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] arr : dislikes) {
            graph[arr[0]].add(arr[1]);
            graph[arr[1]].add(arr[0]);
        } // undirected graph ready

        int[] color = new int[n+1];
        Arrays.fill(color, -1);  // don't forget this
        for(int i = 1; i < n+1; i++) {  // checking for each component if multiple exist
            if(color[i] == -1) {
                if(!isBipartite(graph, color, i, 0)) {
                    return false;  // not bipartite
                }
            }
        }
        return true;
    }
}
/*
Time : O(V+E)
Space : O(v)
*/