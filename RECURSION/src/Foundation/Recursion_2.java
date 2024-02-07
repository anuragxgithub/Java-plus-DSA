package Foundation;

//When a fn calls itself it is called recursion.
//If any return hits before the recursive fn then recursion will not happen simple.
public class Recursion_2 {
    public static void main(String[] args) {
        //Print the 1,2,3,4,5 numbers using recursion
        printNumbers(1);
    }
    static void printNumbers(int n) {
        if(n==5) {  //base condition
            System.out.println(n);
            return;  // "return" statement is used to terminate the execution of the current method (i.e., "printNumbers") and return control back to the calling method (i.e., "main").
        }
        System.out.println(n);
        printNumbers(n+1); //A fn calling itself (with different arguments)
//        NOTE: This is tail recursion
//        a tail-recursive function calls itself as its final operation,
//        without any further computation to perform on the result of the recursive call.
    }
}
//Note: Things which can be done by loops can also be done by recursion.
