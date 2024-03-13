package Trees.TreeQuestions;

import java.util.ArrayList;
import java.util.Stack;

public class _6_IterativeTreeTraversals {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static void populate(TreeNode root) {
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        // root.left.left.right = new TreeNode(4);
        // root.left.left.left = new TreeNode(4);
/* 
                     1
                    / \
                   2   7
                  / \  /
                 3   4 8
                      \
                       5
*/
    }

    // PRE-ORDER TRAVERSAL METHOD 1 (MY OWN IMPLEMENTATION)
    public static void preOrderT(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        System.out.print(root.val + " ");
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            while(node.left != null) {
                stack.add(node.left);
                System.out.print(node.left.val + " ");
                node = node.left;
            }

            TreeNode temp = stack.pop();
            while(temp.right == null && !stack.isEmpty()) {
                temp = stack.pop();
            }
            if(temp.right != null) {
                stack.add(temp.right);
                System.out.print(temp.right.val + " ");
            }
            
        }
        System.out.println();
    }

    // PRE-ORDER TRAVERSAL METHOD 2 Easy
    public static void preOrderT2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.val + " ");

            if(temp.right != null) stack.add(temp.right);  // adding right first bcz LIFO
            if(temp.left != null) stack.add(temp.left);
        }
        System.out.println();
    }
    // ------------------------------------------------------------------------------//

    // POST-ORDER TRAVERSAL (LEFT -> RIGHT -> NODE)
    // lets apply trick to easily solve it. We know we need LRN
    // Can we find NRL and then revesrse the anwser ?? obviously yes!! now it is reduced to same as preOrderT
    public static void postOrderT(TreeNode root, ArrayList<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ans.add(0, temp.val);  // bcz we want reversed

            if(temp.left != null) stack.add(temp.left);  // Adding left first bcz LIFO
            if(temp.right != null) stack.add(temp.right);
        }
    }
    // ------------------------------------------------------------------------------//

    // IN ORDER TRAVERSAL
    // idea is we want elements in this order : (Left -> Node -> Right) 
    // so in stack we will add them in this order : (right -> node -> left)  bcz LIFO
    // each time we add 3 nodes including left, right and curr and we will print those nodes only which is getting visited 2nd time
    public static void inOrderT(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visited = new Stack<>();

        stack.add(root);
        visited.add(false);
        
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            boolean isVisited = visited.pop();
            if(isVisited == true) {   // that means it is already visited once so add in ans
                System.out.print(temp.val + " ");
            } else {  // else bcz if ans is found no need to add any of the 3 nodes otherwise loop got created bcz curr node got added again and again
                // add elements in r , n and l manner
                if(temp.right != null) {
                    stack.add(temp.right);
                    visited.add(false);
                }
                stack.add(temp);
                visited.add(true);
                if(temp.left != null) {
                    stack.add(temp.left);
                    visited.add(false);
                }
            }
            
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        populate(root);

        // Preorder Traversal
        preOrderT(root);
        preOrderT2(root);

        // Postorder Travesal
        ArrayList<Integer> ans = new ArrayList<>();
        postOrderT(root, ans);
        System.out.println(ans);

        // Inorder Travesal
        inOrderT(root);

    }
}