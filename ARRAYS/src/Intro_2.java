// By default array initialisation (See notes for details)
import java.util.Arrays;
public class Intro_2 {
    public static void main(String[] args) {
        int arr[] = new int[5];
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);

        String arr1[] = new String[3];
//        System.out.println(arr1[0] + " " + arr1[1]+ " "+ arr1[2]);
//        Better way to print string array is using toString() method (it is programmed as to put commas and sq brackets automatically and also uses for loop to print values) i.e,
        System.out.println(Arrays.toString(arr1));
    }
}
