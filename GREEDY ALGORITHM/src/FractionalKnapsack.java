
/*
QUESTION : 
Given the weights and values of N items, put these items in a knapsack of capacity W
to get the "maximum total value" in the knapsack.
*/

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] values = {100, 60, 120};
        int[] weights = {20, 10, 30};
        int W = 50;
        // ans : 240

        // Intuition: if we can find out which item is giving us the best value
        // then we can easily figure out the ans.

        // If we become greedy at each step and find out the best item we can figure out the
        // ans easily.
        // For that we can sort the array on the basis of ratio{values/wts} in desc order
        // Remember to maitain relative order so 2d array required

        double[][] ratio = new double[values.length][2];  // {{idx}, {ratio}}

        for(int i = 0; i < values.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = values[i]/(double)weights[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));  // based on raio
        // we want them in desc. order so we can run the loop from end

        // Now we can take the most profitable item completely
        int capacity = W;
        int maxValue = 0;
        for(int i = ratio.length-1; i >= 0; --i) {
            int idx = (int)ratio[i][0];
            if(capacity >= weights[idx]) {   // include full item
                maxValue += values[idx];
                capacity = capacity - weights[idx];
            } else {            // include fraction of item
                maxValue += (capacity * ratio[i][1]);
                break;
            }
        }

        System.out.println("Maximum Value  : " + maxValue);
    }
}
// https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

// Time Complexity : O(nlogn)