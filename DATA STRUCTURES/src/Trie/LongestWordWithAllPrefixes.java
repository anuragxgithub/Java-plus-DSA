/*

---------THIS QUESTION IS IN LEETCODE PREMIUM---------

Given an array of strings words, find the longest string in words such that every prefix 
of it is also in words.

For example, let words = ["a", "app", "ap"]. The string "app" has prefixes "ap" and "a", 
all of which are in words.
Return the string described above. If there is more than one string with the same 
length, return the lexicographically smallest one, and if no string exists, return "".

Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"] 
Output: "apple" 
Explanation: Both "apple" and "apply" have all their prefixes in words. But we want
             lexicographically smallest so "apple".

https://www.codingninjas.com/studio/problems/complete-string_2687860?leftPanelTabValue=SUBMISSION  
⭐
        
APPRAOCH:
1. AFTER HEARING PREFIX IN QUESTIONS YOU SHOULD THINK OF TRIE.
2. SO HERE THE LOGIC IS SIMPLE WE WILL FIND LONGEST WORD WHICH HAS SAME PREFIX.
   THAT MEANS WE HAVE TO FIND THE LONGEST WORD WHERE FOR EACH CHAR IN WORD EOW = TRUE.
   BCZ FOR "EACH" CHAR OF WORD (EOW = TRUE) REPRESENTS THAT WE HAVE ALL WORDS IN GIVEN ARRAY
   WHICH IS PREFIX OF THAT PARTICUALR WORD.
   NODE IS NOT NULL AND END OF WORD IS TRUE FOR EACH LETER 

                          Root
                           |
                         __|__
                         |   |
                       T a   b
                        /     \
                     T p       a
                      /         \
                  T  p           n
                    /             \
                 T l               a
                  / \               \
               T e   y T             n
                                      \
                                       a T
    Here the logest word whose all chars has a eow in trie is apple and apply but we want 
    "apple" bcz lexicographically smallest.

*/

package Trie;

public class LongestWordWithAllPrefixes {
    static class Node {
        Node[] children;
        boolean eow = false;

        public Node() {
            children = new Node[26];
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                // create new node
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }  


    static String ans = "";
    public static void longestWord(Node root, StringBuilder temp) {
        if(root == null) return;

        for(int i = 0; i<26; i++) {  // visit all nodes in trie
            if(root.children[i] != null && root.children[i].eow == true) {
                temp.append((char)(i + 'a'));
                if(ans.length() < temp.length()) ans = temp.toString();  // update the ans
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);   // backtrack
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        root = new Node();
        ans = "";
        for(String s : words) {
            insert(s);
        }
        

        longestWord(root, new StringBuilder());
        System.out.println(ans);
        // NOTE WE DON'T NEED TO WORRY ABOUT LEXICOGRAPHICALLY SMALLEST WORD.
        // BCZ TRIE IS IMPLEMENTED IN SUCH A WAY WHERE WE ARE FIRST VISITING THE smallest lexicographically chars firs
        // bcz of loop running from 0 to 26 so first our ans is getting updated with lexicographically smallest word
        // and if other words with same length comes wit won't update the ans bcz it should be greater than than the
        // ans length to get updated
    }
}
