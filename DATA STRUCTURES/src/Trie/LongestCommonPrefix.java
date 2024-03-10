/*

THIS IS MY OWN IMPLEMENTATION CODED IT IN FIRST ATTEMPT.


APPROACH:
1. Create a trie data structure obviously bcz here we need to deal with string searching
   specially prefixes.
2. While creating Trie data structure we have to add a little tweak and that is we will 
   use a pointer/variable (frequency) for each node. For each node it will tell how many
   words uses (have common) this node.
   For eg : "flow" , "flip" both will use the node f and l  so freq of these nodes here will
   be 2.
   This little tweak would be done in insert method.
3. Half job is done. Now from common observation we can say following things:
   -> If any string in strs is empty longest common prefix would be "".
   -> If any word's first char is not matched with first char of other words again lcp would be "".
   Now if the above conditions comes out to be false then do following things:
   -> Insert the words from strs in trie.
   -> Create a method(here in my code findLCP()) which will bring our ans.

4. findLCP() would take any string from strs and length of strs(len).
   But why??
   Let's see:
   Now the question is how we will leverage the freqency and how we can find out ans??
   SIMPLE: 
   WHAT IS A VALID LONGEST COMMON PREFIX (LCP) ?
   -> Nodes which will have same freq as len of strs(len) will be a valid LCP.
      bcz that means all words from str have these nodes in common.
   -> So we will pick any word from strs (bcz word don't matter, we need lcp which is 
      common in all so pick any) and check all its nodes from trie, we will keep adding chars
      from the nodes where (freq == length of strings) if any node have less freq then len
      we will break out from there and return the collectes chars strings so far.

NOTE: Initially for each node freq is 1 bcz if we are inserting something it will have
      a freq of 1. Pretty Logical. And in trie we know only new nodes are created only when
      prefix of current word do not match with the already existing prefix.
      Eg: words: "flow" and "fli" if we inserted flow then if we insert fli only new node
      of i will be created "f,l" will be used of "flow" word so in this case initially
      freq of f and l was 1 and when we inserted "fli" freq of f and l got incremented 
      bcz we designed our insert method in this way and for i new node got created which
      will by default would have freq of 1. 
*/

package Trie;

public class LongestCommonPrefix {
    static class Node {
        Node[] children = new Node[26];          // each edx represent chars from a to z you can change the size according to your character storing requirements 256 to include all chars in java
        // store value of Node type.
        boolean eow = false;      // end of word
        int freq;

        public Node() {             // constructor
            for(int i = 0; i < 26; i++) {
                children[i] = null;
                freq = 1;
            }
        }
    }
    public static Node root = new Node();
    // insert
    public static void insert(String word) {   // O(L)  -> L is largest word
        Node curr = root;
        for(int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                // no node exists so, create one
                curr.children[idx] = new Node();   // if a node is present at any idx in children arr that means char is present of that idx 
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];  // point curr to next level
        }
        curr.eow = true;
    }

    public static String findLCP(String word, int len) {
        StringBuilder ans = new StringBuilder();
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx].freq == len) {
                ans.append(word.charAt(i));
                curr = curr.children[idx];  // poin it to next node
            } else {
                return ans.toString();
            }
        }
        return ans.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs[0].length() == 0) return "";
        char ch = strs[0].charAt(0);
        for(String s : strs) {
            if(s.length() == 0) return "";
            if(s.charAt(0) != ch) return "";
        } // if this if don't get executed that means common prefix exist

        root = new Node();
        root.freq = -1;
        for(String s : strs) {
            insert(s);
        }

        return findLCP(strs[0], strs.length);
    }
}
/*
1 ms optimised by time 
Time : including insert method O(L*N)  number of strings * time take to insert one string
       L is the length of longest string.
Space : including insert method O(L*N) 
*/