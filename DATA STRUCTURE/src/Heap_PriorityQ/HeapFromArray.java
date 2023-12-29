/*
Here we will build max heap from an unsorted/sorted array.
Max Heap Property : Any node in the complete binary tree should be greater than its children. And
if we observe closely then we can say that the leaf nodes are already following this property. So
we don't need to do anything with leaf nodes.
★★ No of NON-LEAF nodes in the complete binary tree = N/2   (where N is the total no. of nodes)
https://www.geeksforgeeks.org/building-heap-from-array/
*/
package Heap_PriorityQ;


public class HeapFromArray {

    private static void buildHeap(int[] arr, int n) {
        int startIndex = n/2 -1;  // starting index of non-leaf node from the bottom

        // now perform reverse Level Order Traversal from last non-leaf node and heapify each node
        for (int i = startIndex; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    private static void heapify(int[] arr, int rootIndex, int n) {
        // if we can find out which one is largest bw/ the node and its two child(left & right) for
        // each node then the largest one would become parent by swapping.
        int largest = rootIndex;   // initially taking root node as the largest
        int leftChildIdx = rootIndex*2 + 1;
        int rightChildIdx = rootIndex*2 + 2;

        if(leftChildIdx < n && arr[leftChildIdx] > arr[largest]) {
            largest = leftChildIdx;
        }
        if(rightChildIdx < n && arr[rightChildIdx] > arr[largest]) {
            largest = rightChildIdx;
        }
        // after these two ifs we have found our largest item from 2 of them

        //if largest is not root
        if(largest != rootIndex) {
            // swap
            int temp = arr[largest];
            arr[largest] = arr[rootIndex];  // bcz of the max heap property
            arr[rootIndex] = temp;

            // recursively heapify the affected sub tree(by going down)
            heapify(arr, largest, n);     // (largestIdx element which is now swapped, now the element which come here will become next parent and we go down to fix things if needed)

        }
    }

    // prints the array representation of heap
    private static void printHeap(int[] arr) {
        // it will be called after the original array got heapified
        System.out.println("THE ARRAY REPRESENTATION OF MAX HEAP IS :");
        for(int item : arr) {
            System.out.print(item + " ");
        }
    }


    public static void main(String[] args) {
        // Binary Tree Representation
        // of input array
        //            1
        //          /   \
        //        3      5
        //       / \    /  \
        //      4   6  13  10
        //     / \ / \
        //    9  8 15 17
        int[] arr = {1,5,7,8,9,2,3};
        
        buildHeap(arr, arr.length);
        printHeap(arr);

//>>> THE OFFICIAL PROGRAM ENDS HERE AFTER THAT IT IS MY BULL SHIT WHICH IS WAS EXPERIMENTING <<<//
            // Don't even look here before before completing the above part //
        /* note don't expect the array representation of heap in descending order bro lol
        heap is a data structure which is specific implementation of binary heap
        (now if you want it to be in ascending order do heap sort by creating the a remove() 
        method as like we did in heap.java file this is my line).
        now lets do that too
        but wait removal is not that easy in array so I found out un efficient unnecessary approach
        which is given below same approach as we did in heapSort. 
        Another bullshit can be done in other way too using Arrays.copyOfRange() lol
        ignore if this if you want */
        System.out.println();
        // heapSort(arr, arr.length); 
    }

    // static int rc = 0;   // removed count
    // private static int remove(int[] arr, int n) {
    //     // obviously we remove the first element bcz our priority is max element
    //     int removed = arr[0];
    //     // arr = Arrays.copyOfRange(arr, 1, arr.length);
    //     int temp = arr[0];
    //     arr[0] = arr[(n-1)-rc];     // end index
    //     arr[(n-1)-rc] = temp;
    //     rc++;

    //     if((n-1)-rc != 0) {     // check if the array is empty or not
    //         downheap(0, arr.length, arr);        
    //     }
        
    //     return removed;
    // }
    // private static void downheap(int index, int n, int[] arr) {
    //     int max = index;
    //     int left = 2*index +1;
    //     int right = 2*index +2;

    //     if(left < (n-1)-rc && arr[left] > arr[max]) {
    //         max = left;
    //     }

    //     if(right < (n-1)-rc && arr[right] > arr[max]) {
    //         max = right;
    //     }

    //     if(max != index) {
    //         int temp = arr[max];
    //         arr[max] = arr[index];
    //         arr[index] = temp;
    //         downheap(max, n, arr);
    //     }
    // }

    // private static void heapSort(int[] arr, int n) {
    //     while((n-1)-rc >= 0) {
    //         System.out.print(remove(arr, n) + " ");
    //     }
    // }
}
