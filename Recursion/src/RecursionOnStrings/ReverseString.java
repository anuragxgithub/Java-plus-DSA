package RecursionOnStrings;

public class ReverseString {

    static String reverse(String s, int idx) {
        if(idx == s.length()) return "";

        String smallAns = reverse(s, idx+1);

        char curr = s.charAt(idx);
        return smallAns+curr;
    }

    static String reverse2(String s) {
        if(s.length() == 0) return "";

        String smallAns = reverse2(s.substring(1));
        return smallAns + s.charAt(0);
    }
    public static void main(String[] args) {
        System.out.println(reverse("zyxwvutsrqp", 0));

        // Using the substring method without idx variable
        System.out.println(reverse2("zyxwvutsrqp"));
    }
}
