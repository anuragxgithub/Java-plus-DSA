package Heap_PriorityQ; 

import java.util.PriorityQueue;

public class Q3 {
    public static void main(String[] args) {
        long[] arr = new long[] {4, 3, 2, 6}; 

        System.out.println(minCost(arr, arr.length));
    }

    private static long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(long nums : arr) {
            pq.add(nums);
        }
        
        // removing two smallest items from pq and adding them and again sendingn them back to pq
        long cost = 0;
        while(pq.size() > 1) {
            long sum = pq.poll() + pq.poll();
            cost += sum;
            pq.add(sum);
        }
        return cost;
    }
}
