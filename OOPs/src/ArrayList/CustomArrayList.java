//As we know we are already provided with ArrayList class through which we can use ArrayList
// by Creating object of that class ArrayList<> list = new ArrayList.
//Here we will implement our own ArrayList. creating add(), remove, and other operations for it.
package ArrayList;

import java.util.Arrays;

public class CustomArrayList {
    private int[] data;   //This is our array where we store the elements.
    private static int DEFAULT_SIZE = 10;
    private int size = 0;   //current size of the array.

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];  //here we did the initialisation of our array
    }

    //add operation
    public void add(int num) {
        if(isFull()) {
            resize();
        }
        data[size++] = num;  //first add at size and then increase the value of size by 1.
    }

    private void resize() {
        int[] temp = new int[DEFAULT_SIZE * 2];  //If the array got full its size get doubled this is how arraylist is implemented internally by default.
        //copy the elements of previous array into the new one.
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return data.length == size;
    }

    //remove method. Takes index number and remove the elements from there.
    public void remove(int index) {
        if(index >= 0 && index < data.length) {
            while(index+1 != data.length) {
                data[index] = data[index+1];
                index++;
            }
            data[index] = 0;
            size--;
        } else {
            System.out.println("IndexOutOfBound");
        }
    }

    //get method for get operation. give value at given index
    public int get(int index) {
        return data[index];
    }

    // size method to get the size of the arrayList
    public int size() {
        return size;
    }

    //set method to set the give value at a given index
    public void set(int index, int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(12); list.add(34); list.add(88); list.add(32); list.add(56);
        list.add(13); list.add(44); list.add(4); list.add(848); list.add(3); list.add(8);
        //NOTE: NOW here we can't print the list directly because it is an object.
        //We know how we can directly print the objects: by  override the toString method see line 67 ⭐⭐ already covered.
        System.out.println(list);  //now we can print it. but output will be according to the overridden to string method's implementation we can change it too.
        //methods body.
        list.remove(4);
        System.out.println(list);

        System.out.println(list.get(4));
        list.set(2,99);
        System.out.println(list);
        System.out.println(list.size());

        //PROBLEMS WITH OUR CUSTOM ARRAYLIST:
        //1)If we define the in-built ArrayList list = new ArrayList(); like thing without specifying its type(using generics) it will let us add
        //values of any type but our CustomArrayList only takes Integer value. But not recommended bcz of data type safety.
        //2) We can't reuse our written code for other data types it is restricted to anyone which
        // we already defined. So if there could be a template by using which our implementation single
        // implementation can handle values of different data types.
        //That's where generics come into place.
    }
}
