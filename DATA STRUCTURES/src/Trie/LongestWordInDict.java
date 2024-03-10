/*
https://leetcode.com/problems/longest-word-in-dictionary/description/
Easy peasy 
did it in first attempt.
SAME AS LONGESTWORDWITHALLPREFIXEX.JAVA ⭐

Only thing you should know is to perform dfs/or visiting all nodes in Trie.

Here we are visiting nodes which is lexicographically smallest so our answer would come
in lexicographically sorted manner. explaned in it how? LONGESTWORDWITHALLPREFIXEX.JAVA


APPROACH:
1. We need to find all those words whose each char can be built from the string present in
   the words array.
2. So for these words every char (node) has a eow = true
   return the longest word whose each node has a eow = true.
*/

package Trie;

public class LongestWordInDict {
    static class Node {
        Node[] children;
        boolean eow = false;

        public Node() {
            children = new Node[26];
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
    static String ans = "";
    public static void longestWord(Node root, StringBuilder temp) { //dfs
        if(root == null) return;

        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null && root.children[i].eow == true) {
                temp.append((char)(i+'a'));
                if(ans.length() < temp.length()) ans = temp.toString();
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public String longestWord(String[] words) {
        root = new Node();
        ans = "";
        for(String s : words) insert(s);

        longestWord(root, new StringBuilder());
        return ans.toString();
    }
}
