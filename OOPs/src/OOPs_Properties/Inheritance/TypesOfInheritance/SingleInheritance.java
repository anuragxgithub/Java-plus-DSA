package OOPs_Properties.Inheritance.TypesOfInheritance;
//In single inheritance, a subclass extends a single superclass.  DONE
//This means that a class can have only one direct superclass. Java supports single inheritance,
//where a subclass inherits the properties and methods of its single superclass.
public class SingleInheritance {
    public static void main(String[] args) {
        Boxx b1 = new Boxx();
        System.out.println(b1.l + " " + b1.b + " " + b1.h);

        boxPrice p1 = new boxPrice(12,32,32,87,399393);
        System.out.println(p1.l + " " + p1.b + " " + p1.h + " " + p1.wt + " " + p1.cost);
        //look how the objects in the subclass inherited the properties of parent class that is why
        //we are able to access those properties in from the object in the subclass.
    }
//Debug them to know how things working EasyPeasy.
}
