
/*
Heap Data Structure:
We visualise heap data structe as a complete binary tree.

A binary heap is a complete binary tree where each node has a value that is greater than or equal to (for a max heap) or
less than or equal to (for a min heap) the values of its children. In Java, you can implement a binary heap using the 
PriorityQueue class, which is available in the Java Collections Framework.
 */
/* While implementing the heap data structure we visualise the list of elements in array or arrayList as binary tree. 
there are two types of heaps min heap and max heap. In min heap all childs of any node should be greater than it. And for the implementation of max heap all childs of any node should be smaller than the it. */
/*
A heap is often referred to as a priority queue. A heap is a data structure that allows you to efficiently insert elements and remove the element with the highest (or lowest) priority. 
Priority queues are commonly implemented using heaps because heaps provide efficient operations(log(n) for maintaining the highest (or lowest) priority element at the root of the data structure.
 */
package Heap_PriorityQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;      // data member

    public Heap() {                 //constructor
        list = new ArrayList<>();
    }

    // swap 
    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    // to find parent of any node (draw the tree on pen and paper to understand what is happening) 
    private int parent(int index) {
        return (index-1)/2;    // returns the index of parent node
    }
    
    // to find child of any node (left and right child)
    private int left(int index) {
        return 2*index + 1;      // returns the index of left child node
    }

    private int right(int index) {
        return 2*index + 2;     // returns the index of right child node
    }

    // insertion           (inserting an item takes log(n) time) 
    public void insert(T value) {
        list.add(value);
        upheap(list.size()-1);    // means go up side of the tree and perform certain task
    }
    private void upheap(int index) {
        if(index == 0) {
            return;
        }

        int parentIndex = parent(index);
        if(list.get(index).compareTo(list.get(parentIndex)) < 0) {
            swap(parentIndex, index);
            upheap(parentIndex);
        }
    }

    // removal       (removing one item takes log(n) time)
    public T remove() throws Exception {
        if(list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }

        T temp = list.get(0);   // we have to return what we just removed
        T last = list.remove(list.size()-1);  // remove the last element and after that put it in place of removed item at 0th index
        if(!list.isEmpty()) {
            list.set(0, last);
            downheap(0);        // go down side of the tree and do certain task
        }

        return temp;
    }
    private void downheap(int index) {
        int min = index;   // this index basically you can call it rootNodeIndex (different for different children as each node somewhere is a parent of its left and right child if they exist)
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }
        // after these two ifs we will get the lowest among the parent and its left and right if exist and thats what we want now parent will be swapped with the smallest child if parent(rootNode) itself smallest then no swapping

        if(min != index) {
            swap(min, index);
            downheap(min);
        }
    }


    // heap sort     (simple remove all the items of heap till the heap is empty) O(nlog(n)) bcz n elemnts are removed and removing each element takes logn time
    public ArrayList<T> heapSort() throws Exception {  // return the sorted item in an arrayList
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()) {
            data.add(this.remove());   // as we know 'this' keyword represents the reference of object by which the method is called
        }

        return data;
    }


    // ----------main class---------- //
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        // System.out.println(heap.remove());
        // System.out.println(heap.remove());
        // System.out.println(heap.remove());
        // System.out.println(heap.remove());
        // System.out.println(heap.remove());

        ArrayList<Integer> list = heap.heapSort();   // O(nlog(n))  as discussed above
        System.out.println(list);


        // USING BUILT-IN HEAP/PRIORITY QUEUE WHICH WE ACCESS USING THE 'PriorityQueue<>' class

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // methods applied is same as applies in queue
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(1);
        minHeap.add(8);

        while(!minHeap.isEmpty()) {
            System.out.print(minHeap.poll()+ " ");   // Removing and printing elements in ascending order (min heap property)
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add("apple");
        maxHeap.add("banana");
        maxHeap.add("cherry");

        System.out.println();
        System.out.println("Max Heap (Reverse Order):");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());  // Removing and printing elements in descending order (max heap property)
        }
    }
}

// the heap(data structure) thing which we did is one of the most efficient way to create/implement
// priority queue. There are other ways too like linked list, using only arraylist, using array.
// but these are not as efficient as the priority queue implemented using heap data struc. bcz
// insertion and removal in case of heap is log(n) and others have O(n). (Heap one is imp. remember this only)

// the priority queue thing which we did above is nothing but the implementation of heap data struc. with the

// https://chat.openai.com/share/ffa93100-0496-4c60-b954-f53424e76136

// See the implementation of priority queue using linked list in next file 'PriorityQ_LL'

// note there are other ways too other than smallest and largest thing to set the priority of items
// there are ways in which you yourself can specify the proirity of each item while inserting them.


// To implement the max heap we just need to reverse the signs and your work is done try this. 