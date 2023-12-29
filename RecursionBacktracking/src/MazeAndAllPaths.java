//To understand it first check out AllPaths file.
//Here we will take a step variable that will take care of the marking in the matrix/maze of the path
//starting from 1.
//And we will take one more thing and that is a new 2d array initially empty of the same size of our
//maze, obviously.

import java.util.Arrays;

public class MazeAndAllPaths {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];
        mazeAndPath("", 0,0, maze, 1, path);
    }

    static void mazeAndPath(String p, int r, int c, boolean[][] maze, int steps, int[][] path) {
        if (r == maze.length-1 && c == maze[0].length-1) {  //base condition acts as our target i.e, destination.
            path[r][c] = steps; //as this is also a step.
            for(int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();

            return;
        }

        if (maze[r][c] == false) {  //condition for obstacle and to prevent going on path which is already covered in a particular fn. call
            return;
        }
        //In order to prevent the never ending recursion we can mark the path which we travelled in the
        //particular function call... that's why this.
        maze[r][c] = false;
        path[r][c] = steps;


        if (r < maze.length-1) {  //condition for going down
            mazeAndPath(p + 'D', r+1, c, maze, steps+1, path);
        }

        if (c < maze[0].length-1) {  //condition for going right
            mazeAndPath(p + 'R', r, c+1, maze,steps+1, path);
        }

        if (c > 0) {  //condition for going left
            mazeAndPath(p + 'L', r, c-1, maze,steps+1, path);
        }

        if (r > 0) {  //condition for going up
            mazeAndPath(p + 'U', r-1, c, maze,steps+1, path);
        }

        //As we know backtracking thing happens here i.e, undoing things after the work.
        maze[r][c] = true;
        path[r][c] = 0;
    }
}

