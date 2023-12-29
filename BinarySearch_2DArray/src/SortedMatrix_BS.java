import java.util.Arrays;
//NOTE: 1)Just know this:  int[][] arr = {{}}; >>Give output 1 for arr.length
//NOTE: 2)See Q) 74 and 240 in leet code i explained it there.
//NOTE: 3)Kunal taught a different approach to this problem lil bit lengthy but efficient.
public class SortedMatrix_BS {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int target = 1;
        int[] ans = sortedArrayBS(arr, target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] sortedArrayBS(int[][] arr, int target) {
        //Condition for if matrix is empty.
        if(arr[0].length == 0) {
            return new int[]{-1,-1};
        }
        int row = 0;
        int col = arr.length-1; //Or arr[0].length for MxN matrix
        while(row < arr.length && col >=0) {
            if(arr[row][col] == target) {
                return new int[]{row,col};
            } else if(arr[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return new int[]{-1,-1};
    }

}
