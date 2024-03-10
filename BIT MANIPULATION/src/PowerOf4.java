//PREREQUISITE: check first if there is only one set bit in the binary
//representation of the number and that there are even number of zeros to the
//right of the set bit.There are 4 (even) zeros after set bit, hence, 16 is a power of 4.
public class PowerOf4 {
    public static void main(String[] args) {
//NOTE: It is better to solve these power of 3,4,5... Ques. using recursion or BINARY-SEARCH.
        int n = 16;
        System.out.println(isPowerOf4(n));
        System.out.println(method2(n));
    }
    static boolean isPowerOf4(int n) {
        if(n<=0) return false;
        if(n==1) return true;   //1 is power of any number
        int tZeros = Integer.numberOfTrailingZeros(n);
        if(tZeros % 2 == 0) {
            if((n & (n-1)) == 0) {  //You know what it does
                return true;
            }
        }
        return false;
    }
    //Using Recursion
    static boolean method2(int n) {
        if(n==0) return false;  //base condition
        if(n==1) return true;  //base condition

        return n%4 == 0 && method2(n/4);
    }
    //You can also do it using binary search approach
}
