package OOPs_Properties.Inheritance;

//Inheritance enables the creation of new classes based on the existing classes. It allows the derived class
//(subclass) to inherit the properties & behaviour of base class (super class).
//In java, we can inherit properties of base class using the 'extends' keyword.
public class Box {
    double l;
    double b;
    double h;

    Box() {             //Non parameterized constructor
        super();  // (come here after everything else ignore for now) see no error even this Box class does not have super/parent class b/z Object is its superclass line 75.
        this.l = -1;
        this.b = -1;
        this.h = -1;
    }

    //cube
    Box(double side) {   //Parameterized constructor
        this.l = side;
        this.b = side;
        this.h = side;
    }

    Box(double len, double br, double he) {      //Parameterized constructor
        this.l = len;
        this.b = br;
        this.h = he;
    }

    Box(Box obj) {   //Copy constructor, remember when variable is written with class name then it is used to create object.
        this.l = obj.l;
        this.b = obj.b;
        this.h = obj.h;
    }

    public void printInfo() {
        System.out.println("I am in box.");
    }

}

class BoxWeight extends Box {  //here BoxWeight is inheriting the properties of Box as it is extended by it.
    double weight;

    BoxWeight() {
        this.weight = -1;
        this.l = 23;
    }

    public BoxWeight(double len, double br, double he, double weight) {  //This will call the constructor at line 24
        super(len, br, he);  //but what is this?? this calls the parent/super/base class constructor.
        //used to initialise the values in parent class.  ctrl+click the super here.
        this.weight = weight;
    }
}

// super will only refer to just above parent class or immediate parent.
//how will you know that which constructor from the parent class will be called from super simple,
//depends on the no of arguments
//⭐⭐ 'super' keyword : We can use super keyword to access the data member or field of parent class.
// It is used if parent class and child class have same fields. Eg:
/*
class Animal{
String color="white";
}
class Dog extends Animal{
String color="black";
void printColor(){
System.out.println(color);//prints color of Dog class
System.out.println(super.color);//prints color of Animal class
} }
*/
//⭐⭐ super() : can be used to call parent class' constructors only. Also,
//                call to 'super()' must be first statement in constructor body

//Detail coverage : in java by default (internal implementation) is that every class will have
//Object as its super/parent class. ctrl + click on super() line 12 inside any class which does not have a super class
//or parent class.

