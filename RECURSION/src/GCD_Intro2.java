public class GCD_Intro2 {
    public static int iGCD(int x, int y) {
        if(x == 0 || y == 0) return Math.max(x, y);
        while(x % y != 0) {    // note you can also do this (y % x) same thing only 1 division will be more ans dry run it to understand
            // in this case x is dividend and y is divisor
            int rem = x % y;
            x = y;              // divisor becomes dividend
            y = rem;            // remainder becomes divisor
        }
        return y;
    }
    public static void main(String[] args) {
        // LONG DIVISION METHOD
        /*
        Divisor becomes dividend and remainder becomes divisor until dividend % divisor = 0
            ____ 1
        12 ) 16
             12
                ____ 3
             4 ) 12
                 12
                  0
           Therefore 3 will be gcd.
         */

        System.out.println(iGCD(12, 0));
    }
}
