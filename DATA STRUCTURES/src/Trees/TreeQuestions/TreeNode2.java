package Trees.TreeQuestions;
// HERE JUST CREATED TO DEBUG SOME TREE PROBLEMS WHILE SOLVING IT ON LEETCODE
//QUE : (given Path exist or not from root to leaf node)
public class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {}
    
    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        // Creating nodes for the binary tree
        TreeNode2 root = new TreeNode2(1); // Root node with value 1
        TreeNode2 leftChild = new TreeNode2(2); // Left child with value 2
        TreeNode2 rightChild = new TreeNode2(5); // Right child with value 3

        // Connecting nodes to form the binary tree structure
        root.left = leftChild;
        root.right = rightChild;

        // Adding more nodes to the tree if needed
        leftChild.left = new TreeNode2(3); // Left child of node 2
        leftChild.right = new TreeNode2(4); // Right child of node 2
        // rightChild.left = new ForDebugging(7); // Left child of node 3
        // rightChild.right = new ForDebugging(6); // Right child of node 3
        // leftChild.right.left = new ForDebugging(8); // Right child of node 2


        // Now you have created a binary tree with the following structure:
        //        1
        //       / \
        //      2   5
        //     / \ 
        //    3  4   
        //      
        //     
        solve(root);
        System.out.println(diameter);
        diameter = 0;
    }

    static int diameter = 0;
    public static int solve(TreeNode2 root) {
        if(root == null) return 0;

        int leftHeight = solve(root.left);
        int rightHeight = solve(root.right);
        int dia = leftHeight + rightHeight;
        diameter = Math.max(dia, diameter);

        // sending max diameter for the current node
        return Math.max(leftHeight, rightHeight) + 1;

    }

}



