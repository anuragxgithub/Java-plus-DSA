// Priority queue internally is implemented using heap data structure which we will study ahead.
package Heap_PriorityQ;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // by default lowest items got the most priority  (minHeap) 
        pq.add(8);
        pq.add(6);
        pq.add(4);
        pq.add(8);
        pq.add(5);

        System.out.println(pq);
        pq.remove(8);  // you can remove a specific element from the pq also
        System.out.println(pq);


        while(!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();        // takes O(log(n) why? bcz priority Q. is implemented using Heap Data Structure and removal in heap takes O(log(n))
        }

        // To change the priority to largest element use Comparator.reverseOrder()
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        pq1.add(2);
        pq1.add(4);
        pq1.add(6);
        pq1.add(9);



        while(!pq1.isEmpty()) {
            System.out.print(pq1.peek() + " ");
            pq1.remove();
        }
    }
}
// peek() takes O(1) time obvious thing