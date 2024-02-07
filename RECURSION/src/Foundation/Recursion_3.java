package Foundation;

public class Recursion_3 {
    public static void main(String[] args) {
        int ans = fib(4);
        System.out.println(ans);
    }
//    treating 0th index as value 0 and 1st index as value 1  >> 0 1 1 2 3 5 8 13 (0-Indexed)
//    you can treat it otherwise too just set condition accordingly like if n=1 || n=2 return 1; (1-Indexed)
    static int fib(int n) {
        if(n<2) {  //base condition
            return n;
        }
        int element = fib(n-1) + fib(n-2); //This fib(n-2) will be executed when fib(n-1) returning back
        return element;
        //You can replace both line by[ return fib(n-1) + fib(n-2); ]
        //Note : this is not tail recursion or tail recursive fn as after the recursive fn there is additional operation too to be done
//        a tail-recursive function calls itself as its final operation,
//        without any further computation to perform on the result of the recursive call.
    }
}
//<--------- BEST EXPLANATION (First check the BasicQuestions.factorial explanation)------>
//Now, let's trace how the values are being added in this recursive call stack for the calculation of the 4th Fibonacci number:

//    fib(4)
//        return fib(3) + fib(2)         // fib(3) returns 2
//                        return fib(2) + fib(1)      // fib(2) returns 1
//                                        return fib(1) + fib(0)     // fib(1) returns 1 and fib(0) returns 0

//As the recursive calls return, they pass their result back to the caller.
//In this case, fib(0) and fib(1) return 0 and 1 to fib(2), which adds them to get 1.
//fib(2) then returns 1 to fib(3), which adds it with the result of fib(1) to get 2, and so on.

//Finally, the outermost call to fib(4) adds the result of fib(3) with the result of fib(2)
//to get the final result of 3. Therefore, the values are getting added in a bottom-up manner,
//with the base case being the starting point, and the final result being the sum of all
// values returned by the recursive calls.

//Note that this is not a tail-recursive function as after the recursive calls return,
//the function still needs to add the results together to compute the final value.