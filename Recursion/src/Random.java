public class Random {
    public static void main(String[] args) {
        System.out.println(fact(5));
    }
    static int fact(int n) {
        if(n==1) {
            return n;
        }
        int ans = fact(n-1);
        ans = ans*n;
        return ans;
    }
}
