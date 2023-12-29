import java.util.Arrays;

//See notes for Explanation. (RECOMMENDED)
 class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,3,6,2,5,99,0,-23,-7}; //Don't give error for empty array Simple logic
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));//Actual value in main will also be changed
    }
    static void bubbleSort(int[] arr) {
        //What if the array is already sorted
        //or get sorted in 1or2 pass, to stop unnecessary iteration and save time:
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = true; //Assume that array is sorted
            for (int j = 1; j < arr.length-i; j++) { //See notes (RECOMMENDED) to understand condition
                if(arr[j] < arr[j-1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1]; //Can u compare by using j+1 no index outOfBoundError occur
                    arr[j-1] = temp;
                    swapped = false;
                }
            }
            // Here swapped is true only when: no elements at first pass found to be
            // greater than its previous element i.e, above if condition didn't hit
            // thats why value of swapped remain same.
            if(swapped) {  //or swapped == true
                break;
            }
        }
    }
}