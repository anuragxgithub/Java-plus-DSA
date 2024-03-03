package Trees.TreeQuestions;

public class CountComTreeNodes {
    // https://leetcode.com/problems/count-complete-tree-nodes/
    public static int count(TreeNode root) {
        if(root == null) return 0;

        return 1 + (count(root.left) + count(root.right));
        // 1 for counting the curr node and left and right for siblings
    }
    public int countNodes(TreeNode root) {
        return count(root);
    }
}
