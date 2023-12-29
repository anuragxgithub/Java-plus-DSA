package RandomExp;

import AccessModifier.Intro;

public class PublicDemo {
    public static void main(String[] args) {
        Intro obj = new Intro();
        obj.mitthu();


        Public object = new Public();
        object.printModel();



    }
}
//successfully shown that a public class and a public method can be accessed from any package.

class Public extends Intro {
    Public obj = new Public();
    void printModel() {
        System.out.println(obj.Model); //successfully shown that a protected members can also be accessed
        // from different packages but the class should be the subclass of class where protected member
        // is declared.
    }
}