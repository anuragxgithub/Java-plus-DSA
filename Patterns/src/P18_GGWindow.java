// This is most optimised solution u will ever find (My this code used only 6 for loop and on internet every one using 8 loop which is very basic to solve)
// Using 6 loop its lil bit tricky
public class P18_GGWindow {
    public static void main(String[] args) {
        printPattern(7);
    }
    static void printPattern(int n) {
        for (int row = n; row >= 1; row--) {
           for (int col = 1; col <= row*2; col++) {
               System.out.print("*");
               if(col==(row*2)/2 && row <n) {   // && b/z pahle line wale ke liye spaces nhi chahiye
                   for (int spaces = 1; spaces <= (n-row)*2; spaces++) {
                       System.out.print(" ");
                   }
               }
           }
            System.out.println();
        }
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row*2; col++) {
                System.out.print("*");
                if(col==(row*2)/2 && row<n) {
                    for (int spaces = 1; spaces <= (n-row)*2; spaces++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
