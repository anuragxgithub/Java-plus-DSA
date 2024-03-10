public class Count_SetBits {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Integer.toBinaryString(n));
        int count = 0;
//      <----METHOD 1----> (NAIVE APPROACH) (Iterate for all digits of given no)
//        while(n>0) {
//            if((n&1)==1) {
//                count++;
//            }
//            n = n>>1;
//        }
//        System.out.println(count);

//      <----METHOD 2----> (OPTIMISED) (Iterate for set bits only of given no)(SeeNotes 4 this)
        //Brian Kernighan's Algorithm
        while(n>0) {  //NOTE : USE (n != 0) when n can be -ve too ⭐⭐⭐ Simple logic
            count++;
            n = n & (n-1);
        }
        System.out.println(count);

//      <----METHOD 3----> (OPTIMISED) (Iterate for set bits only of given no) //DON'T Care For This Algo. others are enough
//        while(n>0) {
//            count++;
//            n = n - (n & -n);
//        }
//        System.out.println(count);

//      <----METHOD 4 USING MASK---->
//         int mask = 1;
//         for (int i = 0; i< 32; i++) {
//             if((n & mask) != 0) {  //Remember to not use == 1 b/z of mask
//                 count++;
//             }
//             mask = mask<<1;
//         }
//        System.out.println(count);

//      <----METHOD 5----> BUILT IN METHOD
//        System.out.println(Integer.bitCount(n));

    }
}
