package Interface.NestedInterface;

public class A {
    //nested interface :
    //In Java, a nested interface is an interface that is defined within another class or interface.
    // the nested interface can be declared as public, private or protected. And the top level/normal interface has to be declared public or default(no modifier).
    public interface nestedInterface {
        boolean isOdd(int num);
    }
}

class B implements A.nestedInterface {
    public boolean isOdd(int number) { //Note one thing you can override methods of interfaces but the
        // implementation of methods you provide must be of equal or higher access privilege.
        //remove public from behind boolean u will get what I am conveying.
        return (number & 1) == 1;
    }
}



class Main {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.isOdd(6));
    }
}