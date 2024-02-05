//Now this time we will take the indexing of your 3d array as 0 to n.
//We will take boolean matrix so whenever we encounter false it means it is an obstacle/restriction.
// D -> Down or Vertical  ,  R -> Right or Horizontal
//Taking our destination by default to the most right down corner.
public class PathWithRestrictions {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };
        pathWithRestrictedMaze("", 0,0, maze);
    }

    static void pathWithRestrictedMaze(String p, int r, int c, boolean[][] maze) {
        if(r == maze.length-1 && c == maze[0].length-1) {
            System.out.println(p);
        }

        if(maze[r][c] == false) {  //condition for obstacle/restriction
            return;
        }
        if(r < maze.length-1) {   // Condition for down/vertical
            pathWithRestrictedMaze(p + 'D', r+1, c, maze);
        }
        if(c < maze[0].length-1) {   // Condition for right/horizontal
            pathWithRestrictedMaze(p + 'R', r, c+1, maze);
        }
    }
}
