/*

Given a string s and a dictionary of strings wordDict, return true if s can be segmented
into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

https://leetcode.com/problems/word-break/description/


APPRAOCH:
-> Since we need to search for string we can create a Trie data structur for this. 
-> Check for all possible combinations of key string.
   Divide it into two parts. Left and right and check whether they are present in trie.
   We will return true if key can be segmented into one or more dictionary word.

*/

package Trie;

import java.util.HashMap;

public class WordBreak {
    static class Node {
        Node[] children = new Node[26];          // each edx represent chars from a to z you can change the size according to your character storing requirements 256 to include all chars in java
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

    public static boolean wordBreak(String key, HashMap<String, Boolean> memo) {
        if(key.length() == 0) return true;
        // bcz in this case whole string is in left part and right part is empty so return T for 
        // right part. Only left part will be checked.
        if(memo.containsKey(key)) return memo.get(key);

        for(int i = 1; i <= key.length(); i++) {  //O(L)
            if(search(key.substring(0, i)) && wordBreak(key.substring(i), memo)) {
                memo.put(key, true);
                return true;
            }
            // for the first part of string search it in string
            // for the second part of string run the wordBrea
        }
        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        String[] words_dict = {"apple", "pen"};
        String key = "applepenapple";

        root = new Node();   // since root is static var so update it for each testcases

        // insert the dict words in trie
        for(int i = 0; i < words_dict.length; i++) {
            insert(words_dict[i]);
        }
        
        HashMap<String, Boolean> memo = new HashMap<>();
        System.out.println(wordBreak(key, memo));

    }
}
