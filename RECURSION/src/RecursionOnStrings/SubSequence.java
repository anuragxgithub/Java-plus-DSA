package RecursionOnStrings;
import java.util.ArrayList;
//SEE NOTES ⭐⭐ EasyPeasy to understand recursion tree.
//2^n subSequences (n is no of elements)
public class SubSequence {
    public static void main(String[] args) {
        subSequence("abc", "");  // subsequence using substring

        subSequence2("abcd", "", 0);  // subsequence using idx

        ArrayList<String> ans = subSequence3("abc");
        // subsequence using Recurrence Relation and substring. (RETURNING IN ARRAYLIST)
        // RECURRENCE RELATION: f("abc") = (a + f("bc")) + f("bc")
        System.out.println();
        for(String ss : ans) {
            System.out.print(ss + " ");
        }
    }

    // 1. subsequence using substring
    static void subSequence(String str, String ans) { // Space compl. : n * (n-1)  O(n^2)
        if(str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        // including
        subSequence(str.substring(1), ans+ch);
        // not including
        subSequence(str.substring(1), ans);
    }

    // 2. subsequence using idx
    static void subSequence2(String str, String temp, int idx) {
        if(idx == str.length()) {
            System.out.print(temp + " ");
            return;
        }
        // not including
        subSequence2(str, temp, idx+1);
        // including
        temp = temp+str.charAt(idx);
        subSequence2(str, temp, idx+1);

//        temp.substring(0, temp.length()-1);  // backtrack to remove the last element form the temp after each level of recursive call
    }


    public static ArrayList<String> subSequence3(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if(str.length() == 0) {
            ans.add("");   // bcz subsequence of "" is "" itself 2^0 = 1
            return ans;
        }

        char ch = str.charAt(0);
        ArrayList<String> smallAns = subSequence3(str.substring(1));

        for(String ss : smallAns)  {  // now add all the elements as it is and also add them by appending the first character
            ans.add(ss);
            ans.add(ch + ss);  //
        }
        return ans;
    }

    //see how we can return string ArrayList for this question in subS_returnArraylist
}
//The time complexity of the subSequence function is O(2^n), where n is the length of the input string str.
//This is because for each character in str, we have two choices: either include it in the subsequence or exclude it.
//Therefore, the function will make 2^n recursive calls in the worst case.

//https://www.geeksforgeeks.org/problems/power-set4302/1