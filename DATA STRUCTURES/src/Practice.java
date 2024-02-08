import java.util.*;

public class Practice {
    // 1. BUBBLE SORT
    public static void bubbleSort(int arr[], int n, int i, int j) {
        // As we know in bubble sort after one complete iteration biggest is at the last idx and so on
        // that means "sorting starts from end in bubble sort".
        if(i == n-1) {
            return;
        }

        if(j < n-i-1) {
            if(arr[j] > arr[j+1]) {
                // swap
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            bubbleSort(arr, n, i, j+1);
        } else {
            System.out.println(Arrays.toString(arr));  // proof that recursion is correct
            bubbleSort(arr, n, i+1, 0);  // bcz sorting happens from end
        }
    }

    // 2. PERMUTATIONS
    // public static void permutations(String up, String p) {
    //     if(up.isEmpty()) {
    //         System.out.println(p);
    //         return;
    //     }

    //     char ch = up.charAt(0);     // for this we will find different possible positions

    //     for(int i = 0; i <= p.length(); i++) {  // why <= ? bcz that many positions are possible for char to be inserted

    //         String first = p.substring(0,i);
    //         String second = p.substring(i,p.length());          // bcz end idx is exclusive
    //         permutations(up.substring(1), first+ch+second);

    //     }
    // }

    // 3. PERMUTATIONS COUNT
    // public static int permutationsCount(String up, String p) {
    //     if(up.isEmpty()) {
    //         return 1;
    //     }

    //     int count = 0;

    //     char ch = up.charAt(0);
    //     for(int i = 0; i <= p.length(); i++) {
    //         String first = p.substring(0, i);
    //         String last = p.substring(i, p.length());
            
    //         count = count + permutationsCount(up.substring(1), first + ch + last);
    //     }

    //     return count;
    // }

    // 4. PERMUTATIONS IN LIST
    // public static ArrayList<String> permutationsList(String str, String temp) {
    //     ArrayList<String> ans = new ArrayList<>();

    //     if(str.length() == 0) {
    //         ans.add(temp);
    //         return ans;
    //     }

    //     char ch = str.charAt(0);
    //     for(int i = 0; i <= temp.length(); i++) {
    //         String f = temp.substring(0, i);
    //         String s = temp.substring(i, temp.length());

    //         ans.addAll(permutationsList(str.substring(1), f+ch+s));
    //     }
    //     return ans;
    // }

    // 5. INSERTION SORT
    // public static void insertionSort(int[] arr, int n, int i, int j) {   
    //     // in insertion sort we pick one element and and put it in the left side (sorted part of array at its correct
    //     // position w.r.t. elements present in the left side)

    //     if(i == n-1) {
    //         return;         //base case
    //     }

    //     if(j > 0) {
    //         if(arr[j] < arr[j-1]) {
    //             // swap
    //             int temp = arr[j];
    //             arr[j] = arr[j-1];
    //             arr[j-1] = temp;
    //         } else {
    //             j = 0;      // break from here
    //         }
    //         insertionSort(arr, n, i, j-1);
    //     } else {
    //         System.out.println(Arrays.toString(arr)); // proof that recursion is implemented correctly
    //         insertionSort(arr, n, i+1, i+2);        // why +2 because i is not updated yet
    //     }
    // }

    // SELECTION SORT
    public static void selectionSort(int[] arr, int i, int j, int min) {
        // find the smallest or largest item's idx and put it to its correct idx
        if(i == arr.length-1) {
            return;
        }
        if(j < arr.length) {
            if(arr[min] > arr[j]) {
                selectionSort(arr, i, j+1, j);
            } else {
                selectionSort(arr, i, j+1, min);
            }
        }   // after its ending we will have min element's idx in min var
        else {
            // swap the minimum element to the first element and so on..
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp; 
            System.out.println(Arrays.toString(arr)); // proof that recursion is implemented correctly
            
            selectionSort(arr, i+1, i+1, i+1);  // again we need to check the minimum from the unsorted part so taking first item of unsorted part as smallest item
        }
    }

    public static void main(String[] args) {
        // 1. BUUBLE SORT  ------
        // int[] arr = new int[] {4,3,2,1};
        // bubbleSort(arr, arr.length, 0, 0);
        // System.out.println("From main : " + Arrays.toString(arr));

        // 2. Permutations ------
        // String s = "abc";
        // permutations(s, "");

        // 3. Permutations count 
        // System.out.println(permutationsCount("abcde", ""));           // n!

        // 4. Permutations in list
        // System.out.println(permutationsList("abc", ""));

        // 5. Insertion Sort
        // int[] arr = new int[] {4,3,2,1};
        // insertionSort(arr, arr.length, 0, 1);  // j will start from i+1
        // System.out.println("From Main : " + Arrays.toString(arr));

        // 6. Selection Sort
        // int[] arr = new int[] {4,3,2,1};
        // selectionSort(arr, 0, 0, 0);        // taking first element of array as smallest for now
        // System.out.println("From main : " + Arrays.toString(arr));
    }

}