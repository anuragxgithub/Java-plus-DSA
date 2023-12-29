package SingletonClass;
// Singleton Class ensures that only one instance/object of the class can be created.

public class Singleton {

    //so now in order to prevent objects being created we must have to restrict the use of constructor b/z
    //everytime the constructor is called a new object is created.

    private Singleton() {  //now here I created private constructor so that no OTHER class anywhere can access it.

    }

    static Singleton instance;  //a variable used to create object of the Singleton class. see line 25

    public static Singleton getf() {
        //check whether only 1 object is created or not.
        if (instance == null) {
            instance = new Singleton();  //here we can access the constructor as we are in the same class.
        }

        return instance;
    }
}
// Two very important thing to note.⭐⭐⭐⭐⭐

// 1) If the variable is declared with the class name that means it is used to create object of that class.
// 2) If the return type of a method in Java is a class, it means that the method is
//    expected to return an instance of that class.
