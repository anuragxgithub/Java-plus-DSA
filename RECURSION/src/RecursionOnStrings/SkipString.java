package RecursionOnStrings;

public class SkipString {
    public static void main(String[] args) {
        System.out.println(skipApple("anuapplerag"));
        System.out.println(skipAppNotApple("appleappAnuragapp"));
    }

    static String skipApple(String str) {
        if(str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if(str.startsWith("apple")) {
            return skipApple(str.substring(5));   //index starts from 0
        } else {
            return ch + skipApple(str.substring(1));
        }
    }

    //skip the undesired string
    static String skipAppNotApple(String str) {
        if(str.isEmpty()) {
            return "";
        }
        if(str.startsWith("app") && !str.startsWith("apple")) {
            return skipAppNotApple(str.substring(3));
        } else {
            return str.charAt(0) + skipAppNotApple(str.substring(1));
        }
    }
}
