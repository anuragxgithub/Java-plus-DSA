//NOTE: THE ARRAY WHICH IS IN MAIN IS PASSED(REFERENCE OF THAT OBJECT IS PASSED)
//IN ALL FN CALL NO NEW ARRAY IS BEING CREATED.
public class SortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,6,7};
        System.out.println(isSorted(arr, 1));
    }

    static boolean isSorted(int[] arr, int index) {
        if(index == arr.length) { //Base Condition (See arr.length not arr.length-1)
            return true;
        }
        if(arr[index-1] > arr[index]) {  //Only if greater, return false
            return false;
        }
        return isSorted(arr, index+1);
        //Or u can also include the 2nd if condition in return like this: (GoodPractice)
        //>> return arr[index] < arr[index+1] && isSorted(arr, index+1); <<//
        //but u have to take index from 0 and base condition should have arr.length-1
    }
}