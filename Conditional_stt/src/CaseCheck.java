import java.util.Scanner;
public class CaseCheck {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // Creating scanner object
//  Program to check case of first letter
    System.out.println("Enter a word:");
    char ch = sc.next().trim().charAt(0); // trim() here removes all spaces and charAt(0) fn tells the first character from string
//    int ascii = ch;
    if (ch >= 65 && ch <= 90) { // instead of 65 and 90 we can also write 'A' & 'Z' respectively
        System.out.println("Upper case");
    } else {
        System.out.println("Lower case");
    }

    }

}
