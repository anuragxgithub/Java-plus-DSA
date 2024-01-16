
/*
In such types of questions you should be able to draw the graphs. If you actually understands the question implementing
its soultion would be easy.

I WAS ABLE TO IMPLEMENT IT BY MY OWN
*/

package Graphs.Questions;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class NumOfProvinces {

    public static void dfs(ArrayList<ArrayList<Integer>> edges, boolean[] visited, int curr) {

        if(!visited[curr]) {
            visited[curr] = true;
            for(int i = 0; i < edges.get(curr).size(); i++) {
                int neighbor = edges.get(curr).get(i);
                dfs(edges, visited, neighbor);
            }
        }
    }


    public static int findCircleNum(int[][] isConnected) {
        // Appraoch 2- DFS (1 was Union Find in Disjoint set directory)

        int n = isConnected.length;    // n is number of veritces in the graph 
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();  // n*n grid is given
        for(int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {        // O(n^2)
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1 && i != j) {      // why?(i != j) bcz it is obvious that any city will be connected to itself(self node)
                    edges.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {        // since graph can be disjoint thats why iterating from each non visited vertex
            if(!visited[i]) {
                cnt++;          // everytime a vertex is not visited count it as province bcz it must be connected to itself atleast 
                                // (counting the connected components)
                dfs(edges, visited, i);
            }
        }
        return cnt;
    }    

// --------------------------- HERE BFS APPROACH -----------------------------------------------//

    public static void bfs(ArrayList<ArrayList<Integer>> edges, boolean[] visited, int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()) {
            int curr = q.poll();
            if(!visited[curr]) {
                visited[curr] = true;

                for(int i = 0; i < edges.get(curr).size(); i++) {
                    // add the neighbors to the q
                    int neighbor = edges.get(curr).get(i);
                    q.add(neighbor);
                }
            }
        }
    }
    public static int findCircleNumBFS(int[][] isConnected) {
        // Appraoch 3- (BFS)

        int n = isConnected.length;    // n is number of veritces in the graph 
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();  // n*n grid is given
        for(int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {        // O(n^2)
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1 && i != j) {      // why?(i != j) bcz it is obvious that any city will be connected to itself(self node)
                    edges.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {        // since graph can be disjoint thats why iterating from each non visited vertex
            if(!visited[i]) {
                cnt++;          // everytime a vertex is not visited count it as province bcz it must be connected to itself atleast 
                                // (counting the connected components)
                bfs(edges, visited, i);
            }
        }
        return cnt;
    }



    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(findCircleNum(isConnected));
        System.out.println(findCircleNumBFS(isConnected));
    }
}

/*
Space complexity :   (ignoring the adjacency list bcz in most of the problems it is already given)
Recursion calls: O(n)  (when graph is skewed)
Visited Array : O(n)
So overall S.C. : O(n)

Time complexity:  (ignoring creationg of adjacency list)
dfs() : O(V+2E)
for loop to call dfs : O(n)

Overall time complexity would be nearly about O(n) not exactly.
But Still i think time complexity would be O(n^2). Recheck it.
*/ 
/* FOR BFS:
Space complexity :   (ignoring the adjacency list bcz in most of the problems it is already given)
O(n)

Time complexity:  (ignoring creationg of adjacency list)
O(n^2).

 */