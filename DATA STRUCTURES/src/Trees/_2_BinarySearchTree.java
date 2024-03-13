package Trees;
//Here we are considering that our tree is balanced thus insertion/and other operations will take log(n) time.
//In a balanced tree, the difference in height between the left and right subtrees of any node
//(called the balance factor) is limited to a specific range, usually -1, 0, or 1. 

//The BST has the following properties:
//1) Ordering property: For any node in the BST, all keys in its left subtree have values less 
//than the node's key, and all keys in its right subtree have values greater than the node's key.
//2)Unique keys: Each key in the BST is unique, meaning no two nodes can have the same key.
//3)Recursive structure: The left and right subtrees of a node are also binary search trees.
public class _2_BinarySearchTree {

    public _2_BinarySearchTree() {  //constructor

    }

    class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    //insertion
    public void insert(int value) {
        root = insert(value, root);
    }
    private Node insert(int value, Node node) {
        if(node == null) {
            node = new Node(value);
            return node;
        }
        if(value < node.value) {
            node.left = insert(value, node.left);
        }

        if(value > node.value) {
            node.right = insert(value, node.right);
        }

        //updating the height since the node is added(it will update the size of nodes while recursion calls are returning)
        node.height =  Math.max(height(node.left), height(node.right)) + 1;

        return node;  //will return the root node because the recursion will stop there
    }

    //balanced or not
    public boolean balanced() {
        return balanced(root);
    }
    private boolean balanced(Node node) {
        if(node == null) {
            return true;  //no tree then balance
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
        //the right side two recursive calls is to check the height of sub-trees
    }

    //height
    public int height(Node node) {
        if(node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    //diplay..
    public void display() {
        display(root, "Root Node: ");
    }
    private void display(Node node, String details) {
        if(node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "left child of "+ node.value + " : ");
        display(node.right, "right child of "+ node.value + " : ");
    }

    //populate..
    public void populate(int[] nums) {  //creating this populate method so that we don't have to write again and again in console for insertion
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }
    private void populatedSorted(int[] nums , int start, int end) {
        if(start >= end) {  //base case
            return;
        }

        int mid = (start+end)/2;
        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);  //to do same for left half
        populatedSorted(nums, mid+1, end);  //to do same for right half
    }

    //--------------------------------TRAVERSALS------------------------------------------//
    //1) PreOrder : N -> L -> R
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.value);  //first printing the node
        preOrder(node.left);      
        preOrder(node.right);   
    }

    //2) InOrder : L -> N -> R
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    //2) PostOrder : L -> R -> N
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }


    public static void main(String[] args) {
        _2_BinarySearchTree tree = new _2_BinarySearchTree();
        int[] nums = {5,3,6,7,8,2,4};
        tree.populate(nums);
        tree.display();

    //Now the problem is what if array is sorted it will create a skewed tree. Which means the 
    //operations we perform will take O(n) time instead of O(logn) in order to fix this we will
    //create populatedSorted method which will simply print the middle element and then left and
    //right part of that mid so that we can create good balancing tree.
    //AVL tree solves this prolem that is a self balancing binary search tree.

        System.out.println(tree.isEmpty());
        // int[] nums2 = {1,2,3,4,5,6};   
        // tree.populatedSorted(nums2);  // O(n*log(n))
        // tree.display();


        // tree.preOrder();
        // tree.inOrder();
        tree.postOrder();
    }
}
