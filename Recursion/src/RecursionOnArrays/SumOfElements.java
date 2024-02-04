package RecursionOnArrays;

public class SumOfElements {
    public static int findSum(int[] arr, int idx) {
        if(idx == arr.length) {
            return 0;
        }
        return arr[idx] + findSum(arr, idx+1);
        // Smaller problem is: adding the first element and asking recursion to bring out the sum
        // of rest of the elements.
        // RECURRENCE RELATION: findSum(arr, idx) =  arr[idx] + findSum(arr, idx+1)
    }
    public static void main(String[] args) {
        int[] arr = {5,6};
        System.out.println(findSum(arr, 0));
    }
}
