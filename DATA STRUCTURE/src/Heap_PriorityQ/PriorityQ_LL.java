// Here we implement priority queue using linked list
// first check out the Heap.java file in which we implemented priority queue using heap and
// explained many important concept.

// https://chat.openai.com/share/ffa93100-0496-4c60-b954-f53424e76136
/*
In Java, a priority queue is a data structure that allows you to store a collection of elements with
associated priorities and retrieve them in a way that ensures elements with higher priorities are
dequeued (removed) before elements with lower priorities. Priority queues are often used in
algorithms where elements need to be processed in a specific order based on their priority values.
*/

// NOTE: I IMPLEMENTED THIS PRIORITY QUEUE USING LINKED LIST WITHOUT ANY HELP THIS IS MY OWN
// IMPLEMENTATION ONLY TOOK HELP OF VS CODE :)
package Heap_PriorityQ;

import java.util.ArrayList;

public class PriorityQ_LL<T extends Comparable<T>> {
    private ListNode<T> head;       // data member or field same thing
    

    class ListNode <T extends Comparable<T>> {  // you can use any other letter(eg E) in type parameter of this class instead of T bcz it is overshadowing the T of class outer class, since it is a nested class that is why it is overshadowing if I created the same node class outside the PriorityQ_LL class it won't show this warning.
        private T value;                   // data member
        private ListNode<T> next;       // data member

        public ListNode(T val) {      // parameterized constructor
            this.value = val;
        }

        public ListNode(T val, ListNode<T> next) {       // constructor overloading taking place
            this.value = val;
            this.next = next;
        }
    }

    // insertion  O(n) (add elements accordingly) here priority will be the smallest  
    private void add(T value) {
        if(head == null) {
            ListNode<T> node = new ListNode<>(value);
            head = node;
            return;         // never forget this bro
        }
        ListNode<T> node = new ListNode<>(value);
        
        if(node.value.compareTo(head.value) < 0) {  // if new value is smaller than head we have to update the head in this case
            node.next = head;
            head = node;
            return;
        }
        ListNode<T> temp = head;
        while(temp.next != null) {
            if(node.value.compareTo(temp.next.value) < 0) {
                ListNode<T> tempHold = temp.next;
                temp.next = node;
                node.next = tempHold;
                return;
            }
            temp = temp.next;
        }

        if(temp.next == null) {      // this will execute if the element inserted is the largest
            temp.next = node;
        }
    }

    // removal  O(n)   removing the most prioritzed item first her smallest one
    public T remove() throws Exception {
        if(head == null) {
            throw new Exception("Queue is empty man.");
        }
        T removed = head.value;
        ListNode<T> temp = head.next;
        head.next = null;
        head = temp;
        return removed;
    }

    public ArrayList<T> removeAll() {
        ArrayList<T> list = new ArrayList<>();
        while(head != null) {
            list.add(head.value);
            head = head.next;
        }

        return list;
    }

    
    public static void main(String[] args) throws Exception {
        PriorityQ_LL<Integer> pq = new PriorityQ_LL<>();
        pq.add(23);
        pq.add(21);
        pq.add(25);
        pq.add(29);
        pq.add(-1);
        pq.add(12);
        pq.add(6);

        // System.out.println(pq.remove());
        // System.out.println(pq.remove());
        // System.out.println(pq.remove());
        // System.out.println(pq.remove());
        // System.out.println(pq.remove());
        // System.out.println(pq.remove());
        // System.out.println(pq.remove());

        System.out.println(pq.removeAll()); // make sure there are elements in list otherwise return empty list
    }
   
}

// Note : this is not as efficient as priority queue implemented using heap bcz here insertion
// of one item takes O(n) and for n items it will cost O(n^2) while heap priority q cost O(nlog(n))
// to insert n items. Also removal from q using LL cost O(1) and in q using heap is O(log(n))

// but we still prefer priority queue using heap so this linked list implementation is not that
// important.


// Similarly you can implement pq using ArrayList that will be the easiest one(just keep adding
// items accordingly in list) but it will also take O(n) to insert one item so not efficient.

// {But what if we insert the items using the BinarySearch ?? will it take O(logn time) ??
// this is my own thinking you can think and check about this but no size of arrays are fixed
// we can't efficiently remove items or add new items bcz size can get full}