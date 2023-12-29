// this is a selecting algorithm works similar as quick sort here we do not sort the whole array rather
// we sort a part of array using quick sort algo idea and then find Kth largest/smallest element.
// NOTE: this is not a sorting algorithm.
// https://leetcode.com/problems/kth-largest-element-in-an-array/
// (note kth largest means after sorting which is the kth largest element same element would also be counted
//Note that it is the kth largest element in the sorted order, not the kth distinct element.)
// eg : arr = [3,2,3,1,2,4,5,5,6], k = 4
// output should be 4 bcz after sorting it is the largest element

/* HOW ALGORITHM IS WORKING :
Simple just like separating smaller elements to left and larger element to right of the pivot now we here
need only largest element so, we are not going to sort any part of the array rather we will keep changing
the pivot index until it is equal to the kth largest element. How do we know it will be equal to the kth
largest element simple from pivot all the elements at right will be greater than pivot so if we are able to
find the pivotIdx from where there are only k elements left to the right side. Bcz then that pivot idx will
represent the kth largest element of the array.
* */

// NOTE: you can also find the smalled kth elements using this algorithm try to write that too. H.W.
public class QuickSelectAlgo {
    public static void main(String[] args) {
        // Que: Find the Kth largest element from the array.
        int[] arr = new int[] {3,2,1,5,6,4}; // array in java can also be written like this.
        int k = 2;
        int result = quickSelect(arr, 0, arr.length-1, k);
        System.out.println(result);
    }


//    private static int quickSelect(int[] nums, int left, int right, int k) {
//        if(left == right) {
//            return nums[left];
//        }
//
//        int pivotIdx = partition(nums, left, right);
//        int KthLargestIdx = nums.length-k;  // bcz think na after we have all the elements greater than the pivotIdx is at right side then element at pivotIdx is the (N-pivotIdx)th largest element of the array
//        if(pivotIdx > KthLargestIdx) {  // then search left
//            return quickSelect(nums, left, pivotIdx-1, k);
//        } else if(pivotIdx < KthLargestIdx) {  // then search right
//            return quickSelect(nums, pivotIdx+1, right, k);
//        } else {  // when pivotIdx == k ("i" will be pointing to the ith/kth largest element)
//            return nums[pivotIdx];
//        }
//    }
//    private static int partition(int[] nums, int left, int right) {
//        int i = left;  // this would be the correct pivot idx
//        int pivot = nums[right];  // initially taking pivot as last element (u can use random no. generator)
//        for(int j = left; j < right; j++) {  // note < right means we are skipping last(pivot element)
//            if (nums[j] <= pivot) {  // swap
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//                i++;
//            }
//        }
//        // swapping pivot to its correct idx
//        int temp = nums[right];
//        nums[right] = nums[i];
//        nums[i] = temp;
//
//        return i;
//    }

    // <-- SECOND APPROACH (SAME THING BUT NOT ADDING SEPARATE PARTITION METHOD) --> //

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if(left == right) {
            return nums[left];
        }
        int i = left;  // this would be the pivot idx
        int pivot = nums[right];  // initially taking pivot as last element (u can use random no. generator)
        for(int j = left; j < right; j++) {  // note < right means we are skipping last(pivot element).  (also start loop from left)
            if (nums[j] < pivot) {  // swap  (only take smaller than not <= bcz time compl. increases in swapping)
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        // swapping pivot to its correct idx
        int temp = nums[right];
        nums[right] = nums[i];
        nums[i] = temp;

        int KthLargestIdx = nums.length-k;   // draw the array when it got fully sorted this and then calculate this formula this is our kth largest element's idx
        if(i > KthLargestIdx) {  // then search left
            return quickSelect(nums, left, i-1, k);
        } else if(i < KthLargestIdx) {  // then search right
            return quickSelect(nums, i+1, right, k);
        } else {  // when pivotIdx == KthLargestIdx ("i" will be pointing to the kth largest element)
            return nums[i];
        }
    }

}

// The other approaches for this ques. like sorting or using priority q is covered in Hashing_PriorityQ folder.