// https://leetcode.com/problems/isomorphic-strings/description/
package Hashing;

import java.util.HashSet;
import java.util.HashMap;

public class Q6 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo","bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    private static boolean isIsomorphic(String s, String t) {
        // Isomorphic String : if a character is mapped to any other char. then it must be mapped with the same char in future too. Eg: "egg" and "add" here g is mapped with d throughout the string.
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                if(map.get(ch) != t.charAt(i)) {
                    return false;
                }
            } else {
                if(set.contains(t.charAt(i))) {
                    return false;
                }
                map.put(ch, t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }
}

