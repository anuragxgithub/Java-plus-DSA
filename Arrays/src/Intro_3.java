// Inputting and outputting array with loop
import java.util.Scanner;
public class Intro_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i<size; i++) {
            System.out.println("Enter element "+ (i+1));
            arr[i] = sc.nextInt();
        }
        System.out.println("Array is:");
        for(int i = 0; i<size; i++) {
            System.out.println(arr[i]+ " ");
        }
    }

}
