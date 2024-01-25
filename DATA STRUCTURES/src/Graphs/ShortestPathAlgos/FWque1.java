

/*
https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
*/

package Graphs.ShortestPathAlgos;

public class FWque1 {
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == -1) { // edge don't exist (give it some infinity value)
                    matrix[i][j] = (int)(1e9);
                }
                if(i == j) matrix[i][j] = 0;
                // going from current node to itself will take no time (you can ignore this line)
            }
        }
        
        
        // Floyad Warshall Algo
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        /*
        // -ve cyle detection
        for(int i = 0; i < n; i++) {
            if(matrix[i][i] < 0) [      // if distance from current node to currNode becomes<0
                sout"(-ve cycle exist")
            ]
        }
        */
        
        // Now revert the change of giving infinity value back to -1 in case 
        // some values is still infinity
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }

    }
}
/*
Time : O(n^3)
Space Complexity : O(n^2) although we are given with matrix but we are using it so it will be
considered as it takes space.
*/
