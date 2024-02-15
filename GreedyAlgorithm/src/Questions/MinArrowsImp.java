package Questions;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowsImp {

    public static int findMinArrowShots(int[][] points) {
        // Intuition : If we can easily find the overlapping horizontal diameter of
        // balloons then it becomes easy to count the "min" arrows req. 

        // If we become greedy and want that we can get the overlapping diameters 
        // at each step then it becomes easy to find out ans in one go.

        // For this we can sort the coordinates on the basis of Xend we can
        // find ans in one go.

        Arrays.sort(points, Comparator.comparingDouble(o -> o[1])); // based on xend
        int arrowCnt = 1;  // bursting the first balloon
        int lastEnd = points[0][1];

        for(int i = 1; i < points.length; i++) {
            if(points[i][0] > lastEnd) {  // nextStart > lastEnd  (context : diameter)
                arrowCnt++;
                lastEnd = points[i][1];
            }
            
        }
        return arrowCnt;
    }


    public static void main(String[] args) {
        int[][] arr = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(arr));
    }
}
    
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
