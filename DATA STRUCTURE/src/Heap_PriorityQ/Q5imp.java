// https://leetcode.com/problems/sliding-window-maximum/description/
// This is imp. question bcz this type of pattern can come in other questions too.
// https://youtu.be/MCvGwtkqJS0?si=YGBUsG3-0k237H1C
package Heap_PriorityQ;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Deque;

public class Q5imp {
    public static void main(String[] args) {
        int[] arr = new int[] {2,0,3,7,8,6};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
        
    }

    // --------- MY BRUTE FORCE APPROACH: BUT WILL GIVE TLE AT SUBMISSION  Time: O((n-k+1)*k) --------- //

    // public static int[] maxSlidingWindow(int[] nums, int k) {
    //     int i = 0, j = k-1, arrIdx = 0;
    //     int[] result = new int[nums.length-k+1];
    //     while(true) {                                           // O(n-k+1)
    //         int maxIdx = i;
    //         for(int x = i; x <= j && j < nums.length; x++) {    // O(k)
    //             if(nums[x] > nums[maxIdx]) {
    //                 maxIdx = x;
    //             }
    //         }
    //         if(j >= nums.length) {
    //             break;
    //         }
    //         result[arrIdx] = nums[maxIdx];
    //         arrIdx++;
    //         i++;
    //         j++;
    //     }
        
    //     return result;
    // } 

    // --------- GOOD APPROACH Time: O(n*log(k)) Space: O(k)--------- //

    // public static int[] maxSlidingWindow(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // maxHeap 
    //     int[] result = new int[nums.length-k+1];
    //     int i = 0;
    //     for(; i < k; i++) {
    //         pq.add(nums[i]);
    //     }
    //     // first k elements are added. Now find out the largest among them and then remove the first element bcz window will go ahead by one position
    //     result[0] = pq.peek();  // first element would maximum bcz max heap 
    //     pq.remove(nums[0]);     // removing the first element of array(also windows 1st item) from heap
    //     // doing same for the rest of the array
    //     for(; i < nums.length; i++) {
    //         pq.add(nums[i]);        // window moved by one position
    //         result[i-k+1] = pq.peek();
    //         pq.remove(nums[i-k+1]);  // removing windows 1st item
    //     }
    //     return result;
    // }
    // // removal and addition takes log(n) time in heap and in our pq all the time only 3 elements are present so log(k)

    // --------- BEST EFFICIENT APPROACH Time : O(n) Space: O(k) --------- //

    // to understand this approach better first solve this with the PriorityQ approach
    /*
    Approach : simple we will only store the useful elements of the window in the dq like we will remove elements which is not going to be the max. So the peekFirst element would be the maximum of that particular window.
    FOUR STEPS :
    1) check the current element is >= the last element of the dq, if so remove it and remove the smaller elements until the dq got empty or bigger elements met.
    2) then add that element.
    3) check the first element of dq is in range of window or not if not remove it
    4) check if the i is at right position to add elements to our result. Basically right position means i should be >= k at least first window got formed.
     */ 
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        for(int i = 0; i < nums.length; i++) {

            while(!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);  // storing indices

            // checking if old item occur and removing it if occur
            if(dq.getFirst() < i-k+1) {
                dq.removeFirst();        // become old (out of window range)
            }

            // checking i is as correct idx to add items in out result
            if(i >= k-1) {
                result[i-k+1] = nums[dq.getFirst()];
            }
        }
        return result;
        // at most only k elements will be stored in dq at a time bcz we are discarding the older one so space com. O(k)
    }
    
}
