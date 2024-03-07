/*
 IMPLEMENTATION OF HASHMAP
 Note: HashMap is implemented using the ★ARRAY OF LINKED LIST★ (As like we create array of int,str,etc)
 Hashing : Hashing is basiclly changing data from one form to any other form. There are various Hashing algorithms like
 Sha1, Sha256, and so on.
 Java has provided us with its implementation of Hashing algo.
 This hashing is very useful to store passwords.

 The worst case time complexity of HashMap can be O(n) which is very rare bcz it happens only when
 our hashFuntion is not optimised and all nodes are present in only one bucket (or coincidently our
 hashFn may give same bucketIdx for most of the keys). And whenever these types of cases occur our
 λ becomes > k due to which we might have to do rehasing many times which results in o(n) T.C.

 But usually(maxium time) we talk of avg case T.C. in HashMap and that is O(λ) which we can say is constant time.
 IMPORTANT TOPIC FOR INTERVIEWS
                https://youtu.be/KDZ_IXvpMG4?si=ztD8YMDW3-6f3oUp

 You may find this confusing so clear it here:  ★★★★
 as we know LinkedList<Integer> ll..  so in this ll if we do ll.get(idx) it will return an integer value of the given idx bcz ll is having values of type int easy.
 Now if we have LinkedList<Node> ll.. so in this ll if u do ll.get(idx) it will return a node of given idx bcz ll is having values of Node type here easy peasy.
 Also you can rename di to nodeIdx everywhere bcz that makes more sense and easy to catch.
 Prerequisite : Nothing much but if you can go and read this once it will be good (src/LinkedList/_1_LinkedList.java)
 */
// Note: If you are comparing objects eg Integer, String, etc use equals() method to be error free in future.
package Hashing;

import java.util.LinkedList;
import java.util.ArrayList;

public class HM_Implementation {
    static class HashMap<K, V> {    // generics or type parameters

        class Node {
            K key;
            V value;

            public Node(K key, V val) {      // cosntructor of class Node
                this.key = key; 
                this.value = val;
            }
        }

        private int N;                         // no of buckets/indices/size of arr  
        private int n;                                 // total no of nodes
        private LinkedList<Node>[] buckets;        // as like: private int[] arr; N = bucketes.length

        @SuppressWarnings("unchecked")  // u should be smaller
        public HashMap() {          // constructor of class HashMap
            // and we know as we create an obj. of this class then this non parameterized constr. will be called
            this.N = 4;     // initially taking N as 4
            this.buckets = new LinkedList[N];       // creating array of linked list with size N as like: new int[];
            for(int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();  // initialising a LL in all indices of array 
            }
        }

        private int hashFunction(K key) {   // returns the bucketIndex
            int bi = key.hashCode();   // this hashCode() works with object type only if our key is of type int then it give error but here it is Wrapped in wrapper class so it will be considered object type see line 206
            // this method returns any hashCode no. generated for the key can be +ve or -ve
            return Math.abs(bi) % N;
            // why modulo by 4? simple logic bcz bi should be b/w (0 to (N-1))
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];      // having a LL which is pointing to bucket idx of arr
            for(int i = 0; i < ll.size(); i++) { // iterating all nodes of LL
                if(ll.get(i).key == key) {      // we should use .equals() method here i think
                    return i;  // di
                }
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash() {  // as we know theory of rehasing (increasing the size of array)
            LinkedList<Node>[] oldBucket = buckets;
            N = N*2;        // update the value of N
            buckets = new LinkedList[N];  // for this warning, we put @
            // now our bucket/arr size doubled and all buckets are empty so lets first initialise the empty LLs in them
            for(int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // now copy the nodes from old bucket to new buckets
            for(int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for(int j = 0; j < ll.size(); j++) {       // traverse through all nodes in any particular bucket
                    Node node = ll.get(j);  // line 11
                    put(node.key, node.value);
                }
            }
        }

        // put() method
        public void put(K key, V value) {
            // check if key already exist or not    (bi -> bucketIdx, di -> dataIdx(u can also call it NodeIdx where key is present))
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);     // searchInLL return the index of node where key is present(if it come out -1 that means key doesn't exist already & if it is >= 0 that means key already exist)
            if(di == -1) {  // key doesn't exist
                buckets[bi].add(new Node(key, value));  // adding elements in LL of type Node. add() method adds element at the last of LL
                this.n++;        // no. of node updated
            } else {        // key already exist
                Node node = buckets[bi].get(di);
                node.value = value;  // updated the existing key's value
            }

            double lambda = (double)n/N;            // (load Factor -> no of stored elements(k-v pair) / total no of buckets)
            if(lambda > 2.0) {      // 2 here is our constant K (taking it as 2)
                rehash();
            }
        }

        // get() method  -> returns the value assciated with the key if no key returns null
        public V get(K key) {
            // first find the bucket idx of the key
            int bi = hashFunction(key);
            LinkedList<Node> ll = buckets[bi];
            for (Node node : ll) {
                if (node.key == key) {
                    return node.value;
                }
            }
            return null; // Key not found
            
        }

        // containsKey() method 
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);   //you can name it nodeIdx too that also makes sense
            if(di >= 0) {
                return true; // key exist
            }

            return false; // key doesn't exist
        }

        // remove() method    -> removes vaue of the removed key-value pair if exist else return null
        public V remove(K key) {
            int bi = hashFunction(key);
            int nodeIdx = searchInLL(key, bi);
            if(nodeIdx == -1) {     // key doesn't exist
                return null;
            }

            Node node = buckets[bi].remove(nodeIdx);  // removing the node where it the key was present
            // in ll remove() method removes the element of that idx and returns it.
            n--;
            return node.value;
        }

        // isEmpty() method
        public boolean isEmpty() {
            return n == 0;
        }

        // keySet() method  -> returns the set of keys in an ArrayList
        public ArrayList<K> keySet() {
            ArrayList<K> list = new ArrayList<>();

            for(int i = 0; i < buckets.length; i++) {  // T.C. -> O(N*n)
                LinkedList<Node> ll = buckets[i];    // gets the linked list of given bucket
                for(int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    list.add(node.key);
                }
            }
            return list;
        }
        
        // size() method  --> return the number of key-value pairs present in the LL
        public int size() {
            return n;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();  // this is our created hm not the inbuilt one
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);
        map.put("Australia", 45);
        map.put("Nepal", 30);
        System.out.println(map.get("Nepal"));
        map.put("Nepal", 20);
        System.out.println(map.get("Nepal"));

        System.out.println(map.get("India"));
        System.out.println(map.containsKey("US"));
        System.out.println(map.remove("Australia"));

        System.out.println(map.isEmpty());
        ArrayList<String> keys = map.keySet();
        for(int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " : " + map.get(keys.get(i)));      // this keys.get() is method of ArrayList
        }

        System.out.println(map.size());

        System.out.println(map.get("Australia"));
    }
}

/*
If your key is of type int, and you want to create a custom hashFunction for it, you don't need to call key.hashCode()
because primitive int does not have a hashCode() method. Instead, you can use the key directly as your hash function. 
Here's how you can modify your hashFunction for int keys:
private int hashFunction(int key) {
    return Math.abs(key) % N; // Adjust N as needed for the number of buckets
}
*/


// NOTE: If we can implement put() method then every other method is just nothing easy peasy.

// USE LARGER SIZE OF THE ARRAY LIKE HERE WE HAVE TAKEN 4 IT MAY LEAD TO A POOR DISTRIBUTION OF KEYS AND INCREASE
// COLLISON ITS IDEAL TO INITIALISE WITH SOME BIGGER VALUE.


