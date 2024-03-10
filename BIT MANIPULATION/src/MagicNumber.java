//Asked in Amazon
//Magic number is (set bits jitne hai, 5 to the power unke position(from left starting with 1) plus kr dena hai);
//eg 6>>(110 in binary) the magic number for 6 will be (5^1 * 0 + 5^2 * 1 + 5^3 * 2) = 25+125 = 150
// for 2>>(10 in binary) the magic number for 2 will be (5^1 * 0 + 5^2 * 1) = 25
public class MagicNumber {
    public static void main(String[] args) {
        int n = 6;
        int ans = 0;
        int base = 5;
        while (n > 0) {
            int lastDigit = n & 1;
            n = n>>1;
            ans = ans + (lastDigit * base);
            base = base * 5;
        }
        System.out.println(ans);
    }
}
