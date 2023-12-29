public class RightMostSetBit {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(Integer.toBinaryString(n)); //Represent the number in binary

//        <<----OPTIMISED APPROACH---->>

        int rightMostSetBit = Integer.numberOfTrailingZeros(n & -n) + 1;
        System.out.println(rightMostSetBit);
        //Note 2 Things here: 1) Count the no of trailing zeros in binary number.
        //                    2) n & -n gives the new integer with only the rightmost set
        //                    bit of 'n' turned on(1) and all other bits turn off(0).
        // TComplexity: O(1)
        //Will not work for 0 separate the 0 condition

//        <<----NAIVE APPROACH---->>

//        int count = 0;
//        while((n & 1) == 0) {
//            count++;
//            n = n>>1;
//        }
//        System.out.println(count+1);
//        //O(log(n))
    }
}
