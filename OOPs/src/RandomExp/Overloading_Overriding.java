//Observation we can have two or more main classes in a file the main() of public class will run first
//from there we can call another main fn but with the object reference.
package RandomExp;
//There are two types of polymorphism in java:
//1)Compile Time Polymorphism also called "Method overloading"   (static poly.)
//2)Run Time Polymorphism also called "Method Overriding"        (dynamic poly.)

public class Overloading_Overriding {
    public static void main(String[] args) {
        Overloading x = new Overloading();
        String[] a = {"anr"};
        x.main(a);
    }
}

class Overloading {
    //1) Method Overloading/Compile Time Polymorphism : refers to the ability of creating methods with same
    //name but with different no. of parameters, different types of parameters or both under the SAME CLASS.

    void cypher() {
        System.out.println("I am good");
    }
    void cypher(int number) {
        System.out.println("Yes");
    }
    void cypher(int number, int age) {

    }
    int cypher(String x) {
        return 0;
    }

    public void main(String[] args) {
        cypher();
    }
}
