package Trees.TreeQuestions;

// Iterative approach of DFS using stack.
import java.util.Stack;

public class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;

    TreeNode3() {}
    
    TreeNode3(int val) {
        this.val = val;
    }

    TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        // Creating nodes for the binary tree
        TreeNode3 root = new TreeNode3(1); // Root node with value 1
        TreeNode3 leftChild = new TreeNode3(2); // Left child with value 2
        TreeNode3 rightChild = new TreeNode3(5); // Right child with value 3

        // Connecting nodes to form the binary tree structure
        root.left = leftChild;
        root.right = rightChild;

        // Adding more nodes to the tree if needed
        leftChild.left = new TreeNode3(3); // Left child of node 2
        leftChild.right = new TreeNode3(4); // Right child of node 2
        rightChild.left = new TreeNode3(7); // Left child of node 3
        rightChild.right = new TreeNode3(6); // Right child of node 3
        leftChild.right.left = new TreeNode3(8); // Right child of node 2


        // Now you have created a binary tree with the following structure:
        //        1
        //       / \
        //      2   5
        //     / \ / \
        //    3  4 7  6
        //      /
        //     8
        
        dfsIterative(root);

    }

    public static void dfsIterative(TreeNode3 node) {
        if(node == null) {
            return;
        }

        Stack<TreeNode3> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            TreeNode3 removed = stack.pop();
            System.out.print(removed.val + " ");

            if(removed.right != null) {
                stack.push(removed.right);
            }
            if(removed.left != null) {
                stack.push(removed.left);
            }
        }
    }
    // This is pre order traversal.
}
