public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 11211;
        System.out.println(isPalindrome(n));
    }
    static boolean isPalindrome(int n) {
        return reverse(n) == n;
    }
    static int reverse(int n) {
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits-1);
    }
    static int helper(int n, int digits) {
        if(n%10 == n) {   //return the number itself if it is of 1 digit
            return n;
        }
        return (n%10)*(int)(Math.pow(10, digits)) + helper(n/10,digits-1);
    }
}
