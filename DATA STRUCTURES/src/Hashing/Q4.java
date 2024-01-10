// find itinerary from the given list of tickets
// itinerary meaning : a planned route or journey
// https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
package Hashing;

import java.util.HashMap;
import java.util.Map;
  
public class Q4 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Banglore");
        map.put("Bombay", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi","Goa");

        findItinerary(map);
    }

    private static void findItinerary(HashMap<String, String> tickets) {
        // One Solution is to build a graph and do Topological Sorting of the graph. The time
        // complexity of this solution will also be O(n). But here I will ignore creating graph
        // rather use hashing.

        String start = findStart(tickets);
        while(tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.println(start); // bcz the final destination city would also be not present in the key


    }

    public static String findStart(HashMap<String, String> map) {
        HashMap<String, String> revMap = new HashMap<>();
        for(Map.Entry<String, String> entry : map.entrySet()) {
            revMap.put(entry.getValue(), entry.getKey());
        }

        for(String key : map.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;  // this is our starting bcz at this key(city) no plane is coming only going from it so it is our starting
            }
        }

        return null;
    }
}
