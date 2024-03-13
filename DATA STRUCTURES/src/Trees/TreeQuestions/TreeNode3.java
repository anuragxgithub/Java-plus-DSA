package Trees.TreeQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
        TreeNode3 rightChild = new TreeNode3(3); // Right child with value 3

        // Connecting nodes to form the binary tree structure
        root.left = leftChild;
        root.right = rightChild;

        // Adding more nodes to the tree if needed
        // leftChild.left = new TreeNode4(3); // Left child of node 2
        // leftChild.right = new TreeNode4(4); // Right child of node 2
        rightChild.left = new TreeNode3(4); // Left child of node 3
        rightChild.right = new TreeNode3(5); // Right child of node 3


        // Now you have created a binary tree with the following structure:
        //        1
        //       / \
        //      2   3
        //         / \
        //        4   5 
        String data = serialize(root);

        TreeNode3 node = deserialize(data);
        display(node);

    }

    public static String serialize(TreeNode3 root) {
        StringBuilder str = new StringBuilder();
        dfs(root, str);
        System.out.println(str.toString());
        return str.toString();
        }

        static void dfs(TreeNode3 root, StringBuilder s) {
            if(root == null) {
                s.append("n,");
                return;
            }

            s.append(root.val).append(",");
            dfs(root.left, s);
            dfs(root.right, s);
        }

    public static TreeNode3 deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        // the list of string becomes the element of the queue
        System.out.println(nodes.toString() + "This is the queue elements after splitting the string from delimiter.");

        return decode(nodes);
    }
    static TreeNode3 decode(Queue<String> data) {
        if(data.isEmpty()) {
            return null;
        }

        String value = data.poll();
        if(value.equals("n")) {
            return null;
        }

        TreeNode3 node = new TreeNode3(Integer.parseInt(value));
        node.left = decode(data);
        node.right = decode(data);

        return node;
    }

    public static void display(TreeNode3 node) {
        if(node == null) {
            System.out.print('n'+ " ");
            return;
        }

        System.out.print(node.val+ " ");
        display(node.left);
        display(node.right);
    }

}
