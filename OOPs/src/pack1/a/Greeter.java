package pack1.a;
//here pack1.a means: this is the package/folder named 'a' inside another folder named pack1

public class Greeter {
    public static void main(String[] args) {
        greet();
    }

     public static void greet() {
        System.out.println("Good Morning!");
    }

    // To use classes from another package in your code, you need to import them using the import statement.
    // for this go in b package.
}
