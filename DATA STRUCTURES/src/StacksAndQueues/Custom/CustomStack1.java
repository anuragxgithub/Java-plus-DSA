package StacksAndQueues.Custom;
//Note you can try yourself creating generic Stack data structure.
//Here we handled our excetion our own by creating another file. (StackException)
//HERE WE WILL IMPLEMENT OUR OWN STACK WHICH WILL BE (NON-DYNAMIC i.e, when user does not specify
// the size of the stack it will have its certain size(non-dynamic))

public class CustomStack1 {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack1(int size) {     //constructor
        this.data = new int[size];
    }

    public CustomStack1() {            //constructor
        this(DEFAULT_SIZE);  //as we know this is also used to call the constructor here it is calling the above constructor with one parameter
    }

    //PUSH
    public int push(int value) throws StackException {
        if(isFull()) {
            throw new StackException("Cannot Push as Stack is Full");  //see we implemented our own exception handlation
        }
        ptr++;
        data[ptr] = value;
        return data[ptr];
    }

    //POP
    public int pop() throws StackException {
        if(isEmpty()) {
            throw new StackException("Cannot pop from an Empty Stack");
        }
        // int removed = data[ptr];
        // ptr--;
        // return removed;
        return data[ptr--];    //short way
    }

    //PEEK
    public int peek() throws StackException {
        if(isEmpty()) {
            throw new StackException("Cannot peek from an empty stack");
        }
        return data[ptr];
    }

    private boolean isFull() {
        return ptr == data.length-1;
    }

    private boolean isEmpty() {
        return ptr == -1;
    }


    public static void main(String[] args) throws StackException {
        CustomStack1 s = new CustomStack1(5);
        s.push(12);
        s.push(45);
        s.push(23);
        s.push(78);
        System.out.println(s.push(11));
        // s.push(33); //this will give exception as size is 5 only
        
        System.out.println(s.peek());
        
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        // System.out.println(s.pop());
    }
}
//You can also have display fuction if u want just print the array items