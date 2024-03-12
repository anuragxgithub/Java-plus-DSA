
// https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
// Prerequisite : Top view of Bt using dfs

package Trees.TreeQuestions;

public class _5_BottomViewOfBT {
//     class Solution {
//     int left = 0;
//     int right = 0;
//     public void findLeft(Node root, int pos) {
//         if(root == null) return;
        
//         if(pos < left) left = pos;
//         if(pos > right) right = pos;
        
//         findLeft(root.left, pos-1);
//         findLeft(root.right, pos+1);
//     }
//     public static void dfs(Node root, int[] ans, int[] level, int lv, int pos) {
//         if(root == null) return;
        
//         if(lv >= level[pos]) {    // >= bcz If there are multiple bottom-most 
//         // nodes for a horizontal distance from root, then print the later one 
//         // in level traversal
//             ans[pos] = root.data;
//             level[pos] = lv;
//         }
        
//         dfs(root.left, ans, level, lv+1, pos-1);
//         dfs(root.right, ans, level, lv+1, pos+1);
//     }
    
    
//     // COME HERE AFTER UNDERSTANDING TOP VIEW OF BINARY TREE USING DFS ⭐
//     public ArrayList <Integer> bottomView(Node root) {
//         // first we will find the max left  & right movement possible
//         // so that we can give the correct position/idx to nodes 
//         // which makes it easy to add them in ans arr bcz there pos is same
//         // as idx at which they should be present.
//         findLeft(root, 0);
        
//         int[] ans = new int[right - left +1];
//         int[] level = new int[right - left +1];
//         Arrays.fill(level, Integer.MIN_VALUE);
//         dfs(root, ans, level, 0, -left);
//         ArrayList<Integer> list = new ArrayList<>(ans.length);
//         for(int e : ans) list.add(e);
//         return list;
//     }
// }
}
