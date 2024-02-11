/*
Intro about the permutation of string which contains duplicate characters:

Here the input string can contain duplicate elements.
So how will the permutation got affected. Let's see

{a,a,b}
by the formula we can say that there should be n! unique permutes but this is not true, there will be
n!/2! unique permutations  bcz 'a' is repeating two times. So 3!/2! = 3. These permutations are:
[aab] , [aba],  [baa]

Similarly for {a,a,b,b}. There will be : 4!/2!*2! = 24/4 = 6 unique permutations.
These are : [aabb], [abab], [abba], [baba], [bbaa], [baab]

THIS IS ALSO BE DONE WITH THE SAME APPROACH AS WE DID FOR FINDING PERMUTATIONS WITH DISTINCT
ELEMENTS WITH A LITTLE TWEAK.
To know about this tweak you can refer to permutationsWithDuplicated in the array case. ⭐

Just simple thing you have to make sure that you don't choose the same char for the same idx
more than once at each level of recursion simple.
 */

package RecursionOnStrings;

import java.util.ArrayList;
import java.util.HashSet;

public class PermutesWithDuplicates {

    // METHOD 1
    public static void permuteDup1(String str, String temp, boolean[] visited, ArrayList<String> ans) {
        if(temp.length() == str.length()) {
            ans.add(temp);
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            if(!visited[i] && !set.contains(str.charAt(i))) {
                visited[i] = true;
                set.add(str.charAt(i));
                permuteDup1(str, temp+str.charAt(i), visited, ans);
                visited[i] = false;  // backtrack
                // set will get backtracked after each level bcz we are creating a new set for each lvl
            }
        }
    }

    // METHOD 2         (again track the char to prevent adding same char at same level at same idx)
    public static void permuteDup2(StringBuilder str, int idx, ArrayList<String> ans) {
        if(idx == str.length()) {
            ans.add(str.toString());
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for(int i = idx; i < str.length(); i++) {
            if(!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                char temp = str.charAt(idx);
                str.setCharAt(idx, str.charAt(i));
                str.setCharAt(i, temp);
                permuteDup2(str, idx+1, ans);
                char tempo = str.charAt(idx);
                str.setCharAt(idx, str.charAt(i));
                str.setCharAt(i, tempo);
            }
        }
    }


    public static void main(String[] args) {
        // Method 1   (using temp and visited)
        String str = "aabb";
        ArrayList<String> ans = new ArrayList<>();
        permuteDup1(str, "", new boolean[str.length()], ans);
        System.out.println(ans);

        // Method 2 (swapping thing without using temp and visited)
        StringBuilder s = new StringBuilder(str);
        ArrayList<String> answer = new ArrayList<>();
        permuteDup2(s, 0, answer);
        System.out.println(answer);
    }

}

// https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1