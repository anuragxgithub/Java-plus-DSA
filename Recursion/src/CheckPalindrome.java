// check if a string i palindrome or not
// 0 1 2 3 4
// j a h a j
public class CheckPalindrome {
    public static boolean check(String s, int start, int end) {
        if(start >= end) return true;
        if(s.charAt(start) != s.charAt(end)) {
            return false;
        }

        return check(s, start+1, end-1);
    }
    public static boolean checkPalindrome(String s) {
        if(s.length() <= 1) return true;

        return check(s, 0, s.length()-1);
    }
    public static void main(String[] args) {
        System.out.println(checkPalindrome("jahzaj"));
    }
}
