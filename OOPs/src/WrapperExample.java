//The wrapper class wraps a value of the primitive type in an object.

public class WrapperExample {
    public static void main(String[] args) {
        //The Integer class wraps a value of the primitive type int in an object.
        Integer num = 10;   // this value of num will be stored in heap as like other objects.
        // now with this num we can perform various operations.


        //Now here you can ask one question that will it change the value in the main fn. if we pass it
        //into a swap method b/z normal primitives value does not change in the main fn after the swap fn.

        //will the Integer class objects can change the value in the main method?? b/z objects are passed
        //by reference so technically it(value wrapped into an object type) should also be changed.
        //Let's see
        Integer a = 10;
        Integer b = 20;

        swap(a, b);
        System.out.println(a + " " + b);
    }

    static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }
    // but what the values didn't got changed in the main method why???
    // b/z these wrapper classes Integer, Float, Double, Long & Short are 'final' class you can check it out
    // by ctrl+click on these classes.
    // but Character & String class is not a final class.

    // NOW what is this final thing ?? basically it is a keyword.
    // final keyword used to make constant which cannot be modified or changed. whether it is a variable, class
    // or method.

    // Learn more about it in the FinalKeyword.java file
    // in this project.
}
