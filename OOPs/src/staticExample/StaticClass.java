//Note outer class can't be static as it cannot belong to any other class.
//But the inner classes/nested classes can be static , so when a class is declared as static it means it
//belongs to the enclosing class rather than the instance of enclosing class.

package staticExample;

public class StaticClass {
    static class InnerClass {
        String name;
        //if you don't put static in this class then it means that this class depends on the instances of
        //the outerClass(class that is enclosing it) so you can't access this from a static method.

    }

    public static void main(String[] args) {
        InnerClass c1 = new InnerClass();
        c1.name = "Anurag";
        System.out.println(c1.name);
    }
}