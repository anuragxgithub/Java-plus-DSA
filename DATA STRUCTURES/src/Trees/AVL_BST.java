package Trees;
//The code is exactly same as normal BST only few new things added in it.

//As we know the problem with the normal BST is that tree can be unbalanced(when data provided is
//in sorted manner) resulting in taking more time to search elements.
//AVL trees are self balancing binary search trees it basically checks the node of the subtree
//where the it is not balanced and after finding the unbalanced node(from bottom to top using
//recursion) it basically rotate it.
//Rotations are based on the 4 conditions :
//  below 'subtree' refers to the unbalanced subtree 
//1) When the subtree is in Left Left case 
//2) When the subtree is in Left Right case
//3) When the subtree is in Right Right case
//4) When the subtree is in Right Left case
//SEE NOTES to understand these cases⭐⭐

public class AVL_BST {
    public AVL_BST() {  //constructor

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
        node.height =  Math.max(height(node.left), height(node.right)) + 1; //remember +1

        return rotate(node);  //goes from bottom to top pretty logical
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
    public int height() {
        return height(root);
      }
    private int height(Node node) {
        if(node == null) {
            return -1;
        }
        return node.height;    //instance var height is of int type so by default it will have 0 
    }

    public boolean isEmpty() {
        return root == null;
    }

    //________________Rotate___________________ //
    public Node rotate(Node node) {
        if(height(node.left) - height(node.right) > 1) {
            //left heavy
            if(height(node.left.left) - height(node.left.right) > 0) {
                //left left case
                return rotateRight(node);   //Note if u are confused why we are passing certain node in rotateleft or right method then recall the parent child and grandchild visualisation
            }
            if(height(node.left.left) - height(node.left.right) < 0) {
                //left right case
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }

        }
        if(height(node.left) - height(node.right) < -1) {
            //right heavy
            if(height(node.right.left) - height(node.right.right) < 0) {
                //right right case
                return rotateLeft(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0) {
                //right left case
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }

        }
            return node;
    } 

    //__rotateLeft and rotateRight methods
    public Node rotateRight(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        //Now maintain the height
        //NOTE:⭐⭐ Very important: do care about the order of finding height whatever you p or c is we should first calculate the height for what comes at bottom and then will calculate for upper tree otherwise wrong height will be calculated 
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;  //new node in place of c
    }

    public Node rotateLeft(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        //See I maintained the order of calculating the height
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return p;
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
        AVL_BST tree = new AVL_BST();
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }


        System.out.println(tree.height());
        //See we are inserting the elemets in ascending order but it will not be a skewed tree
        //it will automatically balance it.
        //As we know the total no of nodes at any particular lev. is 2^lv.  where
        //lv starts from 0 . So for 1024 nodes in tree the height of root node will be 10
        //bcz at 10th level there 1024 noded present in trees
    }
}
