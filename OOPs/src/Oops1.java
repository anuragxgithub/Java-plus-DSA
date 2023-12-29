//NOTE: Read the notes I took on Notepad topic OOPs.  (IMP.)
//Function defined under a class is called method.
public class Oops1 {
    public static void main(String[] args) {
        //Objects are created under main function

        Pen pen1 = new Pen();    // Here we created an object pen1

        pen1.color = "blue";     // the dot operator (.) is used to access members of a class, --
        pen1.type = "gel";       //  such as variables, methods, and nested classes.

        pen1.write();           //calling the method inside Pen class via pen1 object

        Pen pen2 = new Pen();

        pen2.color = "red";
        System.out.println(pen2.type);  //note if you access a property of an object whose instance variable
        // is not initialised, then by default it will give null for non-primitives and 0 in case of primitives.

        pen1.printColor();
        pen2.printColor();
    }
}


    // This is how class is created class name must start with capital letter.
    class Pen {
        String color;                //instance variable (see notes) also called field
        String type;                 //instance variable

        public void write() {
            System.out.println("Write Something");
        }

        public void printColor() {
            System.out.println(this.color);   //'this' keyword is the reference to the current instance/object of the class.
            //or u can say that 'this' keyword refers to the object on which the method or constructor is invoked.
        }
    }

    // Every object of a class has some properties and methods. And these two are called the
    // 'data' and 'members' of a class.
    // data means the type of data it is storing so these string int float... of a class is called
    // its data, and members are the functions/methods of the class.