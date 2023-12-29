//KNOW HOW TO BREAK THE PROBLEMS IN RECURSION FOR IT WILL HELP FORMING THE CODE PROPERLY :)
public class SumProdOfDigits {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(sumDigits(n));
        System.out.println(productDigits(n));
    }
    static int sumDigits(int n) {
        if(n==0) {
            return 0;
        }
        return (n%10) + sumDigits(n/10);
    }
    static int productDigits(int n) {
        if(n%10 == n) {  //IMP. ->MEANS IF ONE DIGIT IS REMAINING RETURN THT DIGIT⭐ why this b/z if user give n = 0 it handles that
            return n;
        }
        return productDigits(n/10)*(n%10);
    }
}
