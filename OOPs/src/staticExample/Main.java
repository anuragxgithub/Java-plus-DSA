//NOTE: As mentioned previously we can use classes that are under same package without importing them.

package staticExample;

public class Main {
    public static void main(String[] args) {
        Human h1 = new Human(18, "anurag", 100, true);
        Human h2 = new Human(19, "rahul", 1000, false);

        System.out.println(h1.name);
        System.out.println(h2.name);
        System.out.println(Human.population);
        System.out.println(Human.population);
    }

    //Also we know that static members can be accessed before any object of its class is created.
    //so without creating the object you can access the population variable see it by commenting line
    //7,8,10&11. Important line to understand why in psvm main method is static.
}
