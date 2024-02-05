//This is only to understand what happens in STACK memory when a fn calls another fn.
//You can check this by debugging
//Any code in java starts by executing main fn so main fn will go first in stack memory
//A fn will be stored in stack only till it gets its result back. i.e, a fn in stack
// will be alive till the fn it called gets terminated.
//Primitives and function calls are stored in stack.
public class Recursion_1 {
    public static void main(String[] args) {
        //print 1,2,3,4,5 numbers by calling a fn once;
        print1(1);
    }
//This code is not using recursion as none of the fns  calling itself.
    static void print1(int n) {
        System.out.println(n);
        print2(2);         //fn calling another fn
    }
    static void print2(int n) {
        System.out.println(n);
        print3(3);        //fn calling another fn
        System.out.println("When fn. call is return then it will be executed"); //IMPORTANT TO NOTE b/z this way fibonacci program executes.
    }
    static void print3(int n) {
        System.out.println(n);
        print4(4);        //fn calling another fn
    }
    static void print4(int n) {
        System.out.println(n);
        print5(5);          //fn calling another fn
    }
    static void print5(int n) {
        System.out.println(n);  //fn not calling any other function
    }
}