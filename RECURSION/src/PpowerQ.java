public class PpowerQ {

    public static int square(int p, int q) {        // O(q)
        if(q == 0) return 1;

        // self work p*p
        // assigned recursive work square(q-1)
        return square(p, q-1) * p;

    }
    // Alternative approach better than the previous one
    // if p^q is given   : we can calculate it like this also :-> p^(q/2) * p^(q/2)
    // RECURRENCE RELATION :
    // pow(p,q) = p^(q/2) * p^(q/2)          , given that q is even
    // pow(p,q) = p * p^(q/2) * p^(q/2)      , given that q is odd
    static int pow(int p, int q) {                          // O(q)
        if(q == 0) return 1;

        if(q % 2 == 0) {  // even
            return pow(p, q/2) * pow(p, q/2);
        } else {   // odd
            return p * pow(p, q/2) * pow(p, q/2);
        }
        // but here nothing got improved no. of calls are same or even more
        // so just change it little, like given below:
    }
    static int powOp(int p, int q) {    // O(log(q)) bcz getting divided in half each time    "improved a lot"
        if(q == 0) return 1;

        int smallPow = powOp(p, q/2);  // calculating once and using everywhere else

        if(q % 2 == 0) {
            return smallPow * smallPow;
        }
        return p * smallPow * smallPow;   // no need to put it in else condition bcz it is obvious that it will only execute if num is odd bcz if it is even ans got return from there
    }

    public static void main(String[] args) {
        // given p and q find -> p power q.
        System.out.println(square(2,4));

        System.out.println(pow(2,4));

        System.out.println(powOp(2, 4));
    }
}
