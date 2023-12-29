import java.util.Scanner;

public class DayName1to7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the day number: ");
        int num = sc.nextInt();
        switch(num) {
            case 1 -> {
                System.out.println("Monday"); // Like if you want multiple statements(in enhanced switch) in any case use curly braces
            }
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Enter valid day number");
        }
    }
}
