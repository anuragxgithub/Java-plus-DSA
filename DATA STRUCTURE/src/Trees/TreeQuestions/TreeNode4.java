package Trees.TreeQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;

    TreeNode4() {}
    
    TreeNode4(int val) {
        this.val = val;
    }

    TreeNode4(int val, TreeNode4 left, TreeNode4 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        // Creating nodes for the binary tree
        TreeNode4 root = new TreeNode4(1); // Root node with value 1
        TreeNode4 leftChild = new TreeNode4(2); // Left child with value 2
        TreeNode4 rightChild = new TreeNode4(3); // Right child with value 3

        // Connecting nodes to form the binary tree structure
        root.left = leftChild;
        root.right = rightChild;

        // Adding more nodes to the tree if needed
        // leftChild.left = new TreeNode4(3); // Left child of node 2
        // leftChild.right = new TreeNode4(4); // Right child of node 2
        rightChild.left = new TreeNode4(4); // Left child of node 3
        rightChild.right = new TreeNode4(5); // Right child of node 3


        // Now you have created a binary tree with the following structure:
        //        1
        //       / \
        //      2   3
        //         / \
        //        4   5 
        String data = serialize(root);

        TreeNode4 node = deserialize(data);
        display(node);

    }

    public static String serialize(TreeNode4 root) {
        StringBuilder str = new StringBuilder();
        dfs(root, str);
        System.out.println(str.toString());
        return str.toString();
        }

        static void dfs(TreeNode4 root, StringBuilder s) {
            if(root == null) {
                s.append("n,");
                return;
            }

            s.append(root.val).append(",");
            dfs(root.left, s);
            dfs(root.right, s);
        }

    public static TreeNode4 deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        // the list of string becomes the element of the queue
        System.out.println(nodes.toString() + "This is the queue elements after splitting the string from delimiter.");

        return decode(nodes);
    }
    static TreeNode4 decode(Queue<String> data) {
        if(data.isEmpty()) {
            return null;
        }

        String value = data.poll();
        if(value.equals("n")) {
            return null;
        }

        TreeNode4 node = new TreeNode4(Integer.parseInt(value));
        node.left = decode(data);
        node.right = decode(data);

        return node;
    }

    public static void display(TreeNode4 node) {
        if(node == null) {
            System.out.print('n'+ " ");
            return;
        }

        System.out.print(node.val+ " ");
        display(node.left);
        display(node.right);
    }

}
