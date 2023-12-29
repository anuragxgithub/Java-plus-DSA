import java.util.Arrays;

public class ChangeValue {
    public static void main(String[] args) {
        int[] arr = {1,2,4,54,33,3};
        System.out.println("Array before function call is : \n"+ Arrays.toString(arr));
        change(arr);
        System.out.println("After fn call: \n"+Arrays.toString(arr));
    }
    static void change(int[] array) {
        array[0] = 99;
    }
} /* So why here value get changed in main ?
     b/z here we are changing the actual object and not creating a new object.
     remember in case of string we are not changing/unable to change the value
     of actual string in the main method thus it creates new object and start pointing
     to it without changing the string in main() method.

     To actually feel it replace line 11 with
     array = new int[]{99, 2, 32, 32};
     now the array in main will not change
     */
