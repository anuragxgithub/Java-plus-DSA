
// https://leetcode.com/problems/bus-routes/

//1. Create a HashMap, key is going to be RouetNo/stop and value is going to be a HashSet which contains BusNo
//2. BFS - making a queue.
//3. Count how many buses we have to go on
//4  Take our HashMap get the hashSet for the buses at the curr stop
//5. Check to see if we have been on this bus before (using another hashset)
//6. For every stop on this bus check to see if it is the target if not add this stop to the queue.

package Graphs.Questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BusRoutes {
    // Making adjacency list is not possible since we don't know the number of routes
    // least number of buses, so we can think of using queue (BFS) 

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;

//1. Create a HashMap, key is going to be RouetNo/stop and value is going to be a HashSet which contains BusNo
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                HashSet<Integer> busSet = (map.containsKey(routes[i][j])) ? map.get(routes[i][j]) : new HashSet<>();
                busSet.add(i);
                map.put(routes[i][j], busSet);
            }
        }
//2. BFS - making a queue.
        Queue<Integer> q = new LinkedList<>();
        q.add(source);  // add stop/routeNo
//3. Count how many buses we have to go on
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();

        while(!q.isEmpty()) {
            count++;   // bcz we are on a new level
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int currStop = q.poll();
                HashSet<Integer> buses = map.get(currStop);
                if(buses != null) { // why this? bcz what if source is any route which is not present in routes[][] in that case hashSet will be null
                    for(Integer bus : buses) { 
//5. Check to see if we have been on this bus before (using another hashset)
                        if(visited.add(bus)) {   // two work at same time
                            for(Integer stop : routes[bus]) {
//6. For every stop on this bus check to see if it is the target if not add this stop to the queue.
                                if(stop == target) return count;
                                q.add(stop);
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }




    public static void main(String[] args) {
        int[][] routes = new int[][] {{1,2,7}, {2,6,7}, {6,8,9}};  // Dry run on this it will become clear
        System.out.println(numBusesToDestination(routes, 7, 8));
    }
}
