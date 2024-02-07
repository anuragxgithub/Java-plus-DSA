package Foundation;

public class GCD_Intro {
    public static int gcd(int x, int y) {
        int n = Math.min(x, y);
        while(n>0) {
            if(x % n == 0 && y % n == 0) return n;
            n--;
        }
        return Math.max(x, y);   // bcz of any non zero natural num with 0 will be that number.
    }

    public static void main(String[] args) {
        // brute force
        /*
        12 -> 1, 2, 3, 4, 6, 12
        16 -> 1, 2, 4, 8, 16
        Here highest common divisor is : 4. Therefore, GCD will be 4.
        NOTE: GCD(x,0)   will always be x. (x>0)
         */
        System.out.println(gcd(5, 0));
        // TIME COMPLEXITY : O(min(x,y))
        // But we can do much better than this.
    }
}
