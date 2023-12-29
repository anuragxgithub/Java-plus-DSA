public class SomeStatements {
    //As we studied dot operator is used to access the members(methods, variables, nested classes) of
    //the class.
    //Or you can say that it binds(or associate) the object reference variable(by which you are accessing
    //the members) to the instance variable or method.

    public static void main(String[] args) {
        System.out.println();
        //NOTE: ctrl+click everything we are talking here.
        //Now you can understand that this  System.out.println() statement:
        //here System is a class and out is a variable and println() is a method.

        // PrintStream: It is the data type of the variable out. PrintStream is a class in Java'
        // s standard library that provides methods for writing formatted output to a stream. Similarly InputStream.
        //println() here only when not provided with something, print a new line or terminate the current
        //line you can see that inside it called newLine() method and inside new line method you can see
        //the stuff lol.


        //we can also check why printing only object of the class give certain value. by ctrl+click
        Anything x = new Anything();
        x.name = "Anurag";
        System.out.println(x);   //it is printing certain thing(class name @ and some sort of code) why?
        // ctrl+click here on println method. when you provide it an object internally it will call
        // valueOf method and there you can see what actually happening
        //here obj.toString() method executed that's why we get this output.

        //but what if we add the toString method from String class?
        //now instead of printing random value it will print what is returned to the toString().
        //see this by uncommenting the 42 to 45 line.

    }


}
class Anything {
    String name;

//    @Override
//    public String toString() {
//        return name;
//    }
}
