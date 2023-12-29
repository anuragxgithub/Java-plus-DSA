package AbstractClasses;
//In Java, an abstract class is a class that cannot be instantiated directly, but can serve as a blueprint
//for other classes to inherit from. It is designed to be extended by subclasses, which are expected to
//provide implementations for the ABSTRACT methods defined in the abstract class.
//Abstract classes can be defined using abstract keyword. Basically you can't create objects of abstract classes directly.

//Abstract methods can only be defined inside an abstract class.
//Abstract methods: Abstract methods are the methods without any implementation. Abstract methods are meant to
//be overridden and implemented by the subclasses of the abstract class.
//They are declared with the abstract keyword and do not have a method body.
public abstract class Parent {
    String name;            //you can create variables also
    Parent(String name) {   //We can create constructors in abstract classes.
        this.name = name;
    }

    abstract void career(); //can't have body/implementation bcz abstract.
    abstract void sports();

    //U can't create static abstract methods bcz simple logic static methods can't be overridden.
    //but you can create only static method in abstract classes bcz they are accessed via class reference.
    static void Hello() {
        System.out.println("hey!");
    }
    //Also you can create normal methods in the abstract class
    void Normal() {
        System.out.println("I am normal one."); //⭐but these static and normal are not recommended in abstract classes try to declare only abstract methods.
    }
}

class Son extends Parent {

    Son() {
        super("anurag");
    }
    @Override
    void career() {
        System.out.println("I want to be a doctor.");
    }

    @Override
    void sports() {
        System.out.println("I love playing cricket.");
    }

    //Note: whenever we are extending an abstract class then the subclass must have to override ALL the
    //ABSTRACT methods (not normal one) of patent class and must provide concrete implementation to them.
    //Also. you have to take care of the constructors of the parent class/abstract one bcz constructor is also a fn/method.
}

class Daughter extends Parent {

    Daughter(String name) {
        super(name);
    }

    @Override
    void career() {
        System.out.println("I want to be housewife.");
    }

    @Override
    void sports() {
        System.out.println("I love playing cricket.");
    }

}

//No, you cannot create objects of an abstract class directly in Java. The purpose of an abstract class
//is to serve as a blueprint for other classes to inherit from and provide concrete implementations for
//the abstract methods defined in the abstract class.

//Abstract classes ar just so tanasahi they don't want to do anything only they give order of what they
//want and the subclasses/child classes must have to provide them what they want(implementation) concretely.