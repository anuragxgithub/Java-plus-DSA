package RecursionOnArrays;

public class PrintMax {
    //
    static void printMax(int[] arr, int idx, int max) {
        if(idx == arr.length) {
            System.out.println(max);
            return;
        }
        if(arr[idx] > max) {                    // self work
            printMax(arr, idx+1, arr[idx]);         // assigned recursive work
            return;
        }
        printMax(arr, idx+1, max);
    }
    //
    static int returnMax(int[] arr, int idx) {
        if(idx == arr.length-1) return arr[idx];

        int smallAns = returnMax(arr, idx+1);
        return Math.max(arr[idx], smallAns);
    }

    public static void main(String[] args) {
        int[] arr = {4,6,3,73,7,99};
        int max = Integer.MIN_VALUE;
        printMax(arr, 0, max);      //1. Printing


        System.out.println( returnMax(arr, 0));      //3. Returning

//        Time: O(n)
//        Space: O(n)    -> that's why recursion sucks in comparison to loops in some context
    }
}
