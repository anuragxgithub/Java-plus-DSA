public class Set_ith_bit0 {
    public static void main(String[] args) {
        int n = 20; //(10100) >>Set 5 bit to 0 the ans should be 4
        System.out.println(result(n));
    }

    static int result(int n) {
        int mask = ~(1<<4);
        int result = mask&n;
        return result;
    }
}
