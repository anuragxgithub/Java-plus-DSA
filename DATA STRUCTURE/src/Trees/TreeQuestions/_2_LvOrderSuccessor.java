package Trees.TreeQuestions;
// GOOGLE : Level Order Successor of a node

import java.util.Queue;
import java.util.LinkedList;

public class _2_LvOrderSuccessor {
    // Just to make program error free just created a dummy TreeNode class.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        _2_LvOrderSuccessor x = new _2_LvOrderSuccessor();
        TreeNode root = x.new TreeNode(28);
        TreeNode ans = findSuccessor(root,12);
        System.out.println(ans.val);
    }

    public static TreeNode findSuccessor(TreeNode root, int key) { // returning the next node itself(not its value)
        // base case
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();  // retrieves and removes the head of this queue
            if(currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            if(currentNode.val == key) {
                break;
            }
        }
        return queue.peek();  // returns null if this queue is empty. 
    }
}