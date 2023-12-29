//To use classes from another package in your code, you need to import them using the import statement.
// For example:
// import com.example.otherpackage.OtherClass;

package pack1.b;

import static pack1.a.Greeter.greet;
//here we imported greet method from Greeter class present in another package.
//pack1 is the package inside it there is a package 'a' and inside package a there is a class greeter and inside
//greeter there is a method greet which we imported using the above line. So I hope now you know that this .
//basically represents subfolder/class/method.
//NOTE: this greet method must be public.

public class Message {
    public static void main(String[] args) {
        greet();    //ctrl+click and then u will be redirected there.
    }
}


// NOTE: You don't need to put import statement to import classes which are inside the same package you can
// use them directly.

/*
You can just import the class to use all things inside it. In this code we imported a particular method from
the class. That will look something like this.


package pack1.b;

        import pack1.a.Greeter;  //importing the whole class.


public class Message {
    public static void main(String[] args) {
        Greeter.greet();
    }
}
*/
