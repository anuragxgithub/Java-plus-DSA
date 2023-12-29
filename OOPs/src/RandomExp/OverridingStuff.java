package RandomExp;

//OBSERVATIONS : 1) static methods can't be overridden. bcz in simple way.. static method has nothing to
// do with objects but the overriding depends on the object.
//2) static methods can be inherited.
public class OverridingStuff {
    public static void main(String[] args) {
        Triangle t1 = new Circle();
        t1.area();
        //if the overriding happened then it must execute the method of Circle class.
        //but didn't happen that means overriding does not take place.
    }
}

class Triangle  {
    static void area() {
        System.out.println("I am in Triangle Class.");
    }
}

class Circle extends Triangle {
//    @Override   //will give error
    static void area() {
        System.out.println("I am in Circle Class.");
    }
}
