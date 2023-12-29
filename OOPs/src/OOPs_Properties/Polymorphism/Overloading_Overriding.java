package OOPs_Properties.Polymorphism;
//There are two types of polymorphism in java:
//1)Compile Time Polymorphism also called "Method overloading"   (static poly.)
//2)Run Time Polymorphism also called "Method Overriding"        (dynamic poly.)

public class Overloading_Overriding {
    public static void main(String[] args) {
        Overloading o1 = new Overloading();
        o1.cypher();
        o1.cypher("anurag");
        o1.cypher(23);

        Overriding x1 = new anyclass();
        //As we know the actual type of object is determined during run time. That's why method of
        // anyclass will execute although the reference variable is of the parent class. Already Covered.
        x1.same();
    }
}

class Overloading {
    //1) Method Overloading/Compile Time Polymorphism : refers to the ability to define methods with same
    //name but with different no. of parameters, different types of parameters or both under the SAME CLASS.

    void cypher() {
        System.out.println("I am good");
    }
    void cypher(int number) {
        System.out.println("Yes");
    }
    void cypher(int number, int age) {
        System.out.println("nothing special");
    }
    int cypher(String x) {
        return 0;
    }
    //These are examples of method overloading.
}


class Overriding {
    //2) Run Time Polymorphism/Method Overriding : occurs when the subclass provides its own implementation
    //of method that is already defined in its superclass.
    //OR
    //Method overriding refers to the ability to define the exact same method in the subclass that
    //is already defined in its superclass. (same return type and parameters as the method of superclass).

    void same() {
        System.out.println("I am in class hey.");
    }
}

class anyclass extends Overriding {

    @Override  ////This is annotation will learn more about it in interfaces here this anno. checks whether the method is overriding the method declared in its super class. gives error if the method is not overriding.Not mandatory.
    void same() {
        System.out.println("I am in class anyclass.");
    }
}


//NOTE: Polymorphism does not apply to instance variables.