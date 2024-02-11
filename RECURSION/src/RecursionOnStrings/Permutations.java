/*
RecursionOnStrings.Permutations of given sequence.
p -> processed __and__ up -> unprocessed
See Notes⭐⭐
---------------------- Intro about Permutations -------------------------------
In permutations, all the characters of the original string are present,
but they can be arranged in any order. Each permutation contains all the characters of the
original string exactly once.
In general, for a string of length n, there are n! permutations, where n! denotes the factorial of n.

In permutations, we basically insert characters at different positions. ⭐
Take one char first and find out its possible positions.
Now take another char and find out the possible positions it can be present at (considering the first char) and so on.
 */

/*
COME HERE AFTER STUDYING PERMUTATIONS ON ARRAYS. ALL THE CONCEPTS ARE EXPLAINED THERE IN DETAIL. EASY.
1. METHOD 1 : THIS IS NEW METHOD YOU CAN SEE THE NOTES FOR ITS EXPLANATION.

2. METHOD 2 : WE ALREADY DID IT IN PERMUTATIONS ON ARRAYS   (WITH THE USE OF TEMP AND VISITED ARRAY)
3. METHOD 3 : WE ALREADY DID IT IN PERMUTATIONS ON ARRAYS   (WITHOUT TEMP AND VISITED WE CHANGE THE INPUT ARRAY/LIST & FIND OUT ANS)
FOR EXPLANATION OF  METHOD 2 AND 3 YOU SEE PERMUTATIONS ON ARRAY ⭐
*/
package RecursionOnStrings;

import java.util.ArrayList;

public class Permutations {
    //METHOD 1
    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);             // for this we will find different possible positions

        //<----substring shit---->:
        //beginIndex – the beginning index, inclusive.
        //endIndex – the ending index, exclusive.
        //NOTE:  When the starting index and ending index are the same, the substring() method returns an empty string.
        for(int i = 0; i <= p.length(); i++) {  // finding the positions to insert the current char in processed string. Why <= ? bcz that many positions are possible for char to be inserted
            String f = p.substring(0,i);            // slicing processed string into first and second string so that we can put them before and after position of the char to be added
            String s = p.substring(i, p.length());
            permutations(f+ch+s, up.substring(1));
        }
    }

    // METHOD 2
    public static void permute2(String str, String temp, boolean[] visited, ArrayList<String> ans) {
        if(temp.length() == str.length()) {
            ans.add(temp);
            return;
        }

        // at every level we'll iterate from 0 to n but only for non visited options
        for(int i = 0; i < str.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                // temp = temp+str.charAt(i)     you can't do this here bcz recursion logic (for other value of i temp will remain same if you do this here)
                permute2(str, temp+str.charAt(i), visited, ans);
                visited[i] = false;                 // backtrack after every call
            }
        }
    }

    // METHOD 3  (modifying the input string and deriving ans from it rather than using extra var like temp)
    public static void permute3(StringBuilder str, int idx, ArrayList<String> ans) {
        if(idx == str.length()) {
            ans.add(str.toString());
            return;
        }

        // here indices before idx are got their possible combinations no need to worry about them
        for(int i = idx; i < str.length(); i++) {
            char temp = str.charAt(idx);    // swap the current idx's value with all possible values
            str.setCharAt(idx, str.charAt(i));
            str.setCharAt(i, temp);
            permute3(str, idx+1, ans);
            char tempo = str.charAt(idx);
            str.setCharAt(idx, str.charAt(i));
            str.setCharAt(i, tempo);
            // string builder is not immutable, so we need to backtrack it
        }
    }


    public static void main(String[] args) {
        // Method 1
        permutations("" , "abc");

        // Method 2
        String str = "abc";
        ArrayList<String> ans = new ArrayList<>();
        permute2(str, "", new boolean[str.length()], ans);
        System.out.println(ans);

        // Method 3    (swapping thing)
        ArrayList<String> answer = new ArrayList<>();
        // since we can't swap chars in string, so we will use string builder
        StringBuilder s = new StringBuilder(str);
        permute3(s, 0, answer);
        System.out.println(answer);
    }
}
//TRY TO USE METHOD 2 AND 3 bcz in arrays same technique is used. :)
// swapping method is better, but you can use any from both.
