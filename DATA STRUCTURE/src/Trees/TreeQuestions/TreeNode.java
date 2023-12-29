package Trees.TreeQuestions;
// HERE JUST CREATED TO DEBUG SOME TREE PROBLEMS WHILE SOLVING IT ON LEETCODE
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        // Creating nodes for the binary tree
        TreeNode root = new TreeNode(1); // Root node with value 1
        TreeNode leftChild = new TreeNode(2); // Left child with value 2
        TreeNode rightChild = new TreeNode(5); // Right child with value 3

        // Connecting nodes to form the binary tree structure
        root.left = leftChild;
        root.right = rightChild;

        // Adding more nodes to the tree if needed
        leftChild.left = new TreeNode(3); // Left child of node 2
        leftChild.right = new TreeNode(4); // Right child of node 2
        // rightChild.left = new TreeNode(6); // Left child of node 3
        rightChild.right = new TreeNode(6); // Right child of node 3

        // Now you have created a binary tree with the following structure:
        //        1
        //       / \
        //      2   5
        //     / \   \
        //    3  4    6

        flattenTree(root);   
        while(root != null) {
            System.out.println(root.val);
            root = root.right;
        }

        
    }

    public static void flattenTree(TreeNode root) {
        if(root == null) {
            return;
        }

        flattenTree(root.left);
        flattenTree(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null; // make the left child null
        
        TreeNode rightmost = root;
        while(rightmost.right != null) {
            rightmost = rightmost.right;
        }

        rightmost.right = temp;
    }


}


