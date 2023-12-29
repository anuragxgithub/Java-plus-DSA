//Armstrong Number
import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        System.out.println(isArmstrong(num));
    }
    static boolean isArmstrong(int n) {
        int r, sum=0, ori_num = n;
        while(n>0) {
            r = n%10;
            sum = sum + (r*r*r);
            n /= 10;
        }
        return sum == ori_num;  // Return true if this is valid else false ,u can also write it using if else but it would be lil bit lengthy

    }
}
