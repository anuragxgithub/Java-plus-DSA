package LambdaExpressions;

import java.util.ArrayList;
import java.util.function.Consumer;

//In Java, a lambda expression is a concise way to represent a method as a functional interface.
//It provides a way to write more compact and readable code.
//They are mainly used in conjunction with functional interfaces, which are interfaces that have a
//single abstract method.
/*
Parameters: The parameters represent the inputs to the lambda expression. They can be omitted if the lambda expression doesn't take any parameters, but parentheses must still be present.

Arrow operator (->): The arrow operator separates the parameters from the body of the lambda expression.

Body: The body contains the code that defines the behavior of the lambda expression. It can be a single expression or a block of statements enclosed in curly braces.
Lambda expressions can be assigned to functional interface variables or used directly as method arguments.
*/
public class Lambda {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i+1);
        }
        // Passing as Method Arguments:
        list.forEach((item) -> System.out.println(item*2)); //For each item in List perform item*2.
        //forEach implemented by Consumer class internally. Traversing is possible bcz of the internal
        //implementation withing the Consumer class.
        //Above code can also be implemented as :
        Consumer<Integer> fun = (item) -> System.out.println(item*3);
        list.forEach(fun);
        System.out.println(list);

        //Assigning to Functional Interface Variables: (means interface with only one abstract method)
        Operation sum = (a, b) -> a+b;
        Operation prod = (a, b) -> a*b;
        Operation sub = (a, b) -> a-b;

        Lambda myCalculator = new Lambda();
        System.out.println(myCalculator.operate(5,3,sum));
        System.out.println(myCalculator.operate(7,9,prod));
        System.out.println(myCalculator.operate(5,2,sub));
    }

    private int operate(int a, int b, Operation op) {
        return op.operation(a,b);
    }
}


interface Operation {
    //Remember  By default, all methods declared in an interface are implicitly public and abstract
    int operation(int a, int b);  //since method is in interface its implementation is provided in other class.
}

//NOTE: body of the lambda expression is written in curly braces if their in multiple set of operations
//otherwise directly written in one line.