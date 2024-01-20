/*
 * https://leetcode.com/problems/course-schedule-ii/
  
The question is nothing just topological sort.
You have to check cycle. If cycle exist topological sorting can't be performed as it is only
for DAGs so return empty array as all courses can't be taken due to contradiction.
Eg 1->2 and 2->1.
Here I am using "Kahn's Algo" for finding top sort order. (BFS)

*/

package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Que1 {
    // public static boolean checkCycle(ArrayList<ArrayList<Integer>> graph, boolean[] visited,
    //                              int curr, boolean[] callStack) {
    //     visited[curr] = true;
    //     callStack[curr] = true;

    //     for(int i = 0; i < graph.get(curr).size(); i++) {
    //         int neighbor = graph.get(curr).get(i);
    //         if(callStack[neighbor] == true) {
    //             // cycle exist
    //             return true;
    //         } else if(!visited[neighbor]) {
    //             if(checkCycle(graph, visited, neighbor, callStack)) {
    //                 return true;
    //             }
    //         }
    //     }
    //     // backtrack to remove removed elements from your call stack too
    //     callStack[curr] = false;
    //     return false;

    // }
    // public static void calculateIndegree(int[] indegree, ArrayList<ArrayList<Integer>> graph) {
    //     for(int i = 0; i < graph.size(); i++) {
    //         for(int it : graph.get(i))
    //         indegree[it]++;    // num of incoming edges
    //     }
    // }

    // public static int[] topologicalSort(ArrayList<ArrayList<Integer>> graph, int V) {
    //     int[] indegree = new int[V];
    //     calculateIndegree(indegree, graph);
    //     int[] ans = new int[V];
    //     Queue<Integer> q = new LinkedList<>();
    //     for(int i = 0; i < V; i++) {
    //         if(indegree[i] == 0) {  // don't depend on anything
    //             q.offer(i);
    //         }
    //     }

    //     int idx = 0;
    //     // bfs
    //     while(!q.isEmpty()) {
    //         int curr = q.remove();
    //         ans[idx] = curr;        // adding topological sort order
    //         idx++;
    //         for(int i = 0; i < graph.get(curr).size(); i++) {
    //             int neig = graph.get(curr).get(i);
    //             // decrement the indegree of neighbors of curr node by  one
    //             indegree[neig]--;
    //             if(indegree[neig] == 0) q.add(neig);
    //         }
    //     }
    //     return ans;
    // }

    // public static int[] findOrder(int numCourses, int[][] prerequisites) {
    //     int V = numCourses;
    //     // if prereq = 0 no requirement for any course to be done in any specific order
        
    //     // Create adjacency list (you can create by using edge class too)
    //     ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //     for(int i = 0; i < V; i++) {
    //         graph.add(new ArrayList<>());
    //     }
    //     for(int i = 0; i < prerequisites.length; i++) {
    //         graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
    //     }
    //     boolean[] visited = new boolean[V];
    //     boolean[] callStack = new boolean[V];
    //     for(int i = 0; i < V; i++) {
    //         if(!visited[i]) {
    //             if(checkCycle(graph, visited, i, callStack)) {
    //                 return new int[] {};  // cycle exist not possible to take all courses
    //             }
    //         } 
    //     }
        
    //     return topologicalSort(graph, V);
        
    // }
/*
NOTE: THE ABOVE ONE WAS MY OWN SOLUTION BUT there i had written sepearate fn for 
checking cycle in the graph but the easy way would be to first store answers in
array list . THIS HELPS US TO GET RID OF EXPLIXITLY CHECKING FOR THE CYCLE 
AS IF TOTAL NUMBER OF ELEMENTS IN LIST WOULD NOT BE EQUAL TO THE V
THAT MEANS CYCLE EXIST all courses are not possible to take  EASY PEASY.. (as topological sort work on dags only so algo will fail
to add items that are in cycle bcz there indegree will not become 0) DAGs has a fact that
it will have at least 1 node which has indegree 0 and atleast one node which has outdegree 0
*/


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int V = numCourses;
        // if prereq = 0 no requirement for any course to be done in any specific order
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        ArrayList<Integer> ans = topologicalSort(graph, V);
        if(ans.size() != V) return new int[] {};  // cycle exist
        int[] res = new int[V];
        
        for(int i = 0; i<res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void calculateIndegree(int[] indegree, ArrayList<ArrayList<Integer>> graph) {
        for(int i = 0; i < graph.size(); i++) {
            for(int it : graph.get(i))
            indegree[it]++;    // num of incoming edges
        }
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> graph, int V) {
        int[] indegree = new int[V];
        calculateIndegree(indegree, graph);
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {  // don't depend on anything
                q.offer(i);
            }
        }
        // bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            ans.add(curr);        // adding topological sort order
            for(int i = 0; i < graph.get(curr).size(); i++) {
                int neig = graph.get(curr).get(i);
                // decrement the indegree of neighbors of curr node by  one
                indegree[neig]--;
                if(indegree[neig] == 0) q.add(neig);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int numCourses = 2;
        int[][] p = new int[][] {};
        System.out.println(Arrays.toString(findOrder(numCourses, p)));
    }
}
/*
time complexity is O(V + E)
space complexity is O(V).
*/