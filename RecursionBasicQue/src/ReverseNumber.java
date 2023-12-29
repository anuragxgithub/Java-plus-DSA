public class ReverseNumber {
    public static void main(String[] args) {
        int n = 123;
        System.out.println(method1(n));
        System.out.println(method2(n));
    }

    //THIS IS NOT PURE RECURSION IT IS A CHEATING METHOD
    static int rev = 0;   //NOTE: This will be covered in scoping.

    static int method1(int n) {
        if (n == 0) {
            return 0;
        }
        rev = (rev * 10) + n % 10;
        method1(n / 10);
        return rev;
    }
//   <<< --------------------------------------------------------------------------------  >>    //
    //THIS IS GOOD METHOD USING RECURSION PROPERLY
    static int method2(int n) {
        //sometimes you might need some additional variables in the argument
        //in that case make another function(know as helper function) to make code look neat
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits-1);
    }
    private static int helper(int n, int digits) {
        if(n%10 == n) {  //return the number itself if it is of 1 digit
            return n;
        }
        return (n%10)*(int)(Math.pow(10,digits)) + helper(n/10, digits-1);
    }
}
