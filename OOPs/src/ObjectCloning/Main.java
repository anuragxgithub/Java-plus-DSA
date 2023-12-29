package ObjectCloning;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human h1 = new Human(23, "AnyName");
//        Human h2 = new Human(h1); //but as told earlier it takes comparatively more time to clone objects.
//        System.out.println(h2.name);

        //Let's clone the object using cloneable interface and clone method. which is comparatively faster.

        Human h3 = (Human)h1.clone();
        System.out.println(h3.name + " " + h3.age);
    }
}
