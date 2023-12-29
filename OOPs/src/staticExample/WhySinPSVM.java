package staticExample;
//Now here we will talk of static methods, so we don't need to go anywhere else the main()
//method which we are using since day 1 is itself a static method. Let's talk about it.

public class WhySinPSVM {
    public static void main(String[] args) {
        // Now as we know without the main() method in java the program will never run.

        // Now what is static method?
        // Simple, just like static variables static methods also belongs to the class itself rather than
        // any specific instance/object of the class.
        // Also, we can access the static methods too without before or without the objects are created.

        // Now why the main() is static ??
        // bcz so that we can access the main method even if there is no object is created for the class in
        // which main method is.   As without main method the program will never run that's why we ensure
        // its working even before the object is created or the object is not created.

        //So overall what I mean is if WhySinPSVM class has objects or not the main method is going to execute.


        //Now after all this lets see why we use to create static methods whenever we used to create
        //user defined fn.
        //The reason is simple b/z main() method is static method, so it will only access/call static
        //methods b/z non-static method depends on object.

        //greeting();    //you can't use this b/z greeting is a non-static method. It depends on object.
        //but the fn in which you are using it does not depend on instances/objects.
        //but there is a way to do it.
        //since the problem is non-static depends on the object so.
        //Only way to access non-static member(var or method) from a static method is to specify the
        //object for the non-static member.Eg:

        //so here I am referencing greeting method with its instance/object.
        WhySinPSVM obj = new WhySinPSVM();
        obj.greeting();     // now we can access it.
        //this is not new we are doing same thing in oops 1 and oops 2.. u know now don't get confused.

    }
    void greeting() {
        System.out.println("hello!");
    }
}
