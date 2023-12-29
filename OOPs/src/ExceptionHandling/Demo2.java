package ExceptionHandling;

public class Demo2 {
    public static void main(String[] args) {
        int a = 6;
        int b = 0;
        //Let's see how we can explicitly throw error using throwable keyword.
        try {
            divide(a, b);
        } catch(ArithmeticException e1) {
            System.out.println(e1.getMessage());
        } catch(Exception e2) {  //This will execute if the try block give any other type of exception rather than Arithmetic exception.
            System.out.println("Normal exception");
        }

    }
    // throw Statement: The throw statement is used to explicitly throw an exception from a method or
    // block of code.
    static int divide(int a, int b) throws ArithmeticException {
        if  (b == 0) {
            throw new ArithmeticException("here we can write our message."); //This msg will go to catch block.
        }
        return a/b;
    }
// Note: whenever we explicitly throw exception using throw keyword in any method then the method
// must have exception signature using throws keyword()

    //Note again we are being more precise when we are// using ArithmeticException class instead of
    //Exception class as we here know Arithmetic Exception will come it is good to be precise otherwise we
    //can write only Exception class as it is the parent class.
}

