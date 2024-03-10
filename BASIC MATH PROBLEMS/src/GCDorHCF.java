import java.util.Scanner;
/* Greatest Common Divisor(GCD) or Highest Common Factor(HCF)
   meaning the largest number that evenly DIVIDES the given numbers.
 */
public class GCDorHCF {
    public static void main(String[] args) {
        int n1, n2,gcd = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        n1 = sc.nextInt();
        System.out.print("Enter second number: ");
        n2 = sc.nextInt();
        for (int i = 1; (i <= n1) && (i<= n2); i++) {
            if(n1%i==0 && n2%i==0)  {
                gcd = i;   //Or u can run loop opposite and use break when the if condition gets true
            }
        }
        System.out.println("GCD of given numbers is: "+ gcd);
    }
}
