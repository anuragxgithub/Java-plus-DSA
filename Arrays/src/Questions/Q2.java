package Questions;

// Maximum number from an array.
public class Q2 {
    public static void main(String[] args) {
        int[] arr = {102, 2, 34, 100, 103, 12, 55, 63, 8, 99};
        System.out.println(maxi(arr));
        System.out.println("Max no in given range is : " + maxInRange(arr, 5, 9));
    }

    static int maxi(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < (arr.length); i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static int maxInRange(int[] arr, int start, int end) {
        int max = arr[start];
        for (int i = start; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
