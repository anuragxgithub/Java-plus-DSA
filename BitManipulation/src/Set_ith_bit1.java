public class Set_ith_bit1 {
    public static void main(String[] args) {
        int n = 20; // (10100)>> set the 4th digit to 1 >>Ans should be 28
        System.out.println(result(n));
    }

    static int result(int n) {
        int mask = 1<<3; //(ith bit position - 1)
        int result = n|mask;
        return result;
    }
}
