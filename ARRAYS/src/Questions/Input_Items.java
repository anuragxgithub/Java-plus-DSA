// taking elements from user of array

package Questions;

import java.util.Scanner;
import java.util.Arrays;

public class Input_Items {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements: ");
        for(int i = 0; i < size; i++) {
             arr[i] = sc.nextInt();
        }

        System.out.println("Your array is :");
        System.out.println(Arrays.toString(arr));
    }
}
