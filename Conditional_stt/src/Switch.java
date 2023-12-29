import java.util.Scanner;
public class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for English, 2 for Hindi, 3 for French: ");
        int num = sc.nextInt();
        switch(num) {
            case 1 : {
                System.out.println("Hello!");
                System.out.println("Hello");
                int a = 10;
                if (a == 10) {
                    System.out.println("Oh no we can also do it here too.");
                }
                System.out.println(a);
            }
            break;
            case 2 : System.out.println("Namaste!");
            break;
            case 3 : System.out.println("Bonjour!");
            break;
            default: System.out.println("Invalid number!");
        }
    }
}
