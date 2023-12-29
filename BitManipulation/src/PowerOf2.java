public class PowerOf2 {
    public static void main(String[] args) {
        int n = 16; //Not work for 0 so set separate condition for this
        if((n&(n-1)) == 0) {
            System.out.println("Power of two");
        } else {
            System.out.println("Not a Power of two");
        }
     //This question can also be solved by lengthy method by using count var., right shift, & and while loop.
    }//See notes to understand what is happening (Power of Two Binary Number Heading)
}
//If you don't want to find power of 2,3,4,5,... using bit manipulation
//u can find it using recursion/loops AND using binary search too