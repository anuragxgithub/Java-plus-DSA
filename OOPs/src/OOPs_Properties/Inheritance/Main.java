package OOPs_Properties.Inheritance;
//NOTE: obviously parent class can't access the properties of child class(sub/derived class).
public class Main {
    public static void main(String[] args) {
        Box b1 = new Box(4);  //the constructor runs on the basis of parameters provided.
        System.out.println(b1.l + " " + b1.b + " " + b1.h);

        BoxWeight w1 = new BoxWeight();
        System.out.println(w1.h + " " + w1.weight); //look we can use the object of base class in derived class look height is not the property of base class it is inherited.

        //now this time we want to create an object in derived class but in constructor I will pass parameters
        //of parent class(base/super class)
        BoxWeight w2 = new BoxWeight(2,4,6,20);
        System.out.println(w2.l + ", " + w2.b + ", " + w2.h + ", " + w2.weight);

        //Fun here.
        //I created an object in the derived class but the reference variable is of the Parent class.
        Box b2 = new BoxWeight(32,23,55,33);
        System.out.println(b2.l + " " + b2.b + " " + b2.h);
        //Even though the object created is of the BoxWeight class,when you use a reference variable of
        //the parent class to refer to an object of the derived class, you can only access the members
        //(variables and methods) that are present in the parent class.
        //this will be more clear when you see the Polymorphism.

        //what if we reverse this.
//        BoxWeight w3 = new Box();
        //it is giving error why ? bcz if the object is created in parent class it can't initialise
        //the variable in the derived class. But the opposite is true as we saw earlier b/z derived class
        //automatically calls the constructor of parent class.
    }
}
