public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3,45,3,2,24,6,8};
        int target = 6;
        System.out.println(isPresent(arr, target, 0));
        System.out.println(findIndex(arr, target,  0));
    }

    static boolean isPresent(int[] arr, int target, int index) {
        if(index == arr.length) {  //(See arr.length not arr.length-1)
            return false;
        }
//        if(arr[index] == target) {
//            return true;
//        }
//        return isPresent(arr, target, index+1);

        //This whole thing can be written as:  ⭐⭐⭐⭐⭐⭐
        return arr[index] == target || isPresent(arr, target, index+1);
        //Now you can understand the flow of the return statement with 2 0r more conditions
    }

    static int findIndex(int [] arr, int target, int index) {
        if(index == arr.length) {
            return -1;
        }
        if(arr[index] == target) {
            return index;
        } else {
            return findIndex(arr, target, index+1);
        }
    }
}
