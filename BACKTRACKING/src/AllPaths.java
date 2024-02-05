//Here we will we cover all the four directions left, right, up and down.
//But if we simply put 4 conditions only for these 4 directions then the recursion will never end
//hence give stackoverflow error b/z simple logic imagine a path from one point to another if we travel
//again and again the path we already travelled, so the journey will never end we can go back
//and forth again and again.

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        allPaths("", 0,0, maze);
    }

    static void allPaths(String p, int r, int c, boolean[][] maze) {
        if (r == maze.length-1 && c == maze[0].length-1) {  //base condition acts as our target i.e, where we need to go.
            System.out.println(p);
            return;
        }

        if (maze[r][c] == false) {  //condition for obstacle and to prevent going on path which is already covered in a particular fn. call
            return;
        }
        //In order to prevent the never ending recursion we can mark the path which we travelled in the
        //particular function call... that's why this.
        maze[r][c] = false;

        if (r < maze.length-1) {  //condition for going down
            allPaths(p + 'D', r+1, c, maze);
        }

        if (c < maze[0].length-1) {  //condition for going right
            allPaths(p + 'R', r, c+1, maze);
        }

        if (c > 0) {  //condition for going left
            allPaths(p + 'L', r, c-1, maze);
        }

        if (r > 0) {  //condition for going up
            allPaths(p + 'U', r-1, c, maze);
        }

        //Now as we marked the paths which we travelled during our journey till the destination for the
        //particular fn. call so that we don't overlap and create non ending path,
        //now we take back(remove) the markings we made for that fn. call
        //so that it will not create issues for the next fn. call so while going back(returning)
        //from that particular recursion call, will keep going back by removing the changes we made.

        // So this is the place when the flow of program comes when a particular fn. call will over.
        //as we marked the travelled path(cell) false now it's time to mark it back as true while returning.
        maze[r][c] = true;
    }
}

//So basically this is backtracking, changing/removing all changes made previously when the work is done.
// backtracking is used when there is a lot of decisions is to be made (in combinatorial problems
// or constraint satisfaction problems) so when the decision fails it 'backtracks/backs up' to the
// previous decision point and continues exploring other options.

