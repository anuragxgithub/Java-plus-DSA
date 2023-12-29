import java.util.Scanner;
public class Largest_num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a:");
        int a = sc.nextInt();
        System.out.println("Enter b:");
        int b = sc.nextInt();
        System.out.println("Enter c:");
        int c = sc.nextInt();
        if(a > b && a > c) {
            System.out.println("First number is greater and its value is :" + a);
        }else if(b > a && b > c) {
            System.out.println("Second number is greater and its value is :" + b);
        } else
            System.out.println("Third number is greater and its value is :" + c);
    }
}
