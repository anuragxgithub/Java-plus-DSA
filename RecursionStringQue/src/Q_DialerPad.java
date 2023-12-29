//LEETCODE 17
import java.util.ArrayList;
public class Q_DialerPad {
    public static void main(String[] args) {
        System.out.println(letterCombinationsList("", "79"));
        System.out.println(countCombinations("", "79"));
    }
    static ArrayList<String> letterCombinationsList(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        int i=(digit-2)*3;
        if(digit > 7) {  //to maintain the validity of
            i+=1;
        }
        int len = i+3;
        if(digit == 7 || digit == 9) {
            len+=1;
        }

        ArrayList<String> ans = new ArrayList<>();

        for(; i<len; i++) {
            char ch = (char)('a' + i);
            ans.addAll(letterCombinationsList(p+ch, up.substring(1)));
        }

        return ans;
    }
    static int countCombinations(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0';
        int i = (digit-2)*3;
        if(i > 7) {
            i += 1;
        }
        int len = i+3;
        if(digit == 7 || digit == 9) {
            len += 1;
        }

        for (;i < len; i++) {
            char ch = (char)('a'+i);
            count = count + countCombinations(p+ch, up.substring(1));
        }
        return count;
    }
}
