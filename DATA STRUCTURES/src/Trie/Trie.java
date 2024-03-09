/*

TRIE DATA STRUCTURE:
A Trie, also known as a Prefix Tree, is a tree-based data structure used for efficient
information retrieval operations like search, insert, and delete operations on a collection
of strings. It is particularly useful for storing and retrieving strings, as it allows for
efficient prefix-based operations.

IMPLEMENTATION:
The implementation consists of two main classes:

Trie: This class contains the root node of the Trie and static methods for insertion and 
      search operations.
Node: This class represents a node in the Trie. Each node has:
    An array of child nodes (children) of size 26, representing the possible characters (a-z).
    You can adjust the size based on your character set requirements.
    A boolean flag (eow) to indicate if the current node represents the end of a word.

INSERTION:
The insert(String word) method inserts a word into the Trie. Here's how it works:

1. Start at the root node.
2. For each character in the word: a. Calculate the index (idx) of the character based on
   its position in the alphabet (e.g., 'a' is 0, 'b' is 1, etc.). b. If the child node at
   the calculated index is null, create a new node and assign it to that index. c. 
   Move to the child node at the calculated index.
3. After traversing the entire word, mark the current node as the end of a word by setting
   its eow flag to true.
The time complexity of insertion is O(L), where L is the length of the word being inserted.

SEARCH:
The search(String key) method searches for a word in the Trie. Here's how it works:

1. Start at the root node.
2. For each character in the key: a. Calculate the index (idx) of the character based on 
   its position in the alphabet. b. If the child node at the calculated index is null, it
   means the key is not present in the Trie, so return false. c. Move to the child node
   at the calculated index.
3. After traversing the entire key, check if the current node is marked as the end of a 
   word (eow is true). If so, return true, indicating that the key is present in the Trie.
   Otherwise, return false.
The time complexity of search is also O(L), where L is the length of the key being searched.


TIME AND SPACE COMPLEXITY:
Time Complexity:
Insertion: O(L), where L is the length of the word being inserted.
Search: O(L), where L is the length of the key being searched.
Space Complexity:
The Trie data structure requires O(N * L) space in the worst case, where N is the number of words, and L is the maximum length of a word. However, the space complexity can be reduced by using a more compact representation of the child nodes (e.g., using a hash table instead of an array).

APPLICATIONS:
The Trie data structure is widely used in various applications, such as:
-> Autocompletion/Suggestion systems
-> Spell checkers
-> IP routing tables
-> Genome sequence analysis
-> Prefix-based searches (e.g., search engines)

*/
package Trie;

public class Trie {
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

    // search
    public static boolean search(String key) {  // O(L)  -> L is largest word
        Node curr = root;
        for(int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any", "thee"};
        for(int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("thee"));
        System.out.println(search("thor"));
    }
}
