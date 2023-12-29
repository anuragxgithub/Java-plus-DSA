public class Recursion_SumOFn {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }
    static int sum(int n) {
        if (n==0) {
            return 0;
        }
        return n + sum(n-1);
    }
}
//To understand things see explanation in Recursion_factorial or Recursion_3