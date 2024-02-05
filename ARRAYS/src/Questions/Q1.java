package Questions;// Swapping values in array.
import java.util.Scanner;
import java.util.Arrays;
public class Q1 {
    public static void main(String[] args) {
        int[] arr = {1,3,43,78,22,33};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first index: ");
        int x = sc.nextInt();
        System.out.print("Enter the second index: ");
        int y = sc.nextInt();
        swap(arr, x, y);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
