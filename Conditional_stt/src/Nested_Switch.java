import java.util.Scanner;

public class Nested_Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the department name: ");
        String department = sc.nextLine();
        System.out.print("Enter employee number: ");
        int empNo = sc.nextInt();
//    <----CONVENTIONAL WAY------->

        switch (empNo) {
            case 1:
                System.out.println("Employee number 1");
                break;
            case 2:
                System.out.println("Employee number 2");
                break;
            case 3:
                System.out.println("Employee number 3");
                switch (department) {
                    case "Management":
                        System.out.println("Management Department");
                        break;
                    case "IT":
                        System.out.println("IT Department");
                        break;
                    default :
                        System.out.println("Enter correct department");
                }
                break;     // Remember this is break statement for 3rd case
            default :
                System.out.println("Enter correct employee number!");
        }
//        <----------ENHANCED WAY------------>

//        switch (empNo) {
//            case 1 -> System.out.println("Employee number 1");
//            case 2 -> System.out.println("Employee number 2");
//            case 3 -> {
//                System.out.println("Employee number 3");
//                switch (department) {
//                    case "Management" -> System.out.println("Management Department");
//                    case "IT" -> System.out.println("IT Department");
//                    default -> System.out.println("Enter correct department");
//                }
//            }
//            default -> System.out.println("Enter correct employee number!");
//        }


    }
}
