// Come here after studying Heap implementation and HeapfromArray file. //
/*
 **2 things you should know before doing heap sort** :
 > If you want to sort the array in asc. order create maxHeap.
 > If you want to srot the array in desc. order create minHeap.  

To perform heapsort we have to create a required heap of the given array in place. The elements
in given array would be represented/visulaised as complete binary tree of required heap after 
the array got heapified.
*/
// Here we will build maxHeap bcz we want array to be sorted in ascending order.
package Heap_PriorityQ;

import java.util.Arrays;

public class HeapSort {

    private static void heapSort(int[] arr) {
        // First Step : Build maxheap
        // As we alread know starting from last non-leaf and will heapify all the node by moving in reverse Lv order Tr.
        int startIdx = (arr.length/2) - 1;
        for(int i = startIdx; i >= 0; i--)  {
            heapify(arr, i, arr.length);  // will perform upheap
        }

        // Second Step : Push largest at end(by swapping and heapify the 0th idx)
        int n = arr.length;
        for(int i = n-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);  // (i/size) of array will keep decreasing so tht we can preserve our last items
            // That's how we finished our heap sort which is in-place.
        }
    }
    private static void heapify(int[] arr, int parent, int n) {
        int largest = parent;
        int leftChild = parent*2+1;
        int rightChild = parent*2+2;

        if(leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if(rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if(largest != parent) {
            //swap
            int temp = arr[largest];
            arr[largest] = arr[parent];
            arr[parent] = temp;

            heapify(arr, largest, n);  // cheking down and resolving the nodes if needed
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,8,9,2,3,9,8};

        heapSort(arr);
        System.out.println("SORTED ARRAY AFTER HEAP SORT : ");
        System.out.println(Arrays.toString(arr));
    }
}
// heap sort is an in place sorting algorithm but not as much used / efficient than quick and merge sort. But some time it is needed.
// You should know this algo. bcz can be asked directly in an interview.

// Time Complexity Analysis : 
// heapify() is taking log(n) time bcz in worst case we need to travel the whole height of the tree.
// at line 23 we are calling heapify() n/2 times so building heap takes O(n/2 * logn) --> i.e, O(n*logn)
// at line 29 we are calling heapify() again n times for sorting so it takes O(n*logn)
// Total time complexity is : O(n*logn + n*logn) ->(2n*logn) -> ignoring constants -> [ O(n*logn) ].

// You work is to build an min heap and sorth array in desc. order easy , everything will remain
// same only u need to find minimum element instead of largest.