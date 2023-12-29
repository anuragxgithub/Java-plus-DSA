public class factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(n));
    }
    static int fact(int n) {
        if(n<=1) {   //factorial of 0 is 1.
            return 1;
        }
        return fact(n-1) * n;
    }
}
