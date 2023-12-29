// 2D arrays Intro. (Input and output of 2D Array)
import java.util.Scanner;
import java.util.Arrays;

public class TwoD_Intro1 {
    public static void main(String[] args) {
// Syntax:       int[][] arr = new int[rows][cols];   rows are mandatory to mention not cols.
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        // INPUTTING Elements
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {  // for column here we used arr.length b/z no of rows and no of columns are same
                System.out.print("Enter element of row "+ (row+1) + " column " + (col+1)+" : ");
                arr[row][col] = sc.nextInt();
            }
        }
        // OUTPUTTING ELEMENT (Method 1: Conventional for loop)

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {  // for column here we used arr[row].length which means every array at that row the length of that array b/z no of cols. can be different for different rows
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();  // to make it look like a matrix
        }

        // OUTPUTTING ELEMENT (Method 2: Arrays.toString() method)

//        for (int row = 0; row < arr.length; row++) {
//                System.out.println(Arrays.toString(arr[row])); // It is telling that first element of array is an array itself
//            }

        // OUTPUTTING ELEMENT (Method 3: Enhanced for loop)

//        for (int[] a : arr) {
//            System.out.println(Arrays.toString(a));
//        }

    }
}
