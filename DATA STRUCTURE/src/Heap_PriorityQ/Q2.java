// https://leetcode.com/problems/k-closest-points-to-origin/
// This problem is really easy but we need to store the index(or somehow to know which point was 
// that after storing its dis Sq in pq) too in the heap/priorityQ so that we can know
// which one has the lowest distance from origin. For that we will create a class Point and store
// will store this point class in the priority queue.

// Distance b/w two point in 2-d plane is calculated using this formula:
// √(x1 - x2)^2 + (y1 - y2)^2) but when we find the distance from origin then this formula reduced
// to √(x^2 + y^2). 
// Also we don't need to calculate the under root we can only store and compare the distance
// square same result will come.
package Heap_PriorityQ;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2 {
    static class Point implements Comparable<Point> {
        int x;      // x coordinate
        int y;      // y coordinate
        int disSq;  // distance sq   x^2 + y^2

        public Point(int x, int y, int disSq) {     // constructor
            this.x = x;
            this.y = y;
            this.disSq = disSq;
        }

        @Override
        public int compareTo(Point p2) {
            return this.disSq - p2.disSq; // comparing obj's disSq property
        }
    }
    public static void main(String[] args) {
        int[][] nums = {{3,3},{5,-1},{-2,4}};

        int[][] ans = kClosest(nums, 2);
        for(int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }

    }

    private static int[][] kClosest(int[][] nums, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();  // min heap
        for(int i = 0; i < nums.length; i++) {
            int disSq = nums[i][0]*nums[i][0] + nums[i][1]*nums[i][1];
            pq.add(new Point(nums[i][0], nums[i][1], disSq));
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            Point p = pq.poll();  // poll will return an object of class Point
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        return result;
    }
}
// This types of question can be asked use the same approach when asking dist of points in
// 2-d planes easy peasy. Use max and min heap accordingly.