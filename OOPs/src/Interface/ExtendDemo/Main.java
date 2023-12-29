package Interface.ExtendDemo;

public class Main implements B {
    //see here I implemented methods of both interfaces as A is extending A, B can inherit the methods declarations of A.

    @Override
    public void greet() {

    }

    @Override
    public void fun() {

    }


    public static void main(String[] args) {
        A obj = new Main();   //accessing via ref. var of A type and object of main type.
        obj.wtf();
        //Can also be accessed if you choose to override the default method.
    }
}
