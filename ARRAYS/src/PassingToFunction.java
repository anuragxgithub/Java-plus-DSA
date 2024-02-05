import java.util.Arrays;
// Arrays are mutalbe. (what is mutability in java ? ans: in simple, mutable means in java that you can change the object)
public class PassingToFunction {
    public static void main(String[] args) {
        int[] arr = {1,2,3,32};
        System.out.println(Arrays.toString(arr));
        printArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void printArray(int[] arr){
        arr[0] = 8;
    }
}
