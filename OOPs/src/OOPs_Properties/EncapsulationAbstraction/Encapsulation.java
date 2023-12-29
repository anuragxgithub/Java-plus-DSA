package OOPs_Properties.EncapsulationAbstraction;
// ENCAPSULATION : Encapsulation is the process of bundling/wrapping data and methods together as a single
// unit in a class. It allows internal working and data of a class to be hidden from the other classes,
// basically provides control on how its data can be access or manipulated.
// This is achieved by declaring the class variables as private and providing public methods
// (getters and setters) to access and modify those variables.
public class Encapsulation {
    public static void main(String[] args) {
        Car obj = new Car();
        obj.setMake("Mahindra");
        System.out.println(obj.getMake());
        System.out.println(obj.getModel());

        obj.setYear(1990);
        System.out.println(obj.getYear());
    }
}

class Car {
    private String make;
    private String model;
    private int year;
    //note here I set class vars as private so that they can be protected and hidden from other classes
    //but, I will provide access of them according to me using getter and setter method. This is what
    //encapsulation is.
//The private access modifier is often used to encapsulate implementation details and enforce data hiding.

    public void setMake(String m) {
        this.make = m;
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setYear(int saal) {
        this.year = saal;
    }
    public int getYear() {
        return year;
    }
}
//Encapsulation provides several benefits, such as:
//1) Data hiding 2) Data integrityCode 3)flexibility

//Benefits: It provides data SECURITY, facilitates code maintenance, enhances code reusability, and
//enables flexibility in changing the internal implementation of a class without affecting other parts
//of the program.

//⭐ABSTRACTION : Abstraction is the process of representing complex real world entities as simplified
// models within a program. It focuses on essential features of an object and hides irrelevant details.
//OR
//It is used to hide the unnecessary information or data from the user but shows the essential
//data that is useful for the user
//The best example⭐ of abstraction is a TV remote. The user only interacts with the outer interface
//that is nothing but keys. The user only knows which key to press for what function.

// In Java, abstraction is achieved using abstract classes and interfaces.
//so we will understand more about it when we study interfaces and abstract classes.

//--------------------------------------------------------------------------------------------------------

//Encapsulation vs Abstraction
//Encapsulation deals with the internal working and implementation of data.
//It contains information and provides security.

//Abstraction is more of the external level and design. Here we use interfaces and abstract classes.
//It gains information.
//Abstract Data Types (ADTs) are high-level descriptions of data structures that define the behavior
//and operations that can be performed on them, without specifying the implementation details.

