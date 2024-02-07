package Foundation;

// https://r-knott.surrey.ac.uk/Fibonacci/fibtable.html FIBONACCI series
public class FiboFormula {
    public static void main(String[] args) {
        for (long i = 0; i < 60; i++) {
            System.out.println(fibFormula(i));
        }
//        System.out.println(fibFormula(50));
    }
    static long fibFormula(long n) {
        //Don't typecast, use Math.round instead to get accurate answer :)
        // b/z typecast gives 0 for n = 1 and other faults like this (typecasting don't round off the value gives 2 for 2.9f)
        return Math.round((Math.pow(((1 + Math.sqrt(5))/2), n) / Math.sqrt(5)));
    }
}
