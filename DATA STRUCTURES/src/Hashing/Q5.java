package Hashing;

import java.util.LinkedList;

// https://leetcode.com/problems/design-hashmap/description/
// design hash map try yourself first
public class Q5 {
    static class MyHashMap {
        class Node {
            private int value;
            private int key;

            public Node(int key, int val) {  // constructor
                this.key = key;
                this.value = val;
            }
        }
        int n;  // total no of nodes/key-value pair
        int N;  
        LinkedList<Node>[] buckets;     // array of linked list
        @SuppressWarnings("unchecked")
        public MyHashMap() {            // constructor
            this.N = 15;  // initial size of the map/array to r for each map
            this.buckets = new LinkedList[N];
            for(int i = 0; i <buckets.length; i++) {
                this.buckets[i] = new LinkedList<>(); // initialising a LL in all indices of array
            }
        }
        
        private int hashFunction(int key) {
            // int bucketIdx = key.hashCode();
            // we can't use above line bcz our key is not of object type so directly using key
            // value making hashCode out of it.
            return Math.abs(key) % N; // idx should be (0 to N-1)
        }
        private int searchInLL(int bi, int key) {
            LinkedList<Node> ll = buckets[bi]; 
            // having a LL which is pointing to bucket idx of arr
            for(int i = 0; i < ll.size(); i++) { // iterating all nodes of LL
                if(ll.get(i).key == key) {
                    return i;  // nodeIdx
                }
            }
            return -1; // key doesn't exist already

        }

        @SuppressWarnings("unchecked") // u should be smaller in unchecked
        private void rehash() {
            LinkedList<Node>[] oldBucket = buckets;
            N = N*2;
            buckets = new LinkedList[N];
            // lets initialise empty LL in each idx for new buckets
            for(int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            // now copy the nodes from oldBucket to new bucket with bigger size
            for(int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for(int j = 0; j < ll.size(); j++) { //visiting each node of LL of each bi
                    Node node = ll.get(j);  //get() in LL returns the item of given idx 
                    put(node.key, node.value);
                }
            }
        }

        public void put(int key, int value) {
            // first check whether the key already exist or not
            int bucketIdx = hashFunction(key);  
            int nodeIdx = searchInLL(bucketIdx, key);
            if(nodeIdx == -1) {
                buckets[bucketIdx].add(new Node(key, value));  // calling the Node constr.
                this.n++; // updating no of nodes
            } else {
                Node node = buckets[bucketIdx].get(nodeIdx);  
                node.value = value;  // updating the existing key's value
            }

            double lambda = (double)(n/N);  // Load Factor
            if(lambda > 2.0) {      // taking our threshold value as 2 
                rehash();
            }
        }
        
        public int get(int key) {
            int bucketIdx = hashFunction(key);
            LinkedList<Node> ll = buckets[bucketIdx];
            for (Node node : ll) {
                if (node.key == key) {
                    return node.value;
                }
            }
            return -1; // Key not found
        }
        
        public void remove(int key) {
            int bucketIdx = hashFunction(key);
            int nodeIdx = searchInLL(bucketIdx, key);
            if(nodeIdx == -1) {
                return;
            } else {
                buckets[bucketIdx].remove(nodeIdx);
                // remove() method of LL removes & returns the item of given idx from LL.
                n--; // updating n since 1 node is removed
            }
        }

    }
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        // roll no as key and marks as value
        map.put(1,77);
        map.put(2,87);
        map.put(3,99);

        System.out.println(map.get(3));
        System.out.println(map.get(4));
        map.remove(3);
        System.out.println(map.get(3));
    }
}
