package StacksAndQueues.Custom;
//HERE WE WILL MAKE A "DYNAMIC STACK" (i.e, size will not be fixed you can add as many items
// as you want like the original only (simple just use the dynamic array))
public class CustomStack2 {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack2() {   //constructor
        this(DEFAULT_SIZE);
    }

    public CustomStack2(int size) {
        this.data = new int[size];
    }

    //Push
    public int push(int value) {
        if(isFull()) {
            ptr++;
            data[ptr] = value;
            return data[ptr];
        }
        ptr++;
        data[ptr] = value;
        return data[ptr];
    }

    //Pop
    public int pop() throws StackException {
        if(isEmpty()) {
            throw new StackException("Cannot pop from an Empty Stack.");
        }
        return data[ptr--];
    }

    //Peek
    public int peek() throws StackException {
        if(isEmpty()) {
            throw new StackException("Cannot peek from an Empty Stack.");
        }
        return data[ptr];
    }

    private boolean isFull() {
        if(ptr == data.length-1) {
            //create a new array with bigger size and copy items
            int[] temp = new int[data.length*2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        return ptr == -1;
    }


    public static void main(String[] args) throws StackException {
        CustomStack2 s = new CustomStack2();
        s.push(14);
        s.push(6);
        s.push(8);
        s.push(5);
        s.push(3);
        s.push(2);
        s.push(7);
        s.push(19);
        s.push(33);
        s.push(12);
        System.out.println(s.push(39));
        s.push(11);  
        //see can add as many as we want

        

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
//You can also have display fuction if u want just print the array items
//Everything is O(1) in time complexity only creating a new array after the current array is full
//is of O(n)