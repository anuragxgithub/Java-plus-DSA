package ExceptionHandling;
//Custom Exceptions: You can also create your own custom exceptions by ⭐extending the Exception class⭐
//or one of its subclasses. This allows you to define and handle application-specific exceptions.
public class CustomException extends Exception {

    public CustomException(String message) {
        super(message);  //call the constructor of Exception class with the message as argument.
    }

    public static void main(String[] args) {
        String name = "anurag";

        try {
            if (name.equals("anurag")) {
                throw new CustomException("Name is anurag");
            }
        } catch(CustomException e1) {
            System.out.println(e1.getMessage());
        } catch(ArithmeticException e2) {
            System.out.println(e2.getMessage());
        } catch(Exception e3) {
            System.out.println("Any exception");
        }
    }
}
