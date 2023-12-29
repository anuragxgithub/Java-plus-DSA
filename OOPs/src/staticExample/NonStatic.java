package staticExample;

public class NonStatic {
    public static void main(String[] args) {
        //as we know we can't access non-static stuff form a static method without referencing their
        //instances in a static context.
        //but we can directly access static or non-static stuff from a non-static method.
        NonStatic obj = new NonStatic();
        obj.fun();    //here we need to refer demo with its object to access it as it is non-static
    }

    void fun() {
        System.out.println("You can access non static stuff from static method via accessing it through object" +
                " reference");
        demo();
        fun2();
    }

    static void demo() {
        System.out.println("You can directly access static method from a non static method");
    }

    void fun2() {
        System.out.println("You can directly access non static method too from a non static method");
    }
}