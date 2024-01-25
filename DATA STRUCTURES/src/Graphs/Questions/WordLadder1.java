
/*
https://leetcode.com/problems/word-ladder/
The solution of this would be like kind of a brute force solution. Easy

Here what we will do here:
1. The idea is start with the beginWord and replace one char of the word one by one from
   'a' to 'z' and do it for each char in the word.(as only one letter can be transformed) 
   even if we find the word while changing the chars we'll not stop until the each char of
   word is checked bcz it would be nice if we can get a word which is more close to endWord
   since words are sorted.
   We will keep doing it until we reach the end word.
2. To keep changing the chars and checking if the changed word present in set.
   We convert the current word into charArray and now we can replace the chars easily
   and to get it as string we will create new string same as charArray using new String()
   constructor.
   Since here we are adding all the neighbors which can be transformed to word which exist in
   the wordlist in the queue and moving level wise so BFS would be used.
2. Put wordlist in set becuase we will keep checking the replaced word exist in wordlist or
   not as soon as a repalced word is present in the set remove it bcz we are not maintaining
   any visited array.
*/

package Graphs.Questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {
    static class Pair {
        String word;
        int steps;
        
        public Pair(String w, int s) {
            this.word = w;
            this.steps = s;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();  // Store word found and steps taken to reach it
        q.add(new Pair(beginWord, 1));   // initially add the startWord in q and its step
        set.remove(beginWord);  // removes the start word if present as it is included
        
        while(!q.isEmpty()) {
            Pair curr = q.remove();
            String word = curr.word;
            int steps = curr.steps;
            
            if(endWord.equals(word)) {  // here we find our ans
                return steps;
            }
            
            for(int i = 0; i < word.length(); i++) {
                for(char j = 'a'; j <= 'z'; j++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = j;
                    String replacedWord = new String(replacedCharArray);
                    
                    if(set.contains(replacedWord)) { // if set contains the replaced word
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
            
        }
        return 0;
    }
}

/*
Time : N * word.length * 26   (assuming that set operation is taking O(1)) 
                               otherwise:  N * word.length * 26 *logn
Space : O(N)    , N is len of worList
*/