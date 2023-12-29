package ExceptionHandling;
//Exception handling in Java refers to the mechanism of dealing with runtime errors or exceptional conditions
//that may occur during program execution.
//Help us to recover from errors and prevent our program from terminating abruptly.
/*
Checked Exceptions: These are the exceptions that are checked at compile-time. If a method throws a checked
exception, it must declare it using the throws keyword in its method signature, or the exception must be
caught and handled using a try-catch block. Examples of checked exceptions include IOException, SQLException,
 and ClassNotFoundException.

Unchecked Exceptions: These exceptions are not checked at compile-time, meaning the compiler doesn't enforce
catching or declaring them. They are typically caused by programming errors or exceptional conditions that
are difficult to recover from. Examples of unchecked exceptions include NullPointerException,
ArrayIndexOutOfBoundsException, and ArithmeticException(eg. / by 0).
*/
public class Demo1 {
    public static void main(String[] args) {
        int a = 6;
        int b = 0;

//        System.out.println(a/b); /It will throw ArithmeticException
        //Try catch block explained at bottom.
        try {
            System.out.println(a/b);  //those code which can throw exception are written in try block
        } catch(Exception e1) {
            System.out.println("Exception caught.");
            System.out.println(e1.getMessage());
        }
        finally {   //Optional
            System.out.println("I will always execute no matter exception found or not.");
        }
        System.out.println("---------------------------------------------------------------");


        try {
            divide(a, b);
        } catch(ArithmeticException e2) {  //u can either write ArithmeticException or just Exception as ArithmeticException is subclass of Exception.
            System.out.println(e2.getMessage());
        }

    }

    static int divide(int a, int b) {
        return a/b;  //if inside the catch any exception found it will not print anything rather move to
        //catch to get further assist. bcz if it shows it what's the point in using this

    }
}
//NOTE: ⭐ Exception class is the parent class all the exceptions are its subclass.
//if you put Exception class in catch it will execute on any type of error.


//Try catch block explanation.
//        try {
//              // code that may throw an exception
//        } catch (ExceptionType1 e1) {
//              // exception handling for ExceptionType1
//        } catch (ExceptionType2 e2) {
//              // exception handling for ExceptionType2
//        } finally {
//              // optional finally block
//        }
//try must be used with catch or finally can't be used alone simple logic.

//Exception handling enables you to control the flow of your program in the face of exceptional conditions.