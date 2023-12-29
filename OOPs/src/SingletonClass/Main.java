package SingletonClass;

public class Main {
    public static void main(String[] args) {
       //Singleton obj1 = new Singleton();  //we can't do this b/z Singleton() is private in Singleton.java.
        //we can do this instead
        Singleton obj2 = Singleton.getf();
        Singleton obj3 = Singleton.getf();
        Singleton obj4 = Singleton.getf();

        //No matter how many times we call the getInstance() method but the Singleton class will create only
        //one object.
        //all three reference variables are pointing to just one object.
    }

}
