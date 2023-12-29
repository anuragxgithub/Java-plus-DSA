package AccessModifier;

public class Main {
    public static void main(String[] args) {
        sub obj = new sub();
        System.out.println(obj.num);

        tuntun object = new tuntun();
        object.printInfo();   //see we can access the default(no modifier/package-private) member inside the same package.

        ten obj2 = new ten();
        System.out.println(obj2.religion); //see we can also access protected member anywhere inside the same package.
    }
}
//To show that public methods,class,constr,var can be accessed from other package too I created a PublicDemo class in
// RandomExp package check it out how import of classes and method work.
//But the class should also be public bcz method is inside it. so we will consider Intro class.
