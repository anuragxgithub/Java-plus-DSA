//WE KNOW LCM OF A AND B IS : A*B/HCF(A,B)
//AND WE WILL USE EUCLIDEAN ALGO TO FIND GCD/HCF
public class LCM_OPTIMISED {
    public static void main(String[] args) {
        int a = 3, b = 7;   //remember a or b anyone can be bigger no restriction
        System.out.println(lcm(a,b));
    }
    static int gcd(int a, int b) {
        if(a==0) { //here I make a==0 that means I have to provide rem. value to a so that it become 0 & (a->b) see notes if u don't understand
            return b;
        }
        return gcd(b%a,a); //in base condition b is returned soo here b%a only (can't do a%b)
    }
    static int lcm(int a, int b) {
        return (a*b/gcd(a,b));
    }
}
//Euclidean algorithm to find LCM is O(log a*b) ⭐⭐
// b/z here only finding hcf taking time as lcm got calculated in O(1)
