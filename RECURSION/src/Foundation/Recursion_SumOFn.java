package Foundation;

public class Recursion_SumOFn {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }
    static int sum(int n) {
        if (n==1) {
            return 1;
        }
        return n + sum(n-1);
    }
}
//To understand things see explanation in Recursion_factorial or Foundation.Recursion_3