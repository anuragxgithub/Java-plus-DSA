package Foundation;
/*
24513 -> 2451 3
2451 -> 245 1
245 -> 24 5
24 -> 2 4
2 -> 0 2
*/

public class SumOfDigits {
//    public static int  sumDigits(int n) {
//        if(n == 0) {
//            return 0;
//        }
//
//        int lastDigit = n%10;
//        int remaining = n / 10;
//        return sumDigits(remaining) + lastDigit;
//    }

    // The above base can be optimised lil bit like this
    public static int sumDigits(int n) {
        if(n >= 0 && n < 10) return n;   // bcz sum of single digit number is number itself

        return sumDigits(n/10) + n%10;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(513));
    }
}
