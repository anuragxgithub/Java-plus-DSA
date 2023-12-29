import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                    {3,47,56,67},
                    {12,4,3,6},
                    {8,33,87},
                    {34,654},
                    };
        int target = 87;
        int[] ans = search(arr, target);
        System.out.println("The index of target is: "+Arrays.toString(ans));
    }
    static int[] search(int[][] arr, int target) {  //format of return value will be an array {row, col}
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {  //individual arrays ka length dega
                if(arr[i][j]==target) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
