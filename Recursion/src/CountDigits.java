public class CountDigits {
    public static int  countDigits(int n) {
        if(n >= 0 && n <= 9) return 1;

        // Self work -> adding 1
        // assigned recursive work -> countDigits(n/10)
        return countDigits(n/10)+ 1;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(0));
    }
}
