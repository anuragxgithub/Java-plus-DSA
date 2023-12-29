package Interface.ExtendDemo;

public interface A {
    void fun();

    default void wtf() {   //What is this now?? how can we implement/have a body of a method in interfaces.
        System.out.println("omg");
    }
    //This is because of the default keyword.
//    Default Method in Interface (Java 8 and later):
//    In Java 8 and later versions, the "default" keyword is also used to define default methods in
//    interfaces. A default method is a method that provides a default implementation in an interface.
//    It allows adding new methods to existing interfaces without breaking the implementation of
//    implementing classes.
    //Classes can choose to override it.

    //NOTE: Annotations itself are interface internally.
}


//One more thing you can dine static methods in interfaces as it does not depend on the object.
//and can be accessed via Class reference. Simple logic nothing much.