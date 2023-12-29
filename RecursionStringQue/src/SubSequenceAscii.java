import java.util.ArrayList;

public class SubSequenceAscii {
    public static void main(String[] args) {
        subsequenceAscii("abc", "");
        System.out.println(subsequenceAsciiRet("abc", "", new ArrayList<>()));
        System.out.println(subsequenceAsciiRet2("abc", ""));
    }

    //METHOD 1: PRINTING THE ANSWER
    static void subsequenceAscii(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        subsequenceAscii(str.substring(1), ans + ch);
        subsequenceAscii(str.substring(1), ans);
        subsequenceAscii(str.substring(1), ans + (ch + 0));
    }

    //METHOD 2: RETURN ARRAYLIST BY TAKING IT AS AN ARGUMENT
    static ArrayList<String> subsequenceAsciiRet(String str, String ans, ArrayList<String> list) {
        if (str.isEmpty()) {
            list.add(ans);
            return list;
        }
        char ch = str.charAt(0);
        subsequenceAsciiRet(str.substring(1), ans + ch, list);
        subsequenceAsciiRet(str.substring(1), ans, list);
        subsequenceAsciiRet(str.substring(1), ans + (ch + 0), list);

        return list;
    }

    //METHOD 3: RETURN ARRAYLIST BY CREATING IT INSIDE THE FUNCTION/METHOD BODY
    static ArrayList<String> subsequenceAsciiRet2(String str, String ans) {
        ArrayList<String> list = new ArrayList<>();
        if (str.isEmpty()) {
            list.add(ans);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = subsequenceAsciiRet2(str.substring(1), ans + ch);
        ArrayList<String> right = subsequenceAsciiRet2(str.substring(1), ans);
        ArrayList<String> ascii = subsequenceAsciiRet2(str.substring(1), ans + (ch + 0));

        left.addAll(right);
        left.addAll(ascii);
        return left;
    }
}
