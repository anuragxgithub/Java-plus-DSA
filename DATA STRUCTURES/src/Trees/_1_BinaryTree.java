package Trees;
//Here we are considering that our tree is balanced thus insertion/and other operations will take log(n) time.
//In a balanced tree, the difference in height between the left and right subtrees of any node
//(called the balance factor) is limited to a specific range, usually -1, 0, or 1. 
import java.util.Scanner;

//Here we will implement the binary tree(each node can have maximum of two child)
//Binary trees can be implemented by two ways 
//1)Linked represention(just like the LL implementation)  2) Sequential Representation (using array)
//Here we will look on 1st one 2nd one will be covered when we implement heap
public class _1_BinaryTree {
    
    public _1_BinaryTree() {   //constructor

    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {  //constructor
            this.value = value;
        }
    }
    private Node root;

    //insert elements
    public void populate(Scanner scanner) {
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);   //helper function
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of "+ node.value);
        boolean left = scanner.nextBoolean();
        if(left) {
            System.out.println("Enter the value for the left of "+ node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);  //recursive (keep asking to add left)
        }

        System.out.println("Do you want to enter right of "+ node.value);
        boolean right = scanner.nextBoolean();
        if(right) {
            System.out.println("Enter the value for the right of "+ node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);  //recursive (keep asking to add right)
        }
    }
    
    //Displaying..
    public void display() {
        display(root, " ");
    }
    private void display(Node node, String indent) {
        if(node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }
    private void prettyDisplay(Node node, int level) {
        if(node == null) {
            return;
        }

        prettyDisplay(node.right, level+1);  //for printing right nodes
        if(level != 0) {
            for(int i = 0; i < level-1; i++) {   //level-1 bcz we don't want tabs for lv 1
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {  //the root one
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level+1);
    }


    public static void main(String[] args) {
        _1_BinaryTree tree = new _1_BinaryTree();
        Scanner sc = new Scanner(System.in);
        tree.populate(sc);
        // tree.display();
        tree.prettyDisplay();
    }
}
