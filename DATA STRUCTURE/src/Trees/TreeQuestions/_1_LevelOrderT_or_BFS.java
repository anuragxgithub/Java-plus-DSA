package Trees.TreeQuestions;
// Que: Binary Tree Level Order Traversal or BFS(Breadth First Search).
// Leetcode: 102

// import java.util.List;
// import java.util.Queue;
// import java.util.ArrayList;


public class _1_LevelOrderT_or_BFS {
    public static void main(String[] args) {
        
    }

    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> result = new ArrayList<>();
    //         if(root == null) {
    //             return result;
    //         }
    //         Queue<TreeNode> queue = new LinkedList<>();   // queue is storing data of type TreeNode 
    //         queue.offer(root);
    //         while(!queue.isEmpty()) {
    //             int levelSize = queue.size();
    //             ArrayList<Integer> currentLevel = new ArrayList<>(levelSize);
    //             for (int i = 0; i < levelSize; i++) {
    //                 TreeNode currentNode = queue.poll();
    //                 currentLevel.add(currentNode.val);

    //                 // we need to store the other elements in queue also
    //                 if(currentNode.left != null) {
    //                     queue.offer(currentNode.left);
    //                 }
    //                 if(currentNode.right != null) {
    //                     queue.offer(currentNode.right);
    //                 }
    //             }
    //             result.add(currentLevel);
    //         }
    //     return result;
    // }

}

