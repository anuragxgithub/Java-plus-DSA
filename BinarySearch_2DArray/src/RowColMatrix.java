import java.util.Arrays;
//See Q) 74 and 240 in leet code i explained it there.(Medium Questions Soo Simple)
//Row Column Matrix is the matrix in which row and columns are sorted.
public class RowColMatrix {
    public static void main(String[] args) {
        int[][] arr = { //Remember 0 - indexed
                {2,5,7,8},
                {3,7,9,10},
                {5,9,12,14},
                {7,15,20,25}
        };
        System.out.println(Arrays.toString(search(arr, 25)));
    }
    //Basically The idea is to eliminate roe or column
    static int[] search(int[][] matrix, int target) {
        int r = 0;               // Same as start and end
        int c = matrix.length-1; // (means last col ka 1st element) // If NxM matrix then c would be matrix[0].length-1; gives length of column
        while (r < matrix.length && c >= 0) { //Row and col. done ghtte ghtte last tak pahuchenge
            if(matrix[r][c] == target) {
                return new int[]{r,c};
            }
            if(matrix[r][c] > target) { //matrix[r][c] represents the max value of this row b/z pointing to last element of row and row is sorted in Asc.
                c--;
            } else {
                r++;
            }
        }
        return new int[]{-1,-1};
    }
}