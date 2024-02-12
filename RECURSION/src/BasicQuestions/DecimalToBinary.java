package BasicQuestions;

public class DecimalToBinary {
    public static int toBinary(int dividend) {
        int ans = 0;
        if(dividend < 2) {
            return dividend;
        }

        int digit = toBinary(dividend/2);

        int rem = dividend%2;

        digit = (digit * 10) + rem;
        return digit;
    }
    public static void main(String[] args) {
        System.out.println(toBinary(10));
    }
}
// just coded the logic which we use on paper