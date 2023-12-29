/*
★) EQUALITY OF ARRAYS :
Note : When we create array either by directly defining and declaring or by using new keyword then each
time for each array new memory space is allotted whether the array is equal or not.

So whenever you use == operator to compare two arrays it will always return false bcz of obvious reason
(== checks if both the variables have same reference).
To check the content of the array use Arrays.equals(arr1, arr2).Simple.
*/
package ArrayEquality;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};

//        boolean result = arr1 == arr2;                   // it checks whether both var. are pointing to same memory address
        boolean result = Arrays.equals(arr1, arr2);    // it checks the actual content of the array

        if(result) {
            System.out.println("Both arrays are equal.");
        } else {
            System.out.println("Both arrays are not equal.");
        }

        // Another way to check the equality is :
        boolean isEqual = true;
        if(arr1.length == arr2.length) {
            for(int i = 0; i < arr1.length; i++) {
                if(arr1[i] != arr2[i]) {
                    isEqual = false;
                }
            }
        } else {
            isEqual = false;
        }
        if(isEqual) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
