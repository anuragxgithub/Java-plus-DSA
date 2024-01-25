

/*
https://www.geeksforgeeks.org/problems/is-it-a-tree/1

NOTE IF SELF LOOP OR ANY KIND OF LOOP IS PRESENT NOT A TREE AND IF DISCONNECTED COMPONENTS
ARE PRESENT NOT A TREE.
*/

package Graphs.Questions;

import java.util.ArrayList;

public class TreeOrNot {
    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int current, int parent)  {
        visited[current] = true;
        
        for(int i = 0; i < graph.get(current).size(); i++) {
            int neighbor = graph.get(current).get(i);
            if(visited[neighbor] && neighbor != parent) {
                return true;
            } 
            else if(!visited[neighbor]) { 
                if(dfs(graph, visited, neighbor, current)) {  
                    return true;
                }
            }
            // As we know we do nothing when : neighbor is visited and it is parent.
        }
        return false;
    }
    
    //User function Template for Java
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)  graph.add(new ArrayList<>());
        
        for(ArrayList<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        boolean[] visited = new boolean[n];
        if(dfs(graph, visited, 0, -1)) {
            return false; // cycle exist
        }
        for(int i = 0; i < n; i++) {
            if(visited[i] == false)  return false;
            // bcz disconnected components are present thts why not all node got visited
        }
        
        return true;
    }
}
