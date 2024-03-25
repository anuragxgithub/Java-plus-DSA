// Ek choti subtree ka dfs info likhne ke bad we want just bigger subtree present above it to
// write down its dfs info ...
package Trees.TreeQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _8_MorrisTreeTraversals {
    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    static void constructTree(Node root) {
        
        root.left = new Node(2);
        root.right = new Node(3);
        
        root.left.left = new Node(4);
        root.left.left.left = new Node(6);
        root.left.right = new Node(5);
        root.left.right.right = new Node(8);
        root.left.left.right = new Node(9);

        root.right.right = new Node(7);


        /*
                      1
                    /   \
                   2     3
                  / \     \
                 4   5     7
                / \   \
               6   9   8

                 Inorder: [6, 4, 9, 2, 5, 8, 1, 3, 7]
         */
    }

    // ------------------- MORRIS INORDER ------------------- //
    /*
     See we can't use any extra space and we can't do it with recursion too because stack 
     frames take space too. So we do not have any thing to go back once we go down in the
     tree. So this is our first concern we must need to have something which can help
     up going back from where we have come. To traverse other part of tree.
     So in order to achieve that we will create new right ptr for all the node's left (if exist)
     child's rightmost node to the node itself. It will help us going back from where we have
     come. Eg:
     
                      1
                    /   \
                   2     3
                  / \     \
                 4   5     7
                / \   \
               6   9   8

        8 (1's left chlild's rightmost node will point to 1 itself). Similary
        9's right will point to 2
        6's right will point to 4 (bcz 4's left child's rightmost node is 6 itself)
        But why we have chosen this only??
        Bcz in our algo we will do following things:

        1. If left child dosn't exist :  (Means In LNR  L dont exist)
           - note down the data                           so take node
           - move to right                                then go for right

        2. If left child exist :
           i) Left subtree not traversed yet (how to check ?? given below)
              - create the link
              - move to left child itself
           ii) Left subtree already traversed (how to check ?? given below)
              - remove the link               (to make sure tree remain as it was before)
              - note down the data            bcz left already got done added now add N itslef(NLR)
              - move to right                 (time to go for right subtree)
            
        Inorder: [6, 4, 9, 2, 5, 8, 1, 3, 7]
        See here in inorder traversal after node's left child's rightmost node got printed
        node is coming itself thats why we chosen this pointing scheme.
        See after 9 2 is coming and after 8 1 is coming

        DETAILS: 
        If left child exist:
            -> Check if already visited (by checking if we can reach to the root node again
               (cycle)by going right to "its" left child) if Yes. Then don't go left rather go
               right. Remember while moving back to root remove manually created right pointer
               in order to keep the tree as it is (bcz or job is done now).
            -> If not visited (when going right will give null at some point) then create a 
               connection to the "root node" from where left child exist thing got checked so
               that we can go back their in future.
            
     */
    public static void morrisInorder(Node root, List<Integer> ans) {  // LNR
        while(root != null) {
            if(root.left == null) {     // left child don't exist  L
                ans.add(root.data);     // add its value to ans    N
                root = root.right;      //                         R
            } else {                    // left child exist
                Node curr = root.left;
                while(curr.right != null && curr.right != root) {
                  curr = curr.right;  
                }
                if(curr.right == null) {    // 1. left subtree not traversed yet
                    curr.right = root;      // make ptr from rightmost node to the root node so that in future we can trace back
                    root = root.left;       // come to the left child then
                } else {                    // 2. left subtree already traversed(curr.right == root)
                    curr.right = null;
                    ans.add(root.data);     // bcz Left done now Node's time (LNR)
                    root = root.right;      // now go right
                }
                
            }
        }
    }

    // ------------------- MORRIS PREORDER ------------------- //
    /*
     Same pointer thing as Inorder (bcz obviously we need some sort of link so we can use
     same link pattern as we have used in Inorder) will be used only difference here will
     be when we note down the data. Simple.
     1. If left child dosn't exist :  (Means In NLR  L dont exist)
           - note down the data                           so take node
           - move to right                                then go for right

        2. If left child exist :
           i) Left subtree not traversed yet (how to check ?? given below)
              - create the link         
              - note down the data          (only change)
              - move to left child itself
           ii) Left subtree already traversed (how to check ?? given below)
              - remove the link               (to make sure tree remain as it was before)
              - move to right                 (time to go for right subtree)
     */
    public static void morrisPreorder(Node root, ArrayList<Integer> ans) {
        while(root != null) {
            if(root.left == null) {
                ans.add(root.data);
                root = root.right;
            } else {
                Node curr = root.left;
                while(curr.right != null && curr.right != root) {
                    curr = curr.right;
                }
                if(curr.right == null) {  // left subtree not already traversed
                    curr.right = root;
                    ans.add(root.data);    // only change keep adding the left child's value is not already visited
                    root = root.left;
                } else {  // left subtree already visited (curr.right == root)
                    curr.right = null;
                    root = root.right;
                }
            }
        }
    }

    /*
     LRN We can't do it like this but we can do one thing reverse the order to NRL
     and then find out the ans and then reverse the last asn to get LRN.
     Same pointing stuff will be used again but from left side 
     (we will create left ptr to go back to root) only thing will change would be when
     we add item to our ans.
     here we'll check for node's right child's leftmost node
    */
    public static void morrisPostorder(Node root, ArrayList<Integer> ans) { // (NRL)
        while(root != null) {
            if(root.right == null) {
                ans.add(root.data);
                root = root.left;
            } else {
                Node curr = root.right;
                while(curr.left != null && curr.left != root) {  // here we'll check for node's right child's leftmost node 
                    curr = curr.left;
                }
                if(curr.left == null) {  // left subtree not already traversed
                    curr.left = root;    // creating link
                    ans.add(root.data);
                    root = root.right;    // come to right
                } else {  // left subtree already visited (curr.right == root)
                    curr.left = null;
                    root = root.left;
                }
            }
        }
    }


    public static void main(String[] args) {
        // Morris traversal aims to perform DFS in tree in constant time. (Iteratively)
        Node root = new Node(1);
        constructTree(root);

        List<Integer> ans = new ArrayList<>();
        morrisInorder(root, ans);  // https://www.geeksforgeeks.org/problems/inorder-traversal-iterative/1?
        System.out.println(ans);
        
        ArrayList<Integer> ans2 = new ArrayList<>();
        morrisPreorder(root, ans2);  // https://www.geeksforgeeks.org/problems/preorder-traversal-iterative/1?
        System.out.println(ans2);

        ArrayList<Integer> ans3 = new ArrayList<>();
        morrisPostorder(root, ans3);  // https://www.geeksforgeeks.org/problems/postorder-traversal-iterative/1?
        Collections.reverse(ans3);
        System.out.println(ans3);
    }
}