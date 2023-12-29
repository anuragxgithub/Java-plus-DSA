/*
Program to calculate pow(x,n) using Binary operators:
To solve the problem follow the below idea:

Some important concepts related to this approach:

> Every number can be written as the sum of powers of 2
> We can traverse through all the bits of a number from LSB to MSB in O(log n) time.
Illustration:

3^10 = 3^8 * 3^2. (10 in binary can be represented as 1010, where from the left side the first 1 represents 3^2 and the second 1 represents 3^8)

3^19 = 3^16 * 3^2 * 3. (19 in binary can be represented as 10011, where from the left side the first 1 represents 3^1 and second 1 represents 3^2 and the third one represents 3^16)
*/
public class Exponentiation {
    public static void main(String[] args) {
        int base = 3;
        int power = 4;

//      This is optimised way TimeComplexity: O(log(n)) b/z iterating on the binary digits
        int ans = 1;
        while(power>0) {
            if((power & 1) == 1) {
                ans = ans*base;
            }
            base = base*base;
            power = power>>1;
        }
        System.out.println(ans);
    }
}
