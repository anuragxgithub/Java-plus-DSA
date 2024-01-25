
/*
https://leetcode.com/problems/word-ladder-ii/
NOTE: THE BELOW SOLUTION WILL FAIL ON LEETCODE BECAUSE THERE THEY ARE ASKING FOR OPTIMISED APPROACH.
YOU CAN CHECK THAT OUT ON YT.


BUT THIS SOLUTION IS ACCEPTABLE IN INTERVIEW (AS LIKE ON GFG)
https://www.geeksforgeeks.org/problems/word-ladder-ii/1
*/

package Graphs.Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < wordList.length; i++) {
            set.add(wordList[i]);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(startWord);
        int level = 0;
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        q.add(list);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        while(!q.isEmpty()) {
            ArrayList<String> curr = q.remove();
            //erase all the words that has been used in the previous levels of transformation
            if(curr.size() > level) {
                level++;
                for(String s : usedOnLevel) {
                    set.remove(s);
                }
            }
            String word = curr.get(curr.size()-1);
            if(word.equals(targetWord)) {
                // the first sequence where we reached end
                if(ans.size() == 0) ans.add(curr);
                else if(ans.get(0).size() == curr.size()) ans.add(curr);
            }
            
            for(int i=0; i<word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord)) {
                        curr.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(curr); 
                        q.add(temp);
                        // mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        curr.remove(curr.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}
