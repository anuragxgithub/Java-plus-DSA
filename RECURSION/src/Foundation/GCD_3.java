package Foundation;

public class GCD_3 {
    public static int gcd(int x, int y) {
        if(y == 0)                                  // bcz we are dividing with y so this one if y become 0 you can't divide further
            return x;   // bcz in last step x becomes y

        return gcd(y, x%y);
    }
    public static void main(String[] args) {
        // Here Euclidean Method (Long Division Method using recursively)
        /*
        Recurrence relation :
        gcd(x,y) = gcd(y,x%y)
        gcd(x,0) = x
         */
        System.out.println(gcd(0, 12));
        // TIME COMPLEXITY: WILL BE IN LOGARITHMIC WHICH IS MUCT BETTER THAN BRUTE FORCE which was linear
    }
}
//
// https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/