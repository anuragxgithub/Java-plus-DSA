/*

https://www.geeksforgeeks.org/problems/shortest-unique-prefix-for-every-word/1?

Question :
Given an array of words, find all shortest unique prefixes to represent each word in
the given array. Assume that no word is prefix of another ("app" & "apple" can't exists together).
N = 4
arr[] = {"zebra", "dog", "duck", "dove"}
Output: {"z", "dog", "du", "dov"}

APPRAOCH :
1. Since we need to search in the strings and search on one string is related to the 
   search of another string's prefix.
   So we will create a Prefix Tree or Trie.
2. Insert the words given in the list to the tree.
   Here we can observe that if we can somehow know that current shortest prefix do not belong
   to other word's prefix then we can simply return the ans. See Trie of above eg.

                    root
                     |
             ________|________
            /                 |       
           d                  z        
          / \                 |
         o   u                e
        / \   \               |
        v  g   c              b
        |     /               |
        e     k               r
                              |
                              a
    How we can tell that for "dog" shortest unique prefix would be "dog" and for 
    "duck" it is "du".
    Simple, by seeing the trie we can easily tell it. B/z if there will be only one child
    of a branch then we can take only that one char as prefix bcz not word is present with that
    prfix.

3. So we have to think think of something which helps us in determining the frequency
   of childs for any particular node.
   So while creating our Trie data structure we will use one extra variable/marker for each
   node which is of frequency it will tell the freq. of each node.
   Frequency 1 means there will be only one branch/child/level orginating for this node.
   Frequency 2 means there will be 2 branch/child/level orginating from this node.
   Frequency 3 means there is will be 3 branch/child/level originating from this node.

   So if we hit a node which has freq 1 we can take chars till that node in our ans.
   Bcz that will be the shortest unique prefix.
                    root
                     |
             ________|________
            /                 |       
           d 3                z 1     
          / \                 |
       2 o   u 1              e 1
        / \   \               |
     1 v   g 1 c 1            b 1
       |      /               |
     1 e      k 1             r 1
                              |
                              a 1

*/

package Trie;

import java.util.Arrays;

public class ShortesUniquePrefix {
    static class Node {
        Node[] children = new Node[26];         // store value of Node type. (each idx will have all those attributes wich is present in Node class)
        boolean eow = false;       // not needed in this case lets create it conventionally
        int freq;

        public Node() {
            for(int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;        // freq for each node at beginning would be 1
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                // create node for this char
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;    // if already exist means new word has some prefix common to already existing word so new branch will be created later
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Method 1
    public static void findPrefix(Node root, String ans) {
        if(root == null) return;
        if(root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < 26; i++) {  // we will check all childrens for each node 
            if(root.children[i] != null) {
                findPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    // Method 2
    public static String findPrefix2(String word, StringBuilder ans) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx].freq == 1) {
                ans.append(word.charAt(i));
                return ans.toString();
            }
            ans.append(word.charAt(i));
            curr = curr.children[idx];
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        root = new Node();    // static var so update for each testcase
        root.freq = -1;
        for(String s : arr) {
            insert(s);
        }

        findPrefix(root, "");


        // Note in gfg this ans is required in sequence.
        // for eg : if zebra comes first then return the array of string in which
        // shortest unique prefix of zebra comes first and so on..

        // so this is simple what we can do is find the unique prefix of words one by
        // one rather than finding all words at once
        String[] ans = new String[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            ans[i] = findPrefix2(arr[i], new StringBuilder());
        }
        System.out.println(Arrays.toString(ans));
    }
}
// METHOD 2 IS BETTER more intuitive