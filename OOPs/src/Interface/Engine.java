package Interface;
//In Java, an interface is a programming construct that defines a set of methods that a (class) must implement.
//It serves as a blueprint for classes, specifying the methods they must provide without specifying the implementation details.
//In other words, an interface defines what a class should do, but not how it should do it.
//Some Points to note:
//1) declared using the interface keyword, followed by the interface name.
//2) By default, all methods declared in an interface are implicitly public and abstract.⭐⭐⭐ meaning no implementation only declaration of objects allowed.
//3) Interfaces can also declare constant values(int,float), which are implicitly public, static, and final.  i,e does not depend on object.
//4) Unlike classes, which can extend only one superclass, a class in Java can implement multiple interfaces. This enables a class to inherit and provide implementations for multiple sets of behaviors defined by different interfaces.
//5) To implement an interface, a class must use the 'implements' keyword in its class declaration and provide implementations for all the methods defined in the interface. As all methods are implicitly abstract.
//6) Interfaces can extend other interfaces, forming an inheritance hierarchy for interfaces. An interface can inherit method declarations from one or more parent interfaces.
public interface Engine {

    static final int PRICE = 90000; //implicitly it is static and final. that's why static final is blurred saying no need to write.

    void start();
    void stop();
    void acc();  //accelerate
}

interface Brake {
    void brake();
}

interface Media {  //Music Player
    void start();
    void stop();
}

