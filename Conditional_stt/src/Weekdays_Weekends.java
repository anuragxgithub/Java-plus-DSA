import java.util.Scanner;

public class Weekdays_Weekends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the day number: ");
        int day_num = sc.nextInt();
//      <------- Enhanced Way ---------->
        switch (day_num) {
            case 1, 2, 3, 4, 5 -> System.out.println("Weekday!");
            case 6, 7 -> System.out.println("Weekend!");
            default -> System.out.println("Enter correct day number");
        }
//        <-------CONVENTIONAL WAY-------->

//        switch (day_num) {
//            case 1:
//            case 2:
//            case 3:
//            case 4:
//            case 5:
//                System.out.println("Weekdays!");
//                break;
//            case 6:
//            case 7:
//                System.out.println("Weekends!");
//            default:
//                System.out.println("Enter correct day number");
//        }
    }
}
