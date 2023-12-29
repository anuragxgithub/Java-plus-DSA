//Here we will cover CONSTRUCTORS all the explanations are in the notes in notepad.
//Constructors in java :   (by the name itself it tells that it is used to construct smthng)
//Constructors are the special type of function/method that is used to initialize the object of a class.
//It is called when an object is created using new keyword and allocates memory for the object.
//The constructor has same name as class. It does not have a return type, not even void.
public class Oops2 {
    public static void main(String[] args) {
        Student s1 = new Student();    //object named s1 is created
        s1.name = "Anurag Jaiswal";
        s1.age = 19;
        s1.printInfo();

        Student s2 = new Student("Aman Mani", 18);
        s2.printInfo();

        Student s3 = new Student(s2);
        s3.printInfo();
    }
}

class Student {
    String name;     //name is instance variable
    int age;

    public void printInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
    }

    // Non-parameterized constructor
    Student() {   //remember no return type is needed.
        System.out.println("I will be called as soon as the object is created using new keyword.");
    }

    // Parameterized constructor
    Student(String name, int umar) {
        this.name = name;   //IMP. here the LHS name is instance variable and the RHS name is from the method.
        this.age = umar;
    }

    // Copy constructor   (Creates a new object by copying the another object of the same class)
    Student(Student obj) {   //obj here is s2 object as it is provided with it hehe.
        this.name = obj.name;
        this.age = obj.age;
    }
}
// Java allows you to define multiple constructors in the same class, each with a different set
// of parameters. This is known as constructor overloading.
// You cannot create same constructor with same parameters.
// In this code in order to show the three types of constructors I did constructor overloading.
