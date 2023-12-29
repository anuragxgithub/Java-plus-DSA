import java.util.Arrays;
//Remember [1 to n] See notes IMPORTANT
public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {2,5,3,1,4,6}; //Here elements is from 1 to 6 so we can apply C.S.
        int i = 0;
        while (i<arr.length) {
            int correctIndex = arr[i]-1; //Value of that element - 1.
            if(arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
