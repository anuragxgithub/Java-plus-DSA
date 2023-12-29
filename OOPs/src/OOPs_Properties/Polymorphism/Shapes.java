//Polymorphism: 'poly' means many and 'morphism' meaning ways to represent.
//OR The act of representing same thing in multiple ways.
//Polymorphism is a fundamental concept in object-oriented programming that allows objects
//of different classes to be treated as objects of a common superclass.
package OOPs_Properties.Polymorphism;

public class Shapes {
    void area() {
        System.out.println("I am in shapes.");
    }
}

class Circle extends Shapes {
    @Override  //This is annotation will learn more about it in interfaces here this anno. checks whether the method is overriding the method declared in its super class. gives error if the method is not overriding.Not mandatory.
    void area() {
        System.out.println("Area is pi * r * r");
    }
}

class Triangle extends Shapes {
    void area() {
        System.out.println("Area is 0.5 * b * h");
    }
}

class Square extends Shapes {
    @Override
    void area() {
        System.out.println("Area is square of sides");
    }
}
//The above inheritance is hierarchical inheritance.

class Main {
    public static void main(String[] args) {
        Shapes s1 = new Shapes();
        Circle c1 = new Circle();
        Triangle t1 = new Triangle();
        s1.area();
        c1.area();

        //What if:
        Shapes s2 = new Circle(); //Reference variable is of class Shapes but the object is of class Circle.
        s2.area(); //It is printing the method of Circle class. Why?? see below
        //As we know the lhs(declaration) of line 43 is done during the compilation time and the rhs
        //(memory allocation/object creation) happens at the runtime.

        //In Java, the actual type of the object is determined at runtime, based on the object that was
        //instantiated.
        //During compilation, the compiler looks at the type of the reference variable (Shapes in this
        //case) to VALIDATE that the called method exists in the declared class. However, the ACTUAL
        //method executed is determined at runtime based on the type of the object (Circle in this case).
        //This is called run time polymorphism or Method Overriding.



        //There are two types of polymorphism in java:
        //1)Compile Time Polymorphism also called "Method overloading"   (static poly.)
        //2)Run Time Polymorphism also called "Method Overriding"        (dynamic poly.)
        //see Overloading_Overriding.java

    }
}