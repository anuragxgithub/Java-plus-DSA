import java.util.ArrayList;
import java.util.Scanner;
public class ArrayList_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Syntax:
        // 1: ArrayList<Integer> list = new ArrayList<Integer>();
        // 2: ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        // ArrayList FUNCTIONS

        list.add(1);   // add element at 0th index
        list.add(23);  // add element at 1st index
        list.add(212); // add element at 2nd index
        list.add(432); // add element at 3rd index
        list.add(222); // add element at 4th index
        list.add(432); // add element at 5th index
        list.add(888); // add element at 6th index
        // You can add as many elements to list as you want.

        System.out.println(list.contains(432));
        list.remove(5);
        list.set(0, 88);

        // Input
        for (int i = 0; i < 4; i++) {  //Takes five inputs
            System.out.print("Enter the number to add: ");
            list.add(sc.nextInt());
        }
        //Output Method 1:
        for (int i = 0; i < 4; i++) {
            System.out.println(list.get(i));  // Will print 4 elements from the list
        }
        // Output Method 2:(Simple)
        System.out.println(list);  // Prints the whole list.
    }
}