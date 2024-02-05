// Question :  For a given array of integers of size n, answer q queries to print the sum of values
// in a given range of indices from l to r
// the values of l and r in queries follows 1-based indexing
package Questions;

import java.util.Arrays;
import java.util.Scanner;

public class Prefix_Sum_2 {
    public static void main(String[] args) {
        int[] arr = {1,4,2,6,8,21,65,18};
        int q = 3;
        System.out.println("There would be " + q + " queries :");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < q; i++) {
            System.out.println("Enter l : ");
            int l = sc.nextInt();
            System.out.println("Enter r : ");
            int r = sc.nextInt();
            int ans = solveQuery(arr, l, r);
            System.out.println("Sum of values from " + l + " to " + r + " is: " + ans);

        }
    }

    static int solveQuery(int[] arr, int l, int r) {
        // since we need to find q query means we need to do the same thing again and again
        // to overcome this we will form prefix sum arr so that we can refer that for any queries
        // without looping again and again
        int[] pArray = new int[arr.length+1];  // bcz one based indexing
        int sum = 0;
        for(int i = 1; i <= arr.length; i++) {
            sum += arr[i-1];
            pArray[i] = sum; // skipping the 0th idx so that calculation becomes easy (as 1 based indexing given in Q)
        }
//        System.out.println(Arrays.toString(pArray));
        int sumLtoR =  pArray[r] - pArray[l-1];  // se the formula in first file of prefix sum pretty straight forward
        // prefix(i,j) = prefix(j) - prefix(i-1)
        return sumLtoR;
    }
}
