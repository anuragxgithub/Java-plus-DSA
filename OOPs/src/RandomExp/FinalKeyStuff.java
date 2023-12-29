/*
Using final with Inheritance:

The keyword final has three uses:

# First, it can be used to create the equivalent of a named constant.

# Using final to Prevent Overriding:
To disallow a method from being overridden, specify final as a modifier at the start of its declaration.
Methods declared as final cannot be overridden.
Methods declared as final can sometimes provide a performance enhancement: The compiler is free to inline calls to them
because it “knows” they will not be overridden by a subclass. When a small final method is called, often the Java
compiler can copy the bytecode for the subroutine directly inline with the compiled code of the calling method, thus
eliminating the costly overhead associated with a method call. Inlining is an option only with final methods.
Normally, Java resolves calls to methods dynamically, at run time. This is called late binding. However, since final
methods cannot be overridden, a call to one can be resolved at compile time. This is called early binding.

# Using final to Prevent Inheritance:
Sometimes you will want to prevent a class from being inherited. To do this, precede the class declaration with final.
NOTE: Declaring a class as final implicitly declares all of its methods as final, too.
As you might expect, it is illegal to declare a class as both abstract and final since an abstract class is incomplete
by itself & relies upon its subclasses to provide complete implementations.
 */
package RandomExp;

public class FinalKeyStuff {

}

final class KeepGrinding {
    //class implementation
}

//class StayFocused extends KeepGrinding {    //see here it is giving error.
//    //class implementation
//}

class matrix {
    final void methodName(){

    }
}

//class free extends matrix {
//    void methodName() {     //here giving error that final method can't be overridden.
//
//    }
//}

