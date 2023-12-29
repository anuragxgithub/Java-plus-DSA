import java.util.Scanner;

public class Reverse_num {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number :");
        int num = in.nextInt();
        int rev = 0;

        while (num>0) {
            int rem = num%10;
            rev = (rev * 10) + rem;
            num = num/10;
        }
        System.out.println("Reverse of given num is : "+rev);
    }
}
