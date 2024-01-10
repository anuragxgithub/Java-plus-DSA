// Kth largest element from an array 
// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
package Heap_PriorityQ;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1 {
    public static void main(String[] args) {
        int[] arr = new int[] {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int ans = findKthLargest(arr, k);
        System.out.println(ans);
    }

    private static int findKthLargest(int[] nums, int k) {
        // FIRST APPROACH : SORT THE ARRAY

        // Arrays.sort(nums); // we can't directly sort in desc. order of arr containing primitive values so sorting in ascending order
        // System.out.println(Arrays.toString(nums));
        
        // k = nums.length - k;
        // return nums[k];
        // // T.C. : O(nlog(n)   S.C. : O(1)

//--------------------------------------------------------------------------------------//
        // SECOND APPROACH : USING PRIORITY QUEUE

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // for(int i = 0; i < nums.length; i++) {
        //     pq.add(nums[i]);
        // }
        // int ans = 0;
        // while(k != 0) {
        //     ans = pq.poll();
        //     k--;
        // }

        // return ans;

        // NOTE: if you use max heap T.C. : O(n + klogn)
        // for min heap T.C. : O(n + (n-k)logn)  bcz of heapify thing
        // S.C. : O(n)
        // You can select which heap to use if (n-k+1) is smaller then k then use min heap else use max heap
        
        // 2ND APPROACH's VERSION 2 

        if(nums.length-k+1 < k) {  // use min heap
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0; i < nums.length; i++) {
                pq.add(nums[i]);
            }
            int ans = 0;
            k = nums.length-k;
            for(int i = 0; i < k+1; i++) {
                ans = pq.poll();
            }
            return ans;
            
        } else {  // use max heap
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for(int i = 0; i < nums.length; i++) {
                pq.add(nums[i]);
            }
            int ans = 0;
            while(k != 0) {
                ans = pq.poll();
                k--;
            }

            return ans; //  T.C. : O(n*log(k)) in worst case  S.C. : O(n)
        }
//-----------------------------------------------------------------------------------------//
        // THIRD APPRAOCH : USING "QUICK SELECT ALGORITHM" (see SortingRecursion folder to know how this algo works)

            // return quickSelect(nums, 0, nums.length-1, k);
            // best & avg. case T.C. : O(n) worst case : O(n^2)  ; S.C. : O(1)
    }
    // private static int quickSelect(int[] nums, int left, int right, int k) {
    //     if(left == right) {
    //         return nums[left];
    //     }
    //     int i = left;  // this would be the pivot idx
    //     int pivot = nums[right];  // initially taking pivot as last element
    //     for(int j = left; j < right; j++) {  // note < right means we are skipping last(pivot element).  (also start loop from left)
    //         if (nums[j] < pivot) {  // swap (only take smaller than not <= bcz time compl. increases in swapping)
    //             int temp = nums[i];
    //             nums[i] = nums[j];
    //             nums[j] = temp;
    //             i++;
    //         }
    //     }
    //     // swapping pivot to its correct idx
    //     int temp = nums[right];
    //     nums[right] = nums[i];
    //     nums[i] = temp;

    //     int KthLargestIdx = nums.length-k;   // draw the array when it got fully sorted and then calculate this formula this is our kth largest element's idx
    //     if(i > KthLargestIdx) {  // then search left
    //         return quickSelect(nums, left, i-1, k);
    //     } else if(i < KthLargestIdx) {  // then search right
    //         return quickSelect(nums, i+1, right, k);
    //     } else {  // when pivotIdx == KthLargestIdx ("i" will be pointing to the kth largest element)
    //         return nums[i];
    //     }

    //     //the recursive approach was failing for last test case or all test cases got passed but 
    //     //still showing taking much time. So I designed the iterative aglo for the same. Somehow it
    //     //got accepted but the the time comp. is very poor so I think we should not use this approach
    //     //for this ques. bcz the larger testcases are designed in such a way that this algo got worst case O(n^2). 
    //     // Eg: {1,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,.......,1,1,1,-3,-2,-1} len = 1 lakh.
    // }
}
// Note: kth smallest element can also be asked solve that too. 