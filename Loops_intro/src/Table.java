import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creating scanner object
        System.out.println("Enter the number");
        int num = sc.nextInt();
        System.out.println("Table of "+num+ " is:");
        for(int i = 1; i<=10; i++) {
            System.out.println(num + "x" + i + "=" + (i*num));
        }
    }
}
