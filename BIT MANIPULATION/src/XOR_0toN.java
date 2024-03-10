//QUE.) if n = 5 then calculate : 0^1^2^3^4^5
public class XOR_0toN {
    public static void main(String[] args) {
//        NAIVE APPROACH YOU ALREADY KNOW HERE NAIVE APPROACH (USING LOOP) WILL TAKE
//        COMPLEXITY TIME OF O(N) which is not as efficient as this approach give TLE for large input

//        int ans2 = 0; //Xor with 0 give same number so don't worry.
//        for (int i = a; i <= b; i++) {
//            ans2 = ans2^i;
//        }
//        System.out.println(ans2);

//        SEE NOTES TO UNDERSTAND PATTERN & THIS APPROACH O(1) WOW!
        int n = 6;
        System.out.println(ans(n));
    }
    static int ans(int n) {
        if(n%4==0) {
            return n;
        } else if(n%4==1) {
            return 1;
        } else if(n%4==2) {
            return n+1;
        }
        return 0;   //When n%4==3
    }
}
