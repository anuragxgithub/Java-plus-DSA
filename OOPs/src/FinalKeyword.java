//go WrapperExample.java file

// the final keyword is used to declare a constant or to prevent a variable, method, or class from
// being modified or
//  the final keyword indicates that the variable's value cannot be changed once it has been assigned.
//  This creates a constant variable.
// In java by convention final variables are wr extended.itten in UPPERCASE.

// NOTE: this final keyword guarantees its immutability for only primitive data types. However, when applied
// to an object reference, the final keyword guarantees that the reference itself cannot be changed, meaning it
// cannot be reassigned to refer to a different object. The object itself can still be modified if it is mutable,
// but the reference will remain constant.
public class FinalKeyword {
    public static void main(String[] args) {
        final int NUM = 10;
        //NUM = 22;         // it will give error that you can't assign a value to a final variable.
        System.out.println(NUM);

        //come here after line 41.
        final Demo d1 = new Demo("anurag");    //here final object is created.
        d1.name = "other name";   // u can do this only object is modified its reference is still constant
        //but you can not change the reference of d1 var. like this:
        //d1 = new Demo("Rohit");
        d1.printName();
    }
}

    //and this is why you can't just declare and then initialise the final variable in any class. Eg:
    class B {
        int a;
        //final int RANK;            //this will give error that not initialised
        // but, you can remove this error by initialising it in the constructor only, which means only can be
        // initialised inside this class scope. Check it by creating a constructor. as like other variables nothing new
        //as any variable in class that is not inside any method and only can be declared in any constructor or method but final one only be declared in constructor.
    }


//this is to demonstrate the comment on line 9.
class Demo {
    String name;

    Demo(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(this.name);
    }
}



// When applied to a class, the final keyword prevents the class from being extended by other classes,
// making it effectively "immutable" or "final."