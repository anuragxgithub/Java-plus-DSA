/*
https://leetcode.com/problems/surrounded-regions/

See the Os as whole if the connected Os are surrounded by X in all 4 directions replace it with X.

But if the connected Os have any O such that it can't be surrounded by X in all 4 directions then all connected
Os will remain as it is they can't be replaced with X.

Simple Observation:
1. If connected Os have any O which is present at the border then every Os in that grounp will remain as it is
because they can't be surrounded by X in all 4 directions.
2. So simply start with all the border zeros and mark all the zeros connected to it so that we will not replace those
zeros and the remaining zeros which are not marked can be repalced by X bcz they will definitely be surrounded with
X if they are not marked (i.e, no O is from border) 
*/

package Graphs.Questions;

public class ReplaceOtoX {
    public static void dfs(char[][] board, int n, int m, boolean[][] visited, int row, int col) {
        if(row >= 0 && row < n && col >=0 && col < m && !visited[row][col] && 
        board[row][col] == 'O') {
            visited[row][col] = true; // means this '0' can be changes to 'X'
            
            dfs(board, n, m, visited, row-1, col);
            dfs(board, n, m, visited, row, col-1);
            dfs(board, n, m, visited, row+1, col);
            dfs(board, n, m, visited, row, col+1);
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < m; i++) {
            // first row
            if(visited[0][i] == false && board[0][i] == 'O') {
                dfs(board, n, m, visited, 0, i);
            }
            
            // last row
            if(visited[n-1][i] == false && board[n-1][i] == 'O') {
                dfs(board, n, m, visited, n-1, i);
            }
        }
        
        for(int i = 0; i < n; i++) {
            // first col
            if(visited[i][0] == false && board[i][0] == 'O') {
                dfs(board, n, m, visited, i, 0);
            }
            
            // last col
            if(visited[i][m-1] == false && board[i][m-1] == 'O') {
                dfs(board, n, m, visited, i, m-1);
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == true) {  // skip the Os that are marked as true as they can't be changed
                    continue;
                }
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
/*
Time : O(n*m)
Space : O(n*m)
*/