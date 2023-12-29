package ObjectCloning;
//Here we will talk about object cloning. As we know we can copy/clone objects using copy constructor.
//but it has a problem like it will take comparatively more time when cloning bigger(arrays) or even
//smaller data.
//We can clone the object in efficient way using cloneable interface. but it also has lil bit con that
//we have to bring more change the syntax of our code as to handle the exceptions.
public class Human implements Cloneable {
    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

//    public Human(Human obj)  {   //Copy constructor.  (takes object of same class as arg which is already created.)
//                                 //obj is of type human(reference variable(points objects of given class))
//        this.age = obj.age;
//        this.name = obj.name;
//    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //it can throw exception that why we have to handle it by adding the signature to the method using throws keyword.
    }

}
// Copy constructor   (Creates a new object by copying the another object of the same class)