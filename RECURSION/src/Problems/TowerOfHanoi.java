/*
https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1
 */


package Problems;

public class TowerOfHanoi {

    public static void tohCal(int n, int src, int helper, int dest) {
        if(n==1) {
            System.out.println("move disk " + n + " from rod " +src+ " to rod " + dest);
            return;
        }

        tohCal(n-1, src, dest, helper);
        System.out.println("move disk " + n + " from rod " +src+ " to rod " + dest);
        tohCal(n-1, helper, src, dest);

    }

    public static long toh(int N, int from, int to, int aux) {
        tohCal(N, from, aux, to);
        return (long)Math.pow(2,N)-1;
    }

    public static void main(String[] args) {
        int helper = 2;   // auxiliary rod
        int src = 1;      // source rod
        int to = 3;       // destination rod
        int N = 3;        // number of discs
        System.out.println(toh(N, src, to, helper));
    }
}
