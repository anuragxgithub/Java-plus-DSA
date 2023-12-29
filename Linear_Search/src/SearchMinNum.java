public class SearchMinNum {
    public static void main(String[] args) {
        int[] arr = {23,45,5661,5,6,65,46,8,9,7,91,676,99};
        int ans = search(arr);
        if (ans== -1) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Min number in array is: "+ ans);
        }
    }
    static int search(int[] arr) {
        if(arr.length == 0) {
            return -1;
        }
        int min = arr[0];
        for(int element : arr) { //Enhanced for loop or (for each loop)
            if(min > element) {  // if min is smaller than any element it will become min
                min = element;
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] < min) {
//                min = arr[i];
//            }
//        }
        return min;
    }
}
