import java.util.Scanner;

public class For_each_loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[8];
        //Inputting values
        for (int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // Output of values (not using normal for loop)
        for (int j : arr) {  // for every element in array, print the element.
            System.out.print(j + " "); // j here is a variable which can be named anything(represents elements of array)
        }
    }
}
