package Questions;//fibonacci series using arrays.
import java.util.Scanner;
import java.util.Arrays;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the term till u want to print array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        fib(arr, n);
        System.out.println(Arrays.toString(arr));
    }
    static void fib(int[] arr, int size) {
        for (int i = 2; i < size; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
    }
}
