/*
Important !! asked in google and microsoft.

https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1

DRY RUN AND EXPLANATION IS GIVEN ⭐⭐
You will learn new concepts.

[ TOTAL SUBSTRINGS = ALL PRIFIX OF ALL SUFFIX = ALL SUFFIX OF ALL PREFIX ]

STEPS:
1. FIND ALL SUFFIX OF STRING
2. CREATE A TRIE AND INSERT ALL SUFFIXES INTO TRIE.
3. COUNT THE NUMBER OF NODES IN TRIE = TOTAT UNIQUE PREFIXES = UNIQUE SUBSTRINGS
 
*/

package Trie;

public class CountOfDistincSubstr {
    static class Node {
        Node[] children = new Node[26];          // each edx represent chars from a to z you can change the size according to your character storing requirements 256 to include all chars in java
        // store value of Node type.
        boolean eow = false;      // end of word

        public Node() {             // constructor
            for(int i = 0; i < 26; i++) {
                children[i] = null;
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
            }
            curr = curr.children[idx];  // point curr to next level
        }
        curr.eow = true;
    }
    public static int count(Node root) {
        if(root == null) return 0;
        int cnt = 0;
        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                cnt += count(root.children[i]);
            }
        }
        return cnt+1;
    }
    
   public static int countDistinctSubstring(String st)
   {
       // find all suffixes given string
       root = new Node();           // bcz static variable (global)
       for(int i = 0; i <= st.length(); i++) {
           insert(st.substring(i));
       }
       return count(root);
   }
}
