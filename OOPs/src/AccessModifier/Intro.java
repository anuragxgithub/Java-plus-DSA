package AccessModifier;
//In java there are 4 access modifiers :
//1) public     2) private   3) protected    4)default(also known as package-private)
//see at the bottom for explanations.
public class Intro {
    private String name;
    public int arr[];
    int num;
    protected String Model;
      public void mitthu() {
        System.out.println("I am in mitthu.");
    }
}

class sub extends Intro {
    sub() {
//        this.name = "anurag";    not allowed, although we know that using getter and setter method we can
//                                 allow its access to other classes.
        this.num = 10;
    }
}

class ten {
    protected String religion = "Hindu";
    public void sum() {   //you can access this method from anywhere from any package and class just import it.
        System.out.println("I am in sum");
    }

}

class tuntun {

    ten obj = new ten();
    void printInfo() {
        obj.sum();
        System.out.println(obj.religion);  //see we can access protected member in other class inside same file
    }
}

//1) If a class, method, variable, or constructor is declared as public it can be accessed from any other class and package.

//2) When a class member is declared as private it can only be access within the same class only not even
//   in its subclass. It is the most restrictive one.

//3) When a class member is protected it can be accessed within the same package and can also be accessed
//   from different package if the class is subclass of class where protected member is declared.
//   Only not accessible from diff package & not subclass.

//4) When a class member(class, method, var, constructor) is default(no modifier) it can be accessed within
//   the same package.

//            │ Class │Package│ Subclass│ Subclass │ World
//                    │       │         │(same pkg)│(diff pkg)│(diff pkg & not subclass)
//        ────────────┼───────┼─────────┼──────────┼──────────┼──────────────────────────
//public      │   +   │    +  │    +    │     +    │   +
//        ────────────┼───────┼─────────┼──────────┼──────────┼──────────────────────────
//protected   │   +   │    +  │    +    │     +    │
//        ────────────┼───────┼─────────┼──────────┼──────────┼──────────────────────────
//no modifier │   +   │    +  │    +    │          │
//        ────────────┼───────┼─────────┼──────────┼──────────┼──────────────────────────
//private     │   +   │       │         │          │
