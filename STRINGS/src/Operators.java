import java.util.ArrayList;
public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b'); //Adding the ASCII values
        System.out.println((char)('a' + 3)); //Type casting the ASCII or int value to its relative character.
        System.out.println("a" + "b"); //(Here + operator (with string) concatenate the string.)IMP.
        //--------------//

        System.out.println("a" + 1); //what is happening hare?
        //When int is concatenated with string it first get converted to its Wrapper class (here Integer).
        //now this int becomes object so it will have properties and methods so internally it
        //calls Arrays.toString and gets converted to string.
        //So basically at last it becomes like "a" + "1";

        //-------------//

        System.out.println("Anurag" + new ArrayList<>());
        //Here array list is an object so internally it calls the arrays.toString() and gets converted
        //to string simple and then gets concatenated.
        System.out.println("Anurag" + new Integer(56));
        //Same thing Integer wrapper class is also object.

        //------------//

//        System.out.println(new ArrayList<>() + new Integer(12)); Here it is giving error why?
//        IMPORTANT: b/z in java the '+' operator is only defined for primitives and String only.
//        In order to add these we must have to put atleast one string data type with these non-primitives.
        System.out.println(new ArrayList<>() + "" + new Integer(25)); //No error come as empty string is added.
    }
} //-----ONE MORE IMPORTANT THING-----//
    // OPERATOR OVERLOADING
    /*
    As we know + operator only add values/primitives but here java people give additional functionality
    that it is concatenating the string. This is called operator overloading (similar as fn overloading)
    So here the + we are using is provided by String class by java people
    /
    Operator overloading is not directly supported in Java. It is a feature that allows operators such as "+", "-", "*", "/"
    to be used with custom data types or classes. In other programming languages like C++ or Python, you can define how the
    operators should behave when used with your custom data types.
    However, in Java, the behavior of the operators is already defined for the built-in data types, such as int, float,
    and double. You CANNOT change this behavior.
    For example, the "+" operator adds two numbers in Java. You cannot use it to concatenate strings, even though
    concatenation is a common operation in programming. Instead, you need to use the "+" operator provided by the String class.
    /
    */

