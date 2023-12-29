package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
//Here we will look at Queue data structure which is already provided by the java colletions.
//NOTE: STACK IS A CLASS WHEREAS QUEUE IS A INTERFACE
public class Queue_1 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(); //Note here you can't use the Queue interface
        queue.add(12);
        queue.add(13);
        queue.add(17);
        queue.add(14);
        //Note : this add internally return boolean type return true if the element is
        //add to the queue in all above we did't printed the output let's print here:
        System.out.println(queue.add(19));
        

        System.out.println(queue.peek()); //returns the first element or head of the queue do not del it. or null if this queue is empty
        
        System.out.println(queue.poll()); //remove & return the head of the queue, or null if this queue is empty

        System.out.println(queue.remove()); //removes and return the value of the first item
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue);
        queue.add(999);
        queue.add(888);
        System.out.println(queue);
        queue.remove(888);  // will remove the given element from the queue
        System.out.println(queue);



        //NOTE: CTRL + CLICK OR CURSOR ON THE METHODS TO KNOW ABOUT THEM EXACTLY
        //QUEUES ARE INTRNALLY IMPLEMENTED USING LINKED LIST
        //QUEUES FOLLOWS FIFO
           
    }
}