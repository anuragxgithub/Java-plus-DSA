/*
Articulation Point : A vertex v is called as an AP if after removing it from the graph the connected components
of the graph increases.
 
SO HERE WE'LL DISCUSS THE OPTIMISED ALGO which is finding the Articulation Point using "TARJAN'S ALGO" in an 
undirected graph.

Since the algo is Tarjan's Algo so this would be almost similar to the algo which we had written while
finding bridge in graph.

Data Structures Used:
dt[] : It maintains the time when a node is visited. Like if we visit node 1 and then node 2 then dt of 1 will be 1
        and dt of node 2 will be 2.
lowdt[] or low[] : is the lowest discovery time of a node. Lowest Discovery time of a node is the lowest discovery time among all the nodes
                    connected to it including itself but not the parent node. 
                    Eg: lowdt of v is the lowest lowdt among all the nodes connected to it directly or indirectly 
                    inclding itself but excluding its parent which is u.                                        
                             y  
                            /  
                     u --- v -- x
                            \
                             z
visited[]
ap[] : to track which node is our ap.

We'll be having these main 3 Conditons:
1- Neighbor is parent of current node. In this case we don't know whether this node would be ap or not. So we'll just
ignore.
2- If neighor is already visited then we'll simply update the lowdt of our currrent node which we used to do 
   in bridge finding. (note compare with neighobrs dt[neighbor] bcz (cycle case))
3- If neighor is not already visited : then we first visit it and update the lowdt of current node by comparing its
   lowdt to neighobrs lowdt as ususal. Now extra step is added compare the lowdt[curr] with lowdt[neig] and also check
   that parent should not be equal to -1 i.e, root node(from where dfs is starting) if these both conditions are true
   then "The current node will be our AP."
   
4- We also have to maintain the children count of each node so that we can later find out that if a node
   is root(parent == -1) and its chldren is greater than 1 "then this node would be our AP".
   Children of a node will be the no. of its neighbors with the condition that they should not be connected with 
   each other directly or indirectly. If they are connected dir. or indire. then they will be couted as single child.
   Eg:
                1
               / \
           3--2   5--6
              |
              4   
        No. of Children of '1' is 2, and for '2' it is 2 and for '5' it is 1. 
        Bcz we'll update children only when visted[neig] == false.


DRY RUN TO UNDERSTAND
*/

package Graphs.IncreasingConnectedComponents;

import java.util.ArrayList;

public class ArticulationPoint2 {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int V) {
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
            1 -- 0 -- 3
            |   /     |
            |  /      |
            | /       |
            2         4

            Here there is 2 Articulation Points in graph and those are : 0 and 3

        */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    /*       0
            / \
        2--1   4--5
           |
           3
           APs are 0, 1 and 4
    */  
        // graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,4));

        // graph[1].add(new Edge(1,0));
        // graph[1].add(new Edge(1,2));
        // graph[1].add(new Edge(1,3));

        // graph[2].add(new Edge(2,1));
        // graph[2].add(new Edge(3,1));

        // graph[4].add(new Edge(4,0));
        // graph[4].add(new Edge(4,5));

        // graph[5].add(new Edge(5,4));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int parent, int[] dt, int[] lowdt, int time,
                            boolean[] visited, boolean[] ap) {
                        
        visited[curr] = true;
        dt[curr] = lowdt[curr] = ++time;
        int children = 0;
        for(int i=0; i<graph[curr].size(); i++) {
            int neighbor = graph[curr].get(i).dest;

            if(parent == neighbor) {
                continue;           // we don't know whether ap or not
            } else if(visited[neighbor]) {
                // update the lowest dt of the curr node (cycle case bcz curr is already visited and neigh is not parent of cur)
                lowdt[curr] = Math.min(lowdt[curr], dt[neighbor]);  // since neighbor is already visited so we'll compare
                // the dt of neighbor with lowdt of curr, already done this is tarjan's algo
            } else {
                // neighbor is not visited-- then visit it and apply the remaining logic
                dfs(graph, neighbor, curr, dt, lowdt, time, visited, ap);
                lowdt[curr] = Math.min(lowdt[curr], lowdt[neighbor]);
                if(dt[curr] <= lowdt[neighbor] && parent != -1) {  //NOTE    <=
                    ap[curr] = true;
                }
                children++;      // this updation should be in non-visited if statement
            }
        }
        if(parent == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge>[] graph, int V) {
        // following d.s. will be used
        int[] dt = new int[V];
        int[] lowdt = new int[V];
        int time = 0;
        boolean[] visited = new boolean[V];
        boolean[] ap = new boolean[V];          // keep track which vertiex is an ap


        for(int i = 0; i < V; i++) {    // bcz graph can be in differenct connected comp. so make sure to visit all nodes 
            if(!visited[i]) {
                dfs(graph, 1, -1, dt, lowdt, time, visited, ap);
            } 
        }

        for(int i=0; i<V; i++) {
            if(ap[i]) {
                System.out.println("AP : " + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);

        getAP(graph, V);
    }
}
/*
    Que: Why not printing the AP ? And marking APs and then returning it??
    Ans: You can do that too but it may be possible one node can be the AP multiple times. That's why we choose 
         to mark it. 


 * Everything is almost same as finding bridge in a graph using tarjan's algo few extra lines are added
 * and 1 is modified. Although the logic is lil bit lengthy but if logic is clear in mind then it would be easy.
 * 
 * Time : O(V+E) 
 * Space : O(V)         (In the worst case, the space required for the function call stack is O(V).)
 */