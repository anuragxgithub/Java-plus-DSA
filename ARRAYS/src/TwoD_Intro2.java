//No. of Columns is not fixed or different for diff. row
import java.util.Arrays;
public class TwoD_Intro2 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {4,5}, {6,7,8,9}};
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {  // Here the condition part is now becoming clearer( col loop will go till: length of the array at that row)
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

}
