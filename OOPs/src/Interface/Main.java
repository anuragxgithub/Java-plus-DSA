package Interface;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.start();
        c1.acc();
        c1.brake();
        System.out.println(c1.value); //here we can access but what if

        Engine e1 = new Car(); //ref. var is of interface Engine but object is created in Class Car
        //System.out.println(e1.value);
        //Here not accessible bcz we know already that In Java, the actual type of the object is determined at runtime,
        //based on the object that was instantiated. (see polymorphism covered there)

        //Now imp.thing.
        Media m1 = new Car();  //Media var and car's object
        m1.start(); //It is printing about engine but, we are talking here in MediaPlayer context
        //So to solve this we need to create separate classes for the interfaces.

        //So here we go
        NiceCar car1 = new NiceCar();
        car1.start();
        car1.startMusic();
        // both are running the start but 1st one running engine.start()  and 2nd one player.start

        car1.upgradeEngine();
        car1.start();
    }
}
