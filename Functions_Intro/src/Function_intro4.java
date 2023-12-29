// String type function
public class Function_intro4 {
    public static void main(String[] args) {
        String name = "Anurag";
        String result = greet(name);
        System.out.println(result);
    }

    static String greet(String name) {
        String message = "Hello " + name;
        return message;
    }
}
