package StacksAndQueues.Custom;
//Imagine it properly also use pen and paper.
//HERE WE WILL IMPLEMENT STATIC CIRCULAR QUEUE
public class CircularQueue1 {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;  
    protected int front = 0;  
    private int size = 0;

    public CircularQueue1(int size) {    //constructor
        this.data = new int[size];
    }

    public CircularQueue1() {            //constructor               
        this(DEFAULT_SIZE);  
    }

    public boolean add(int value) {
        if(isFull()) {
            return false;
        }
        data[end++] = value;
        end = end % data.length;  //so that we can add the elements after a round again at initial indices if there is spaace(free space will be created when any item got removed)
        size++;
        return true;
    }

    public int remove() throws QueueException {
        if(isEmpty()) {
            throw new QueueException("Cannot remove from an Empty Queue");
        }

        int removed = data[front];
        front++;   // yes element is not actually removed only pointer is incremented no problem. 
        front = front % data.length;
        size--;
        return removed;
    }

    public int peek() throws QueueException { //returns head/1st item of queue
        if(isEmpty()) {
            throw new QueueException("Cannot peek from an Empty Queue");
        }

        return data[front];
    }

    public boolean isFull() {
        return size == data.length; 
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int i = front;
        do {            //this modification bcz sometimes end and front are pointing to same item
            System.out.print(data[i] + " <- ");
            i++;
            i = i % data.length;
        } while(i != end);
        System.out.println("End");
    }

    public static void main(String[] args) throws QueueException {
        CircularQueue1 c = new CircularQueue1(5);
        System.out.println(c.add(1));
        System.out.println(c.add(2));
        System.out.println(c.add(3));
        System.out.println(c.add(4));
        System.out.println(c.add(5));
        
        c.display();

        System.out.println(c.remove());
        System.out.println(c.add(6));

        c.display();
    }
}
//HERE PROBLEM IS SOLVED 
//ADDITION OF ITEMS : O(1)
//REMOVAL OF ITEMS : O(1)