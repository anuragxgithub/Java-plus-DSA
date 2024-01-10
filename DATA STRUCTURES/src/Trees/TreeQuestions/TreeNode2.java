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
        rightChild.left = new TreeNode2(7); // Left child of node 3
        rightChild.right = new TreeNode2(6); // Right child of node 3
        leftChild.right.left = new TreeNode2(8); // Right child of node 2


        // Now you have created a binary tree with the following structure:
        //        1
        //       / \
        //      2   5
        //     / \ / \
        //    3  4 7  6
        //      /
        //     8
        int[] arr = {9, 1, 2, 8};

        boolean ans = isPathExist(root, arr, 0);
        if(ans) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean isPathExist(TreeNode2 node, int[] arr, int index) {
        if(node == null) {
            return false;
        }

        if(index >= arr.length || node.val != arr[index]) {
            return false;
        }

        if(node.left == null && node.right == null && index == arr.length-1) { // bcz path should be from root to leaf node
            return true;
        }

        return isPathExist(node.left, arr, index+1) || isPathExist(node.right, arr, index+1);
    }

}



