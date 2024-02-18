/*
https://leetcode.com/problems/find-the-winner-of-the-circular-game/

IMPORTANT QUESTION, SHOWS HOW BEAUTIFUL RECURSION IS.

---------------- EXPLANATION FOR OPTIMISED APPROACH (USING RECURSION)-----------------------
NOTE: AFTER ONE PERSON IS DEAD NOTHING IS GOING TO CHANGE, NUMBERING OF OTHER PLAYERS WILL REMAIN SAME

THE IDEA OF IMPLEMENTING THIS ALGO IS BASICALLY WE ARE ESTABLISHING THE RELATIONSHIP BETWEEN WHAT
WILL ACTUALLY HAPPEN AND WHAT RECURSION WILL. WE WILL USE THIS RELATION AND APPLY IT ON THE RECURSION
(BASICALLY MODIFYING WHICH NUMBER IN RECURSION SHOULD REPRESENT WHICH PERSON) we are deriving this
using the current position of the gun in real game vs in our recursion thing.
⭐⭐
Bcz in recursion gun position will remain same on the same person (0th) person so our task is to
relate it to the real game and provide that gun to the player where it should currently belong.
⭐⭐ EasyPeasy  (and we do it by adding k and to maintain circular thing % it by n simple)
 */

package Problems;

public class JosephusProblemIMP {

    // Method 1       Brute Force
    public int winner(int n, int k, boolean[] killed, int idx, int personLeft) {
        // base case
        if(personLeft == 1) {
            for(int i = 0; i < n; i++) {
                if(!killed[i]) return i;
            }
        }

        // find the steps to move from the current alive person
        int steps = (k-1)%personLeft;    // why k-1 bcz we need to include the current person too while moving k steps

        // skip the persons who had already killed don't count them while moving
        while(steps-- > 0) {
            idx = (idx+1) % n;  // idx was at alive person so move it 1 step ahead
            while(killed[idx]) {  // now check whether the current person is already killed if yes then skip him
                idx = (idx+1) % n;
            }
        }
        killed[idx] = true;

        // since our idx is pointing to alive person so let us set it to the next alive person
        while(killed[idx]) {
            idx = (idx+1) % n;
        }
        return winner(n, k, killed, idx, personLeft-1);
    }

    // LC
    public int findTheWinner(int n, int k) {
        return winner(n, k, new boolean[n], 0, n)+1; // bcz we used zero based indexing
        // idx will represent the current alive person after each k steps
    }

// Time Complexity O(n^2)   bcz in the worst case we will travel the whole array in each step
//                            O(n + n + n...)   -> O(n^2)
// Space Complexity O(n + n)  -> O(n)
//    -------------------------------------------------

    // OPTIMISED CODE
    // Method 2 Optimised
    // NOTE THIS IS CODE FOR 0 BASED INDEXING (i.e, counting from 0)
    // TO MAKE IT 1 BASED INDEXING you can either return 1 in base case OR use the same code and in main ans add 1 at last
    public int winner(int n, int k) {
        if(n == 1) return 0;   // bcz 0th guy is left only

        return (winner(n-1, k) + k) % n;
    }
    // Time : O(n)
    // Space : O(n)
}
