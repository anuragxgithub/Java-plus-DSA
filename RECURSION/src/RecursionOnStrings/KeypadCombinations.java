package RecursionOnStrings;

import java.util.ArrayList;
import java.util.List;

public class KeypadCombinations {
    public static void combinations(String num, String[] mapping, String curr, List<String> ans) {
        if(num.length() == 0) {
            ans.add(curr);
            return;
        }
        int currNum = num.charAt(0) - '0';
        String currChoices = mapping[currNum];
        for(char ch : currChoices.toCharArray()) { // append the selected char
            combinations(num.substring(1), mapping, curr + ch, ans);
        }
    }

    public static void main(String[] args) {
        String num = "23";
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        combinations(num, mapping, "", ans);
        System.out.println(ans);
    }
}
// Only combine the first char with all available char easiest.
