/*
The general syntax of a format specifier is

% [flags] [width] [.precision] [argsize] typechar
You can format other things as well not just precision as here only precision is covered
*/
public class FormatSpecifiers {
    public static void main(String[] args) {
        int x = 5;
        System.out.printf("The number is : %d",x); ////Note: not println or print but (prinf);
        System.out.println();
        float num = 45.2472f;
        System.out.printf("After formatting: %.2f", num); //prints rounded off value till 2 digits.
        System.out.println();
        System.out.printf("%.3f", Math.PI);
//        -------------------------------        //
        System.out.println();
        System.out.printf("My name is %s and I am %s", "Anurag", "Jhand");
    }
}
//Search for the list of format specifiers in java