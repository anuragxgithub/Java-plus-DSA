package Interface;
//Now this is overall class for all the classes where I used interfaces.
public class NiceCar {
    private Engine engine; //here the ref variable is of type Class Engine it will use to create objects which will be referenced from the Engine Interface.
    private Media player = new CdPlayer();  //player ref var. is of type Media
    public NiceCar() {   //constructor
        engine = new PowerEngine();
    }

    public NiceCar(Engine eng) {
        this.engine = eng;
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void startMusic() {
        player.start();
    }

    public void stopMusic() {
        player.stop();
    }

    public void upgradeEngine() {
        this.engine = new ElectricEngine();
    }
}
