package Foundation;

public class Recursion_Factorial {
    public static void main(String[] args) {
        int ans = fact(5);
        System.out.println(ans);
    }
    static int fact(int n) {
        if(n==1) {
            return n;  //1 will be transferred to fact(2)
        }
        return n * fact(n-1);
    } //NOTE:  It is a tail-recursive function. b/z fn fact(n-1) is the last operation to be performed.
}
//<------ BEST EXPLANATION CHAT GPT------>
//Now, let's trace the values being multiplied in this recursive call stack for the calculation of the BasicQuestions.factorial of 5:

//    fact(5)
//        return 5 * fact(4)
//                    return 4 * fact(3)
//                                return 3 * fact(2)
//                                            return 2 * fact(1)
//                                                            return 1
//As the recursive calls return, they pass their result back to the caller.
//In this case, fact(1) returns 1 to fact(2), which multiplies it with 2 to get 2.
// fact(2) then returns 2 to fact(3), which multiplies it with 3 to get 6, and so on.
//Finally, the outermost call to fact(5) multiplies the result of fact(4) with 5 to get the final result of 120.
//Therefore, the values are getting multiplied in a bottom-up manner, with the base case being the starting point,
//and the final result being the product of all values returned by the recursive calls.