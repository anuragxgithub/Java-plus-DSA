/*

https://leetcode.com/problems/group-anagrams/description/

Easy Peasy

APPROACH: (JUST A LITTLE TWEAK IN TRADITIONAL TRIE DATA STRUCTURE)
1. WE WILL USE ONE MORE DATA MEMBER FOR EACH NODE AND THAT WOULD BE A LIST OF STRING.
   Why becuase when we sort the words present in dictionary and then add them to the
   trie. So all the anagrams will become same word so all nodes for them would be same
2. At the last node where eow = true for all common anagrams we will have a list at that
   node which will store words which ends there. (This whole thing is done in insert() method)

3. Now since we have list attached to each node's end.
   Create a method which run dfs on trie visit all nodes/words and when you hit the eow
   just add the list associated to it in ans. Done.
*/

package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagram {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false; 
        List<String> data;          // here we will add all the strings which are anagrams

        public Node() {             // constructor
            for(int i = 0; i < 26; i++) {
                children[i] = null;
                data = new ArrayList<>();
            }
        }
    }
    public static Node root = new Node();

    static List<List<String>> ans;
    // insert
    public static void insert(String word) {   // O(L)  -> L is largest word
        char[] chars = word.toCharArray();
        Arrays.sort(chars);      // sort the char array and then add it to the Trie
        Node curr = root;
        for(char ch : chars) {
            int idx = ch - 'a';
            if(curr.children[idx] == null) {
                // no node exists so, create one
                curr.children[idx] = new Node();   // if a node is present at any idx in children arr that means char is present of that idx 
            }
            curr = curr.children[idx];  // point curr to next level
        }
        curr.eow = true;
        curr.data.add(word);  // simple after sorting all anagrams become same so they end
        // on the same node and for that node all all actual words of anagrams are stored.
    }

    public static void groupAnagram(Node root) {
        if(root == null) return;  // NOT NEEDED BY THE WAY
        if(root.eow == true) {
            ans.add(root.data);
        }

        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                groupAnagram(root.children[i]);
            }
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        ans = new ArrayList<>();
        root = new Node();

        for(String s : strs) insert(s);

        groupAnagram(root);
        System.out.println(ans);
    }
}
