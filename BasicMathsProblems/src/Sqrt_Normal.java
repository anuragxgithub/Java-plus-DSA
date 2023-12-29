import java.util.Scanner;
public class Sqrt_Normal {
    public static void main(String[] args) {
        System.out.print("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double ans = sqrt(n);
        System.out.println("The sq. root of "+n+" is : "+ans);
    }

    static double sqrt(int n) {
        double i = 0;
        while(i*i < n) {
            i++;
        }
        i--;

        if(i*i == n) {
            return i;
        } else {
            double increment = 0.1;
            for(int p = 1; p<=3; p++) {
                while(i*i<=n) {
                    i += increment;
                }
                i -= increment;
                increment /= 10;
            }
            return i;
        }
    }
}
