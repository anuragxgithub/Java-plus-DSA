package AbstractClasses;

public class Main {
    public static void main(String[] args) {
//        Parent obj = new Parent("Anu");  //Look you can't directly create objects(instantiate) of abstract classes.
        //Indirectly u can do that, but you have to override all the methods here to in the block of this Parent obj = new Parent("Anu"){here}

        Son s1 = new Son();
        System.out.println(s1.name);
        s1.career();
        s1.sports();

        Daughter d1 = new Daughter("Kritika");
        System.out.println(d1.name);
        d1.career();
        d1.sports();

        Parent.Hello();  //Accessing static method of abstract class via class reference.
        s1.Normal(); d1.Normal();  //child classes inherited parent class properties and behaviour.
    }
}
