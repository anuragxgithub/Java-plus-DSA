public class Find_ith_bit {
    public static void main(String[] args) {
        int num = 20; //FIND THE 5TH BIT (10100)
        System.out.println(find(num));
    }

    static int find(int n) {
        //METHOD 1: BY RIGHT SHIFT
//        n = 20>>4; //(ith bit position-1)
//        if((n&1)==1) {
//            return 1;
//        } else {
//            return 0;
//        }

        //METHOD 2: BY CREATING A MASK(See Notes)
        int mask = 1 << (5 - 1); //(ith bit position-1)
        if ((n & mask) != 0) {  //NOTE: u can put this condition in if : (n & mask) == 1 b/z of simple logic as output can be any non-zero number in case when ith element is 1
            return 1;
        } else {
            return 0;
        }
    }
}