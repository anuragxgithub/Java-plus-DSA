//Return true when prime number and false when non-prime number
//NOTE: THIS IS OPTIMISED SOLUTION WHEN WE WANT TO CHECK WHETHER A NUMBER IS PRIME OR NOT
//BUT IF WE WANT TO PRINT PRIME NUMBERS IN RANGE THEN USE SIEVE OF Eratosthenes APPROACH ⭐
//B/Z IF U PRINT USING THIS ALGO IT WILL TAKE T.C. : O(n*sqrt(n))  see PrimeOptimised file
public class Prime {
    public static void main(String[] args) {
//        int n = 1;
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " " + primeOrNot(i));
        }

    }
    static boolean primeOrNot(int n) {
        if(n<=1) {
            return false;
        }
        int x = 2;
        while(x*x <= n) {
            if(n%x == 0) {
                return false;
            }
            x++;
        }
        return true;
    }
}
