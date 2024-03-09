package Trie;

public class ImplementTrie {
    class Trie {
        static class Node {
            Node[] children = new Node[26];
            boolean eow = false;      // end of word
    
            public Node() {             // constructor
                for(int i = 0; i < 26; i++) {
                    children[i] = null;
                }
            }
        }
        public Node root;
        
        public Trie() {
            root = new Node();
        }
        
        public void insert(String word) {
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
        
        public boolean search(String word) {
            Node curr = root;
            for(int level = 0; level < word.length(); level++) {
                int idx = word.charAt(level) - 'a';
                if(curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }
            return curr.eow == true;
        }
        
        public boolean startsWith(String prefix) {
            Node curr = root;
            for(int level = 0; level < prefix.length(); level++) {
                int idx = prefix.charAt(level) - 'a';
                if(curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }
            return true;
        }
    }
}
