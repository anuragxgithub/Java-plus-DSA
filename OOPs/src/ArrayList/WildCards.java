package ArrayList;
//Wildcards: Java generics also support the use of wildcard types, denoted by the ? symbol.
// Wildcards provide flexibility when working with unknown types or when you need to specify certain
// restrictions on the type parameter.
// Let's say you want your type parameter to accept numbers only i,e. float, double, int.. and not other
// types like string. In this case you can use Wildcards.
//
//        Upper Bounded Wildcards: <? extends T> restricts the type to be a subtype of T.
//        Lower Bounded Wildcards: <? super T> restricts the type to be a supertype of T.
//        Unbounded Wildcards: <?> represents an unknown type.
import java.util.Arrays;
import java.util.List;

public class WildCards <T extends Number> {   //class Number is the superclass of platform classes representing numeric values that are convertible to the primitive types: byte, double, float, int, long, and short.So now t allows only these data types.
    private Object[] data;   //This is our array where we store the elements.
    private static int DEFAULT_SIZE = 10;
    private int size = 0;   //current size of the array.


    //Similarly here:
    public void getList(List<? extends Number> list) {
        //do something

    }

    public WildCards() {
        this.data = new Object[DEFAULT_SIZE];
    }

    //Add operation using add method.
    public void add(T num) {   //here we added T bcz IDK now what will the user add which type of data(int,char,float,etc).
        if(isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[DEFAULT_SIZE * 2];
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
    public T get(int index) {
        return (T)(data[index]);  //type casting to T bcz T type of data will be returned (we don't need to specify T will take care.)
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
        //Now see we can declare our Custom ArrayList of ant type without writing different code for each data type.
        WildCards<Integer> list = new WildCards<>();

//        list.add("Anur"); //Look now this will give error as we provided the type of our ArrayList.
        list.add(12); list.add(34); list.add(88); list.add(32); list.add(56);
        list.add(13); list.add(44); list.add(4); list.add(848); list.add(3); list.add(8);

        System.out.println(list);

        list.remove(4);
        System.out.println(list);

        System.out.println(list.get(4));
        list.set(2,99);
        System.out.println(list);
        System.out.println(list.size());

//        WildCards<String> list2 = new WildCards<>();  See string is not allowed now. after restricting the generic class type with wildcards.


    }
}
