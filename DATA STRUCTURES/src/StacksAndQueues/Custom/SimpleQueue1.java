//4 TYPES OF QUEUES : 1) SIMPLE   2) DEQUEUE(DOUBLE ENDED)  3) CIRCULAR  4) PRIORITY
package StacksAndQueues.Custom;
//HERE WE WILL IMPLEMENT THE QUEUE USING ARRAY AND WE WILL USE ONLY ONE POINTER TO MAKE IT 
//TOUGH BCZ IN IF WE USE TWO POINTER WHAT WILL BE THE DIIFERNCE THEN IN THIS SIMPLE QUEUE AND DEQUE
//INTERVIEWS USUALLY ONLY ONE POINTER IS GIVEN.
//The queue here will be static i.e, of fixed size. 
public class SimpleQueue1 {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;   //using only one ptr and we will prefer to stay at end bcz we can easily add elements there.

    public SimpleQueue1(int size) {    //constructor
        this.data = new int[size];
    }

    public SimpleQueue1() {            //constructor               
        this(DEFAULT_SIZE);  //we know that this is also used to call the method here it is calling the above constructor with one parameter
    }

    public boolean add(int value) throws QueueException {
        if(isFull()) {
            throw new QueueException("Cannot add to a full Queue");
        }
        data[end++] = value;    //first add at end and then increase the end
        return true;
    }

    public int remove() throws QueueException {
        if(isEmpty()) {
            throw new QueueException("Cannot remove from an Empty Queue");
        }

        int removed = data[0];
        end--;
        //Now shift the elements towards left
        for (int i = 0; i < end; i++) {
            data[i] = data[i+1];
        }
        return removed;
    }

    public int peek() throws QueueException { //returns head/1st item of queue
        if(isEmpty()) {
            throw new QueueException("Cannot peek from an Empty Queue");
        }

        return data[0];
    }

    public boolean isFull() {
        return end == data.length; 
    }

    private boolean isEmpty() {
        return end == 0;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("End");
    }

    public static void main(String[] args) throws QueueException {
        SimpleQueue1 q = new SimpleQueue1();
        System.out.println(q.add(12));
        System.out.println(q.add(13));
        System.out.println(q.add(14));
        System.out.println(q.add(15));
        System.out.println(q.add(16));
        System.out.println(q.add(17));

        q.display();
        System.out.println(q.remove());
        q.display();
    }
}
//Adding takes O(1)
//Removing takes O(n)  due to shifting thing
//TO SOLVE THIS PROBLEM that removing elements take O(n) time Comp. CircularQueue comes into picture.