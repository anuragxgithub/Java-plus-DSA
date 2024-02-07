package Foundation;

public class ReverseNum {

    static int reverse(int n, int reversedNumber) {
        if(n == 0) return reversedNumber;

        int digit = n%10;
        reversedNumber = (reversedNumber*10)+digit;

        return reverse(n/10, reversedNumber);

    }

    public static void main(String[] args) {
        int num = 1241;
        System.out.println(reverse(num, 0));
    }
}
