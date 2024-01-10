/*
 * A hash table, also known as a hash map.
 * HashMap is another data structure in java like HashSet but it stores key-value pair.
 * HashMap is an unordered collection of key-value pairs.
 * And obviously all keys must be unique but values can be same.
 * Here also the avg. time complextiy of adding , deleting and retrieving values is O(1). 
 */

package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class HashMap_ {
    public static void main(String[] args) {
        // country(key) and population(values)
        HashMap<String, Integer> map = new HashMap<>();  // type parameter(KeyTyep, ValueType)

        // insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        System.out.println(map);
        map.put("China", 180); // it will update the existing key's value
        System.out.println(map);

        // Searching  (1. containsKey(key) 2. get(key))
        if(map.containsKey("India")) {
            System.out.println("Key is present in the HashMap");
        } else {
            System.out.println("Key is not present in the HashMap");
        }

        System.out.println(map.get("China"));   // if key exists return its value
        System.out.println(map.get("Israel"));  // if key does not exist return null

        // iteration of HashMap << 1 ⭐>>
        // we use for each loop to iterate
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        // Map.Entry is an interface that represents a key-value pair in a map.
        // Above entrySet() method returns the "Set" view of the mappings contained in the given map.
        // and each set pair is accessed one by one using e and we are printing its value and key using
        // getKey() and getValue() method.
        // https://chat.openai.com/share/d18c276e-cabb-4f23-91d9-323ea5fafbc3

        // another way to iterate not much used but know << 2 ⭐>>
        // first we make the set of the keys using keySet() method
        
        Set<String> keys = map.keySet();  // keySet() unlike entrySet() only creates set of keys
        for(String key : keys) {
            System.out.println(key + " " + map.get(key));
        }


        // removal
        HashMap<Integer, String> hm = new HashMap<>();  // (roll no and name)
        hm.put(1, "Anurag");
        hm.put(2, "Justin");
        hm.put(3, "Rohit");
        System.out.println(hm);

        hm.remove(2);  // give key and that key value pair will be removed from the collection

        System.out.println(hm);

        System.out.println(hm.size());

        // Another way to iterate HashMap using Iterator is : << 3 ⭐>>

        // Obtain the set of entries (key-value pairs)
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        // Create an iterator from the entry set
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

        // Iterate over the pairs using the iterator
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
