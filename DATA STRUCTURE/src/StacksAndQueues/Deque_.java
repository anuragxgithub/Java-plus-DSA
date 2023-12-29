package StacksAndQueues;

//Deque(pron: deck): is DOUBLE ENDED QUEUE basically it means that we can insert/delete items from
//start and end of queue.  null elements are not allowed in this.

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;


public class Deque_ { //this name to avoid confliction
    public static void main(String[] args) {
        // NOTE: You can use 2 classes that implement the Deque interface and these are: 
        // 1) ArrayDeque class 2 ) LinkedList class.
        Deque<Integer> deque = new ArrayDeque<>();
        
        System.out.println(deque.add(12));  //adds to the tail of the list
        deque.addFirst(16);
        deque.addLast(17);

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.remove());
        deque.add(25);
        System.out.println(deque.getFirst());
        System.out.println(deque);

        Deque<Integer> dq = new LinkedList<>();
        dq.add(12);
        dq.addFirst(45);
        dq.addLast(88);
        System.out.println(dq);


    }    
    //Ctrl + click Deque interface to know what are the methods available to use
}
