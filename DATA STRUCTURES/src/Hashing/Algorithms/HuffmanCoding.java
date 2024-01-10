/*
Huffman coding is a widely used algorithm for lossless data compression.
Huffman coding is widely used in various applications, including file compression algorithms like
ZIP and JPEG for image compression. The efficiency of Huffman coding lies in its ability to
allocate "shorter codes to more frequent symbols", resulting in a reduction in the overall number
of bits needed to represent the data.

Steps for the below implemented HuffmanCoding Algo. :
1. Create two hashMaps which will be our encoder(Char, String) and decoder<String, Char>.
2. Parse the input string and make a frequencyMap (stores the occurrences of characters).
3. For every set/key in frequencyMap create a node and insert that node in a minHeap.
    Node class would contain-> char data, int cost/freq. , Node left and Node right;
    Initially the left and right of nodes will point to null.
4. Remove 2 nodes from the minHeap(comparison will be done according to the cost) least cost node
   will be removed first. And then combine the two nodes by giving it value/data of null, cost which
   is sum of both the nodes and left and right would be the two nodes which we removed. 
   Forming a tree like structure. Now add the combined node back to the minHeap.
   Repeat this process until size of minHeap > 1. This last remaining node would be the root
   node of the Huffman Tree.
   Now with the help of the root node we'll mark down all node.left with 0 and all node.right with
   1 which will later help us to give codes to specific symbol/character.
   Clearly by looking at the Huffman Tree you can verify this statement:
   "shorter codes to more frequent symbols".
5. Initialise encoder and decoder maps. Store the unique chars. in their codes in them.
   In encoder map characters are stored as key and their corresponding codes as value.
   In decoder map codes are stored as key and their corresponding characters as value. 
6. Now create encode method (takes input string) and encode it with the help of codes available for
   for each character/symbol in the encoder map and also create decode method (takes encoded string)
   and convert it into original form with the help of decoder method.
   
*/

package Hashing.Algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCoding {
    // creating "encoder" and "docoder" hashmap
    HashMap<Character, String> encoder;  // character as key
    HashMap<String, Character> decoder;  // string as key

    // creating "Node" for every key in frquencyMap
    private class Node implements Comparable<Node> {  // since we nee to compare two node objs.
        Character data;
        int cost;   // frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {                     // COSNTRUCTOR
            this.data = data;
            this.cost = cost;
            this.left = null;     // initially the left and right of each node will be null
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {  // as we know we need to override comapreTo method to compare objects 
            return this.cost - other.cost;  // comparing on the basis of cost/freq.
        }
    }

    public HuffmanCoding(String feeder) throws Exception {           // CONSTRUCTOR
        // creating "frequency map"
        HashMap<Character, Integer> fmap = new HashMap<>();   // will store the freq/occurrence of characters from string
        for(int i = 0; i < feeder.length(); i++) {
            char c = feeder.charAt(i);
            if(fmap.containsKey(c)) {
                fmap.put(c, fmap.get(c)+1);
            } else {
                fmap.put(c, 1);
            }
        }

        // creating minHeap to insert nodes(key value pair set of frq. map) in it
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();
        // Make node for each set(key value pair) of freq. map
        for(Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.add(node);  // Adding the nodes in minHeap
        }

        // Remove 2-2 nodes from minHeap one by one and combine them (and insert combined one back)
        // till size of minHeap is > 1
        while(minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            // combine them
            Node newNode = new Node('\0', first.cost + second.cost);  // '\0' represents the null character. special char. with Unicode value of zero (0)
            newNode.left = first;
            newNode.right = second;

            minHeap.add(newNode);
        }
        
        // Now with the help of root node of tree which we created with left and right field w'll create encoder and decoder map
        // Note: The root node will be the combination of all the nodes simple logic
        // and the Last remaining node in heap will be the root node. 

        Node rootNode = minHeap.remove();  // root node of Huffman Tree
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();
        
        this.initEncoderDecoder(rootNode, "");


    }
    // creating a method to initialse the encoder & decoder map to store the codes for the character in (0s and 1s)
    private void initEncoderDecoder(Node node, String outputSofar) {
        // all the character nodes are present at the leaf nodes
        if(node == null) {
            return;
        }
        if(node.left == null || node.right == null) {  // means you are at leaf node
            this.encoder.put(node.data, outputSofar);
            this.decoder.put(outputSofar, node.data);
        }

        // putting node.left and node.rigt as 0 and 1 respectively.
        initEncoderDecoder(node.left, outputSofar+"0");
        initEncoderDecoder(node.right, outputSofar+"1");
    }

    // encode method to encode the input string
    public String encode(String source) {
        StringBuilder encodedData = new StringBuilder();
        for(int i = 0; i < source.length(); i++) {
            encodedData.append(encoder.get(source.charAt(i)));
        }
        return encodedData.toString();
    }
    
    //decode method to decode the encoded string
    public String decode(String encodedData) {
        StringBuilder decodedData = new StringBuilder();
        StringBuilder key = new StringBuilder();
        for(int i = 0; i < encodedData.length(); i++) {
            key.append(encodedData.charAt(i));
            if(decoder.containsKey(key.toString())) {
                decodedData.append(decoder.get(key.toString()));
                key.setLength(0);  //clear the stringBulder for the next key. But why?⬇️
                // bcz our tree is making sure that "no value/code is prefix of another value/code". (TimeStamp : 22:12)
            }
        }
        return decodedData.toString();
    }
    

/*
NOTE : HERE IN THIS CODE WE JUST GET AN IDEA HOW HUFFMAN CODING WORKS BUT WE DIDN'T ACHIEVED OUR
       OUT GOAL i.e, "COMPRESSING THE FILE/STRING" BECAUSE HERE INSTEAD OF USING BITS WE HAVE
       USED STRING. SO, no compression of string is performed.
⭐"WE CAN ACHIEVE THIS USING : BITSET, LIKE AN ARRAY BUT WITH A BIT AT EACH INDEX." H.W. But this is enough.⭐

1. The compareTo() method is often associated with the Comparable interface in Java. When you 
   implement the Comparable interface in a class and override the compareTo() method, you provide 
   a way for instances of that class to be compared with each other. In the context of a min-heap, 
   this comparison is crucial for maintaining the heap property.

2. Time Comlexity: O(N log M),  N is the length of the input string. {2*(n-1) removal and addition toal in heap removing constants the n. Cost of removal and addition is logn}
                                M is the number of distinct characters in the input string
   Space Complexity: O(N + M),
   M is often much smaller than N, so the space complexity is often close to O(N).
 */



    public static void main(String[] args) throws Exception {
        String str = "abbccda";
        HuffmanCoding hc = new HuffmanCoding(str);

        String encodedMessage = hc.encode(str);
        System.out.println("Encoded String is : " + encodedMessage);

        String dmsg = hc.decode(encodedMessage);
        System.out.println("Decoded String is : " + dmsg);
    }
}
