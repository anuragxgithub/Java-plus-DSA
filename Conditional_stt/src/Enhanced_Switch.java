import java.util.Scanner;

public class Enhanced_Switch {
    public static void main(String[] args) {
        //Describe fruit
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fruit name: ");
        String fruit = sc.next();
        switch (fruit) {
            case "apple" -> System.out.println("Red round fruit"); // No need to put break statement and other benefit is you can use , if you want more than one case. (see the weekdays_Weekends file)
            case "orange" -> System.out.println("Round fruit");
            case "grapes" -> System.out.println("Small fruit");
            case "mango" -> {
                System.out.println("King of fruits");
                System.out.println("See here you can use block too");
                System.out.println("when there are multiple statements you should use block.");
            }
            default -> System.out.println("Enter valid fruit name");
        }

        //<------CONVENTIONAL WAY ------>
//        switch (fruit) {
//            case "apple":
//                System.out.println("Red round fruit");
//                break;
//            case "orange":
//                System.out.println("Round fruit");
//                break;
//            case "grapes":
//                System.out.println("Small fruit");
//                break;
//            case "mango":
//                System.out.println("King of fruits");
//                break;
//            default:
//                System.out.println("Enter valid fruit name");
//        }
    }
}
