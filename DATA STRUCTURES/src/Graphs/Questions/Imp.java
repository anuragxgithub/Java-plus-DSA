
/*
https://leetcode.com/problems/find-eventual-safe-states/description/

Simple obervation is : (Use pen and paper and draw the graph in usual way)
1. If anynode is part of the cycle then it can't be a safe node. 
   (because in cycle each node has atleast one outgoing edge)
2. And any node which leads(pointing) towords a cycle can't be a safe node too.
3. Remaining all the vertices are safe node.
*/

package Graphs.Questions;

import java.util.ArrayList;
import java.util.List;

public class Imp {
    public boolean dfs(int[][] graph, boolean[] visited, boolean[] stack, boolean[]        isSafeNode, int curr) {
        visited[curr] = true;
        stack[curr] = true;
        // traverse for neighbors
        for(int neigh : graph[curr]) {
            if(!visited[neigh]) {
                if(dfs(graph, visited, stack, isSafeNode, neigh) == true) {
                    return true;   // cycle exist
                }
            } else if(stack[neigh] == true) {
                return true;  // cycle exist
            }
        }
        isSafeNode[curr] = true;   // this will execute if none if the above return true executed
        stack[curr] = false;   // backtrack
        return false;   // no cycle
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] stack = new boolean[n];
        boolean[] isSafeNode = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(graph, visited, stack, isSafeNode, i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(isSafeNode[i] == true) {
                list.add(i);
            }
        }
        return list;
    }
}
/*
NOTE : YOUR HOMEWORK IS TO IMPLEMENT IT USING BFS AND TOPO SORT
Time : O(V+E)
Space : O(n)
*/