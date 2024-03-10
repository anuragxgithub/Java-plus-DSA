// Que.) This time we don't need to find XOR from 0 to n instead we are given a range
// here (a to b) to find the XOR so if a = 3 and b = 7 calculate
// 3^4^5^6^7
public class XOR_aTob {
    public static void main(String[] args) {
        int a = 3, b = 6;
        int ans = xor(b) ^ xor(a-1); //See Notes to Understand
        System.out.println(ans);   // T COMPLEXITY: O(1)

        //Just to check ans. Will give TLE for large Input T COMPLEXITY: O(n)
        int ans2 = 0; //Xor with o give same answer
        for (int i = a; i <= b; i++) {
            ans2 = ans2^i;
        }
        System.out.println(ans2);
    }

    static int xor(int n) {
        if(n%4==0) {
            return n;
        }

        if(n%4==1) {
            return 1;
        }

        if(n%4==2) {
            return n+1;
        }

        return 0;
    }

}
