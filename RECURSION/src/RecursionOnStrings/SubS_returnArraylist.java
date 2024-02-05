package RecursionOnStrings;//here we will see how can we return ArrayList<String> of list of subsequence(subsets)
//follow-up question of subSequence.java

import java.util.ArrayList;

public class SubS_returnArraylist {
    public static void main(String[] args) {
        System.out.println(subSequence("abc", "", new ArrayList<>()));
        System.out.println(subSequence1("abc", ""));
    }

    //METHOD 1: EASY ONE B/Z HERE TAKING ARRAYLIST IN ARGUMENT NOT INSIDE THE FN BODY.
    static ArrayList<String> subSequence(String str, String ans, ArrayList<String> list) {
        if(str.isEmpty()) {
            list.add(ans);
            return list;
        }
        char ch = str.charAt(0);
        subSequence(str.substring(1),ans+ch, list);
        subSequence(str.substring(1),ans, list);
        return list;
    }

    //METHOD 2: CREATING ARRAY LIST INSIDE THE FN OF BODY (THIS APPROACH IS ALREADY COVERED see RecursionArrayQue project)
    static ArrayList<String> subSequence1(String str, String ans) {
        ArrayList<String> list = new ArrayList<>();
        if(str.isEmpty()) {
            list.add(ans);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = subSequence1(str.substring(1), ans+ch);
        ArrayList<String> right = subSequence1(str.substring(1), ans);
        left.addAll(right);
        return left;
    }
}
