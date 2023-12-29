// Length property of array
import java.util.Scanner;
public class Intro_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        int size = sc.nextInt();
        System.out.println("Enter the number u ant to find in aary:");
        int x = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0; i<size; i++) {
            System.out.println("Enter "+ (i+1) + " element of array");
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<arr.length; i++) { // Stores the size of array
            if(arr[i]==x) {
                System.out.print("X found at index "+i);
            }
        } //This technique is called linear search.
    }
}
