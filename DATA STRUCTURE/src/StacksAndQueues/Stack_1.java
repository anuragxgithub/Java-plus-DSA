package StacksAndQueues;

import java.util.Stack;

//Here we will look the stack data structure which is already provided by the java collections.
public class Stack_1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(14);
        stack.push(6);
        stack.push(8);
        stack.push(5);
        stack.push(3);
        //if u see internal implementation of push it is return the added item so you can do this
        System.out.println(stack.push(99));

        System.out.println(stack.peek());   //return what is at the top of the stack(last item)

        System.out.println(stack.pop()); 
        //whenever we pop/del any element from the stack the value  of that item is retured.
        System.out.println(stack.pop()); 
        System.out.println(stack.pop()); 
        System.out.println(stack.pop()); 
        System.out.println(stack.pop());
        //STACKS FOLLOW LIFO
        //INTERNALLY IT IS IMPLEMENTED USING ARRAYS

    }
}
