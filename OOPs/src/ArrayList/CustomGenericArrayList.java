//Here we wll solve the problems which we are facing during the creation of CustomArrayList type problem.
//Generics :  Generics in Java provide a way to create reusable components (classes, interfaces,
//and methods) that can work with different data types while maintaining type safety.
// They allow you to define classes and methods that can be parameterized with types.
/*
The primary goal of generics is to provide compile-time type checking to ensure type safety and eliminate the need for explicit type casting. It helps in writing code that is more generic and reusable, while also enhancing code readability and reducing the chances of runtime errors.
Type Parameters: Generics introduce type parameters, which are placeholders for types that will be provided when the generic class or method is used. Type parameters are represented using angle brackets (<>) and are usually single uppercase letters.
Generic Classes: A generic class is declared by specifying one or more type parameters in its declaration. These type parameters can then be used throughout the class to represent specific types. The type parameters are replaced with actual types(Integer,String,etc) when creating an instance of the generic class.
Generic Methods: Like generic classes, generic methods can also have type parameters. These type parameters can be used in the method's parameter list, return type, or local variables within the method.
*/
package ArrayList;

import java.util.Arrays;

public class CustomGenericArrayList <T> {
    private Object[] data;   //This is our array where we store the elements.
    private static int DEFAULT_SIZE = 10;
    private int size = 0;   //current size of the array.

    public CustomGenericArrayList() {
        this.data = new Object[DEFAULT_SIZE];   //why here and while declaring array above we don't put T we can't put T? This is necessary because Java does not allow directly creating an array of a generic type. However, once the array is created as an Object[], it can be assigned to a variable of type T[].
        //here rhs thing will happen at run time and if we put T instead of Object. then this happens: Since generics in Java use type erasure, the actual type information of the generic type parameter is not available at runtime. During compilation, the compiler performs type erasure, replacing the generic type parameter with its upper bound or with the Object type if no upper bound is specified. This means that at runtime, the array would not have the necessary type information to perform the required type checks, potentially leading to runtime errors.
        //https://chat.openai.com/share/60de7678-b19a-48cf-989f-ac09fbb73118 if not got it check it.
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
        CustomGenericArrayList<Integer> list = new CustomGenericArrayList<>();

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

        //And now if you declare this ArrayList without specifying its type it will let us add
        //and type of value bcz of generics.
        //But not recommended as there will be no type safety then. That's why warning of raw use of parameterized class.
        CustomGenericArrayList list2 = new CustomGenericArrayList();
        list2.add("anurg");
        list2.add(23);
        list2.add('a');
        list2.add(4308.3);
        System.out.println(list2);
        //NOTE: One more thing that :
//      generics do not directly support primitive types as type arguments. When using generics,
//      you can only provide reference types (i.e., classes or interfaces) as type arguments.
//However, Java provides a way to work around this limitation by utilizing their corresponding wrapper
//classes for primitive types. These wrapper classes, such as Integer, Double, Boolean, etc., are
//reference types that encapsulate the corresponding primitive types.

    }
}