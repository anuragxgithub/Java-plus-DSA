public class SumTillN {
    public static int sum(int n) {
        if(n == 1) return 1;

//        int digit = n;              // self work
//        int remaining =  sum(n-1);              // assigned recursive work
//        return  remaining + digit;      // self work

        return sum(n-1) + n;
    }

//    QUESTION 2: Given a number n. Find the sum of n natural numbers till n but with alternate signs.
//    That means if n = 5 then you have to return 1-2+3-4+5 = 3 as your ans.

    public static int sum_2(int n) {
        if(n == 1) return 1;

//        if(n % 2 == 0) {
//            return sum_2(n-1) - n;
//        }
//        return sum_2(n-1) +n;
        // Write above code like this
        int smallAns = sum_2(n-1);                // recursive calls got reduced
        if(n%2 == 0) return smallAns-n;
        return smallAns+n;
    }
    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(sum_2(2));
    }
}
