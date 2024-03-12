
// BOTH METOHDS EXPLANED WITH NOTES⭐
// https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

package Trees.TreeQuestions;


public class _4_TopViewOfBT {
    // static int left = 0, right = 0;
    // public static void findLandR(Node root, int position) {
    //     if(root == null) return;
        
    //     if(position < left) left = position;
    //     if(position > right) right = position;
        
    
    //     findLandR(root.left, position-1);
    //     findLandR(root.right, position+1);
    // }

    // if two or more nodes have same "pos" that means they are on same
    // vertical line so in this case we will pick the element which
    // can be seen from top which is node on smallest level among all
    // dry run to undersatnd

    // public static void dfs(Node root, int pos, int[] ans, int[] level, int lv) {
    //     if(root == null) return;
        
    //     if(lv < level[pos]) {
    //         ans[pos] = root.data;
    //         level[pos] = lv;
    //     }
        
    //     dfs(root.left, pos-1, ans, level, lv+1);
    //     dfs(root.right, pos+1, ans, level, lv+1);
    // }
     
    
    // static ArrayList<Integer> topView(Node root)
    // {
    //     left = 0;      // max left steps
    //     right = 0;     // max right steps
    //     findLandR(root, 0);
    //     // ---- METHOD 2 DFS---- // (better and easyPeasy if you understand the Que)
    //     int[] ans = new int[right -left +1];
    //     int[] level = new int[right -left +1];
    //     Arrays.fill(level, Integer.MAX_VALUE);
    //     dfs(root, -left, ans, level, 0);
    //     ArrayList<Integer> list = new ArrayList<>(ans.length);
    //     for(int e : ans) list.add(e);
    //     return list;
        
        
        // ---- METHOD 1 BFS---- // (lengthy)
        // int[] ans = new int[(right-left)+1];
        // // abs(max of left)  + max of right + root node
        // boolean[] filled = new boolean[ans.length];
        
        
        // Lets perform bfs / level order traversal
        
        // Queue<Node> q = new LinkedList<>();
        // Queue<Integer> index = new LinkedList<>(); // index is determined by position of left and right initially we start the root node idx from -left
        
        // q.offer(root);
        // index.add(-left);  // remember minus
        
        // while(!q.isEmpty()) {
        //     int levelSize = q.size();
        //     for(int i = 0;i < levelSize; i++) {
        //         Node temp = q.poll();
        //         int position = index.poll();
        //         if(!filled[position]) {
        //             ans[position] = temp.data;
        //             filled[position] = true;
        //         }
                
        //         if(temp.left != null) {
        //             q.add(temp.left);
        //             index.add(position-1);
        //         }
        //         if(temp.right != null) {
        //             q.add(temp.right);
        //             index.add(position+1);
        //         }
        //     }
        // }
        // ArrayList<Integer> list = new ArrayList<>(ans.length);
        // for(int e : ans) list.add(e);
        // return list;
}

