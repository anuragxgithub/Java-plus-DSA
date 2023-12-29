package Interface;
//See below multiple Inheritance.
public class Car implements Brake, Engine, Media { //see unlike classes we can implement more than one interfaces too. In class. we can extend only one superclass.
    int value = 10;
    //See all the methods are provided their implementations we are doing this by overriding.
    @Override
    public void start() {
        System.out.println("I start engine like a normal car.");
    }

    @Override
    public void stop() {   //Note: that Engine and Media interfaces both have same methods start() and stop() but here we are overriding those so here it will give the same implementation to both the interfaces without error.
        System.out.println("I stop engine like a normal car.");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate engine like a normal car.");
    }

    @Override
    public void brake() {
        System.out.println("I brake like a normal car.");
    }
}
