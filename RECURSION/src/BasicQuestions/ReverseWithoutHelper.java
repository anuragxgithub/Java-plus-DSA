package BasicQuestions;

public class ReverseWithoutHelper {

    public static int reverse(int num) {
        if(num == 0) {
            return 0;
        }
        int digits = (int)(Math.log10(num)) + 1;
        int base = 1;
        for(int i = 0 ; i < digits-1; i++) {
            base = base*10;
        }
        int digit = num%10;
        return (base * digit) + reverse(num/10);

    }

    public static void main(String[] args) {
        int num = 1111195;
        System.out.println(reverse(num));
    }
}
