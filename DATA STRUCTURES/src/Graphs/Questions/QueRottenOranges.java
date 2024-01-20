package Graphs.Questions;


public class QueRottenOranges {
    // static class C {
    //     // represent coordinate
    //     int row;
    //     int col;
    //     int time;

    //     public C(int r, int c, int t) {
    //         this.row = r;
    //         this.col = c;
    //         this.time = t;
    //     }

    // }

    // public static int bfs(int[][] grid, int m, int n) {
    //     Queue<C> q = new LinkedList<>();
    //     boolean[] existingSimul = new boolean[m*n];
    //     int DOBinQ = 0;
    //     for(int i = 0; i < m; i++) {
    //         for(int j = 0; j < n; j++) {
    //             if(grid[i][j] == 2) {
    //                 q.add(new C(i, j, DOBinQ));
    //             }
    //         }
    //     }
    //     DOBinQ++;
    //     int time = 0;
    //     // bfs
    //     while(!q.isEmpty()) {
    //         C curr = q.remove();
    //         int currRow = curr.row;
    //         int currCol = curr.col;
    //         int madeRotten = 0;
    //         for(int[] direction : new int[][] {{-1,0},{0,-1},{0,1},{1,0}}) {
    //             int neigRow = currRow + direction[0];
    //             int neigCol = currCol + direction[1];
    //             if(neigRow >= 0 && neigRow < m && neigCol >= 0 && neigCol < n && 
    //             grid[neigRow][neigCol] == 1) {
    //                 madeRotten++;
    //                 grid[neigRow][neigCol] = 2;
    //                 if(existingSimul[curr.time] == false) {
    //                     DOBinQ++;
    //                 }
    //                 q.add(new C(neigRow, neigCol, DOBinQ));
    //                 if(madeRotten == 1 && !existingSimul[curr.time]) {
    //                     time++;
    //                     existingSimul[curr.time] = true;
    //                 }
    //             }
    //         }
            
    //     }
    //     for(int[] row : grid) {
    //         for(int j = 0; j < n; j++) {
    //             if(row[j] == 1) {
    //                 return -1;
    //             }
    //         }
    //     }
    //     return time;

    // }

    // // Funtion given by leetcode
    // public static int orangesRotting(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     return bfs(grid, m , n);
    // }

    /*
     * The above one is my own implementation it can be optimised little bit and can be done in clear way which is 
     * implemented below
    */
    
    // Funtion given by leetcode
    public static int orangesRotting(int[][] grid) {
        return 0;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}