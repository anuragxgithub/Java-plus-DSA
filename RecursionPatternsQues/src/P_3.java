//#Pyramid
public class P_3 {
    public static void main(String[] args) {
        int row = 8;
        printPattern(1, 1, 1, row);
    }
    static void printPattern(int r, int c, int space, int rowEntered) {
        if(r > rowEntered) {
            return;
        }

        if(space <= rowEntered-r) {  //For Spaces
            System.out.print(" ");
            printPattern(r,c,space+1,rowEntered);
        } else if(c <= (r*2)-1) {      //For columns
            System.out.print("*");
            printPattern(r, c + 1, space, rowEntered);
        } else {
            System.out.println();
            printPattern(r+1,1,1,rowEntered);
        }
    }
}
//The program uses a constant amount of memory for each recursive call, as it only stores the values of r, c, space, and rowEntered.
//Overall, the time complexity of the program is O(n^2), and the space complexity is O(n^2).