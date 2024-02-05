package RecursionOnStrings;

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
    public static boolean checkPalindromeUtility(String s) {
        if(s.length() <= 1) return true;

        return check(s, 0, s.length()-1);
    }


    static boolean isPalindrome(String s, int start, int end) {
        if(start >= end) return true;

        return s.charAt(start) == s.charAt(end) && isPalindrome(s, start+1, --end);
        // if any of the above becomes false ans would be false
    }

    public static void main(String[] args) {
        System.out.println(checkPalindromeUtility("jahzaj"));

        // Second way
        System.out.println((isPalindrome("malylam", 0, 6)));

    }
}

// Time : O(n/2) or o(n)
// Space : O(n/2) or o(n)