public class Complement_ofNumber {
    public static void main(String[] args) {
//      int x = ~5;  This is wrong b/z (complement b. operator acts on the total bits) so remaining bits which have 0 on left side will also be converted to 1
//      instead we do XOR with 1 with the same no of digits as in given number
        int x = 5;
        int countDigits = (int) (Math.log(x) / Math.log(2)) + 1; //See notes to know how it is calculated (How to calculate number of digits of any number system)
        int mask = (1<<countDigits) -1;
        int result = mask^x;
        System.out.println(result);
    }
} //Easssy Peasyyy
