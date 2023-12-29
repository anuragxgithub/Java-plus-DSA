import java.util.Scanner;
//Void type function
public class Function_intro2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        printName(name);   //Fn call
    }
    //Fn definition
    static void printName(String name) { // Eg. of fn with arguments
        System.out.println("Your name is :" + name);
//      return;  You can write this or ignore this basically telling that return from here(not returning anything)
    }
}
