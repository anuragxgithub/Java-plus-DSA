//we will use recursion.
//This is binary exponentiation method which is used to calculate the exponentiation.
//here we are using recursive method for iterative method go to other file.
public class PowerOfx {
    public static void main(String[] args) {
        int x = 5;
        int n = 3;  //power
        System.out.println(pow(x,n));
    }

    static int pow(int x, int n) {
        if(n == 0) return 1;  //base case x power 0 will be one.

        int temp = pow(x, n/2);  //this is an efficient way of doing it rather than passing n-1.
        if(n % 2 != 0) return temp*temp*x; //this is going to execute at least once bcz n/2 makes any n to 1 first and then divide it further to make it 0. so n will become 1 for any n.
        return temp*temp;
    }
}
//T.C -> O(log n) which is much better than O(n) by traditional approach.
//S.C -> O(n) fn call taking space in stack (height of the recursion tree.)