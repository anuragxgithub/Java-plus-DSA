public class MaxIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {12,32,45,65},
                {12,32,43,2,1},
                {1,2,34},
                {1,2,4,5,59,56,23}
        };
        int ans = searchMax(arr);
        System.out.println("Max number is: "+ans);
    }
    // Assuming that array is not empty
    static int searchMax(int[][] arr) {
        int max = arr[0][0]; // Or max = Integer.MIN_VALUE
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] > max) {
                   max = arr[i][j];
                }
            }
        }
        return max;
    }
}
