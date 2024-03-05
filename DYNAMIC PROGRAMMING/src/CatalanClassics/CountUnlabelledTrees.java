/*

LABELLED AND UNLABELLED THING "EXPLAINED":
READ CAREFULLY EVERYTHING IS COVERED ⭐⭐
https://www.geeksforgeeks.org/enumeration-of-binary-trees/

IN SHORT:
Labelled Binary Tree: Binary Tree in wich nodes are labelled (given some name or 
                      identity Eg a,b,etc).
Unlabelled Binary Tree: Binary Tree in wich nodes are not labelled.

NOTE: These are "same" "Unlabelled Binary Tree"  bcz structure is same
    o                 o
  /   \             /   \ 
 o     o           o     o 

------------------------------------------------------
QUESTION 1 : Find the number of "different" unlabelled binary trees which can be formed 
             with given n nodes.

For n = 0, take no node tree will be null.
     null
For n  = 1, there is only one tree
   o

For n  = 2, there are two trees
   o      o
  /        \  
 o          o

For n  = 3, there are five trees
    o      o           o         o      o
   /        \         /  \      /         \
  o          o       o    o     o          o
 /            \                  \        /
o              o                  o      o

The idea is to consider all possible pairs of counts for nodes in left and right subtrees
and multiply the counts for a particular pair. Finally, add the results of all pairs.


SEE THE EXPLANATION FROM THE ABOVE LINK
*/

package CatalanClassics;

public class CountUnlabelledTrees {
    // Memoization
    public static int catalanMemo(int n, Integer[] dp) {
        if(n == 0 || n == 1) return 1;
        if(dp[n] != null) return dp[n];

        int ans = 0;
        for(int i = 0; i <= n-1; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }
        return dp[n] = ans;
    }
    // Tabulation
    public static int catalanTab(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                int leftSubTree = dp[j];
                int rightSubTree = dp[i-j-1];
                dp[i] += leftSubTree * rightSubTree;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Num. of different unlabelled binary trees which can be formed with " + n + " is : " + catalanMemo(n, new Integer[n+1]));
        /*
        The number of Binary Search Trees (BST) with n nodes is also the same as the number 
        of unlabelled trees. The reason for this is simple, in BST also we can make any key
        a root, If the root is i’th key in "sorted order", then i-1 keys can go on one side,
        and (n-i) keys can go on another side.
        */


        /*
        HOW MANY "LABELED" BINARY TREES CAN BE THERE WITH N NODES? 
        To count labeled trees, we can use the above count for unlabelled trees. The idea is
        simple, every unlabelled tree with n nodes can create n! different labeled trees by
        assigning different permutations of labels to all nodes. 
        
        Eg: for n = 2 there is two unlabelled trees:
                         o      o
                        /        \  
                       o          o
        there will be 4 unlabelled trees: (2 * 2!) = 4
        bcz for each unlabelled tress with n nodes there will be n! different labeled by tress
        assigning different permutations of labels to all nodes. 
            1    2    1   2
           /    /      \   \
          2    1        2   1

        */
        int nthCatalan = catalanTab(n);
        System.out.println("Number of different labelled trees with " + n + " nodes is : " + nthCatalan * factorial(n));

    }

    static int factorial(int n) {
        return (n == 0 || n == 1) ? 1 : n * factorial(n-1);
    }
}