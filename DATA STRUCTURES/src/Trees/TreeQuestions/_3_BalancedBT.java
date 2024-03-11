/*
 
This is important see when such of type of question is required where we need
left and right subtree heights seperately for any comparison so we return 
Math.max(leftH, rightH) in last.
*/
package Trees.TreeQuestions;
    
public class _3_BalancedBT {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    static void populate(TreeNode root) {
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(4);
/* 
                     2
                    / \
                   2   2
                  / \
                 3   3
                / \
               4   4
*/
    }

    static boolean ans = true;
    public static int solve(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = solve(root.left);
        int rightHeight = solve(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) ans = false;
        return Math.max(leftHeight, rightHeight) +1;
    }
    // can be optimised by adding a if condition if(ans) { perform your task}

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        populate(root);

        ans = true;
        solve(root);
        System.out.println(ans);

    }
}
