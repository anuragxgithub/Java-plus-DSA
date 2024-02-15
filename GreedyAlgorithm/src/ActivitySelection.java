/*
Question:
Your are given n activites with their start and end times. Select the maximum number of 
activites that can be performed by a single person, assuming that a person can only work 
on a single activity at a time. "Activities are sorted according to end time".
start = [10, 12, 20]
end = [20, 25, 30]

Ans : 2 (A0 and A2)

Asked in : Facebook, Stanley Morgan, and more.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end =   {2, 4, 6, 7, 9, 9};

        // since we are given that end is already sorted so we will leverage this 
        // as we don't need to think much our first will end before the others (first one will be the optimum)
        // and also we can check the overlapping based on it. by comparing (nextStart >= previousEnd)

        ArrayList<Integer> ans = new ArrayList<>();
        int activityCount = 1;  // initially taking the first activity
        ans.add(0);
        int prevEnd = end[0];
        for(int i = 1; i < end.length; i++) {
            if(start[i] >= prevEnd) {
                activityCount++;
                ans.add(i);
                prevEnd = end[i];
            }
        }

        for(int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println("\n" + "Activity count : " + activityCount);
        // TIME : O(n)

        // ---------------------------------------------------------------------------------------//
        /*
        Now what if end time (end array) was not sorted ?? 
        It would become difficult to find the solution.
        So what can we do ??
        Ans: Simply sort the end array !! But we can't do this because our order get disturbed/mixed
             that means we need to take care of the relative order(start and end) too. 
             So me can make a 2d array out of the start and end arrays and sort them according to the end column.
            
            So the 2d array will be of n*3
            There will be n rows and 3 cols. 1st col stores the idx 2nd col stored the start time and 3rd col stores the
            end time.
        */
        
        int[] s = {1, 0, 5, 3, 8, 5};  // same as the above but this time shuffled
        int[] e = {2, 6, 9, 4, 9, 7};

        int[][] activities = new int[s.length][3];
        
        for(int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = s[i];
            activities[i][2] = e[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // we are sorting 2d array based on 2nd col

        // now do the same thing
        ArrayList<Integer> a = new ArrayList<>();
        int count = 1;
        a.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i = 0; i < end.length; i++) {
            if(activities[i][1] >= lastEnd) {
                count++;
                a.add(activities[i][0]);  // adding the idx
                lastEnd = activities[i][2];
            }
        }
        for(int i = 0; i < ans.size(); i++) {
            System.out.print("A" + a.get(i) + " ");
        }
        System.out.println("\n" + "Activites count : " + count);
        // TIME : O(nlong)
        // Space : O(n*3)
    } 
}
// https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1