import java.util.Scanner;
public class LCM {
    public static void main(String[] args) {
        int n1, n2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        n1 = sc.nextInt();
        System.out.print("Enter second number: ");
        n2 = sc.nextInt();
        int lcm = (n1>n2) ? n1 : n2; // b/z lcm can't be less than the largest number
        while(true) {
            if(lcm % n1 == 0 && lcm%n2 == 0) {
                System.out.println("LCM of given number is: "+ lcm);
                break;
            }
            lcm++;
        }
// -------------2nd Way using (hcf or gcd)-------------------//
        // (n1*n2)/hcf is equals to lcm of n1 and n2; (valid for two numbers only)
        int hcf = 0;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if(n1%i == 0 && n2%i == 0) {
                hcf = i;  //last wala i highest rahega OR  u can run loop opposite and use break when the if condition gets true
            }
        }
        int lcmm = (n1*n2)/hcf;
        System.out.println(lcmm);
    }
}
//⭐⭐
//The time complexity of the naive approach to find the LCM of two numbers using
//a loop in Java is O(N), where N is the maximum possible value(Integer.MAX_VALUE) of
//the two input numbers.
//However, in practice, the time complexity is much less than O(N), as the LCM
//of two typical input numbers is much smaller than Integer.MAX_VALUE, and the
//loop is likely to terminate much earlier. Nonetheless, the worst-case time complexity
//is still O(N).