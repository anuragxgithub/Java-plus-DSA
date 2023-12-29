package staticExample;

// In this demo I will show you how to initialise the static variables.
public class StaticBlock {
    static int a = 4;
    static int b;

    //Note ⭐ This 'static' block will be executed ONLY ONCE when the class is loaded for the first time.
    //it will not be executed for the 2nd , 3rd... time when the staticBlock class is loaded.
    static {
        System.out.println("I am in static block.");
        b = a * 10;
    }

    //we know first main method executes as the StaticBlock is written for creating object then that
    //class will be loaded for first time. and more times when we create more objects.
    public static void main(String[] args) {
        StaticBlock obj = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
        //here we accessed the variables a & b via class reference rather than the object ref.
        //bcz they are static and for static it is convention you already know.

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock obj2 = new StaticBlock();  //class will be loaded for the 2nd time.
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

    }
}
