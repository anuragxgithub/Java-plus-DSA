import java.util.Scanner;

public class Occurrence_counting {
    public static void main(String[] args) {
    int n = 84755841;
    System.out.println("The given number is : "+ n);
    Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to find its from the given number:");
        int x = sc.nextInt();
        int count = 0;
        while(n>0) {
            int r  = n%10;
                if (r==x) {
                    count++;
                }
            n /= 10;
    }
        System.out.println("Total ocuurence is : " + count);
}
}
