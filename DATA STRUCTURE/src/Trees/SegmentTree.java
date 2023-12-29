package Trees;
/*
Segment trees are used to solve problems which involve answering some query(like sum,sub,mult.,etc)
in much efficient way. Eg we are given a query/problem which ask to calculate the sum of elements
int the array b/w any range so the worst time complexity of this can be O(n) when range is 0,arr.len-1
we can do the same thing using segment tree in O(log(n)) time. 
Node of segment tree contains query and interval. It saves time but use space.
*/
public class SegmentTree {
    
    private static class Node {
        private int startInterval;   //intervalStartIndex basically
        private int endInterval;
        private Node left;
        private Node right;
        private int value;

        public Node(int startInterval, int endInterval) {   //constructor
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }

    Node root;

    public SegmentTree(int[] arr) {     //constructor
        //create a tree using this array
        this.root = constructTree(arr, 0, arr.length-1);        
    }

    private Node constructTree(int[] arr, int startIdx, int endIdx) {
        //this method creates a tree a return the root node
        if(startIdx == endIdx) {
            Node leaf = new Node(startIdx, endIdx);
            leaf.value = arr[startIdx]; 
            return leaf;
        }

        // create new node with index you are at
        Node node = new Node(startIdx, endIdx);
        int mid = (startIdx + endIdx) / 2;
        node.left = this.constructTree(arr, startIdx, mid);
        node.right = this.constructTree(arr, mid+1, endIdx);

        node.value = node.left.value + node.right.value; //since our requirement is sum of elements withing a range so we do this we can modify this according to our need
        return node;    //will return root node bcz you know it recursion
    }

    // query  
    public int query(int qsi, int qei) {   //qei -> query end index and start index for qsi
        return query(this.root, qsi, qei);
    }
    private int query(Node node, int qsi, int qei) {
        if(node.startInterval >= qsi && node.endInterval <= qei) {
            //node interval is completely inside query interval
            return node.value;
        } else if(qsi > node.endInterval || qei < node.startInterval) {
            //node interval is completely outside the query interval
            return 0;
        } else {
            //node interval is partially in the query interval (overlapping)
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);  //query idx will remain same
        }
    }

    //update
    public void update(int idx, int value) {
        this.root.value = update(this.root, idx, value);   //root will be updated
    }
    private int update(Node node, int i, int val) {
        if(i >= node.startInterval && i <= node.endInterval) {
            if(i == node.startInterval && i == node.endInterval) {
                //update the value
                node.value = val;
                return node.value;
            } else {
                int leftAns = update(node.left, i, val);
                int rightAns = update(node.right, i, val);
                //also we need to re sum the values
                node.value = leftAns + rightAns;
                return node.value;
            }
        }
        return node.value;
    }


    //display
    public void display() {
        display(this.root);
    }
    private void display(Node node) {
        if(node == null) {
            return;
        }

        display(node.left);
        display(node.right);
        System.out.println(node.value + " from range " + "[" + node.startInterval + "-" + node.endInterval + "]");
    }

    public void display2() {
        //here we will print in this style:
        //left child info => parent info <= right child info
        display2(this.root);
    }
    private void display2(Node node) {
        String str = "";
        //left child info
        if(node.left != null) {
            str = str + "Interval = [" + node.left.startInterval + "-" + node.left.endInterval + "]" + " and data: " + node.left.value;
        } else {
            str = str + "No left child";
        }

        //for current/parent node
        str = str + " => Interval = [" + node.startInterval + "-" + node.endInterval + "]" + " and data: " + node.value;

        //right child info
        if(node.right != null) {
            str = str + " <= Interval = [" + node.right.startInterval + "-" + node.right.endInterval + "]" + " and data: " + node.right.value;
        } else {
            str = str + " <= No right child";
        }

        System.out.println(str + '\n');
        
        //recursion calls
        if(node.left != null) {
            display2(node.left);
        }
        if(node.right != null) {
            display2(node.right);
        }
    }



    public static void main(String[] args) {
        int[] arr = {2,3,7,5,8,-9};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();
        System.out.println(tree.query(1,5)); 
        // tree.update(1, 5);   //updation will take O(logn)
        tree.display2();

    }
}