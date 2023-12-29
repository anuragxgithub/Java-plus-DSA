// Array syntax

public class Intro_1 {
    public static void main(String[] args) {
        /* Syntax 1:
          type[] arrayName = new type[size];
     OR.. type arrayName[] = new type[size]; */

        /* Syntax 2:  (declaring & initialising both at same tym)
          type[] arrayName = {1,2,34,54,322};
     OR.. type arrayName[] = {1,2,32,54,322};
         */
        int[] arr = new int[5];
        arr[0] = 12;
        arr[1] = 123;
        arr[2] = 33;
        arr[3] = 192;
        arr[4] = 133;
        System.out.println(arr[0]);
        System.out.println(arr[3]);

//        int arr2[] = new int[3];  also correct


        int[] array = {1,2,3,4,5};
        System.out.println(array[2]);

    }
}
