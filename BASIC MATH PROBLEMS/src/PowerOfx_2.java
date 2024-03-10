public class PowerOfx_2 {
    public static void main(String[] args) {
        System.out.println(pow(2.0, 10));
    }

    private static double pow(double x, int n) {
        if (n == 0) {   //bcz any value to power 0 is 1
            return 1;
        } else if (n < 0) {  //handling the -ve n.
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }
        return result;
    }
}
//This is binary exponentiation method (iterative)
//T.C. O(n)