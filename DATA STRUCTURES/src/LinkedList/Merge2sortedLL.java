package LinkedList;
//NOTE: here only new thing is insertion using recursion and questions at bottom
public class Merge2sortedLL {
    private Node head;   //intially head and tail point to null normal oops concept.
    private Node tail;   //head and tail points to first and last node respectively.
    private int size;

    public Merge2sortedLL() {
        this.size = 0;
    }

    //INSERTION ✴✴
    public void insertFirst(int value) {
        Node node = new Node(value);   //new node created with the obtained value
        node.next = head;              //that node is now poiting to the head node(if exists else point to null)
        head = node;                   //head now will point to newly created node.
        
        if(tail == null) {      //this will be true when we add our very first element
            tail = head;
        }
        size++;
    }

    public void insertLast(int value) {
        if(tail == null) {       //true when there is no elements
            insertFirst(value);
        } else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            //head will remain as it is.
            size++;
        }
    }

    public void insert(int val, int idx) {
        if(idx == 0) {
            insertFirst(val);
            return;
        }

        if(idx == size) {
            insertLast(val);
            return;
        }
        
        if(idx <= size) {
            Node temp = head;
            for (int i = 0; i < idx-1; i++) {   // We need to stop at idx-1 to be at the previous node.
                temp = temp.next;
            }
            Node node = new Node(val, temp.next);
            //if you do not want to pass temp.next in the argument you can also do this:
            //node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

        //DELETION ✴✴
    public void delFirst() {    //you can make it to return the value which got deleted.
        if(size == 0) {
            System.out.println("Empty Linked List");
        } else {
            head = head.next;
            if(head == null) {  // true when there is only one element in the LL
                tail = null;
            }
            size--;
        }
    }

    public void delLast() {
        if(size <= 1) {
            delFirst();
        } else {
            Node temp = head;
            for (int i = 1; i < size-1; i++) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            size--;
        }
    }

    public int del(int idx) {
        Node temp = head;
        for (int i = 0; i < idx-1; i++) {
            temp = temp.next;
        }
        int val = temp.next.value;  //value which got removed  ✴✴
        Node node = temp.next.next;  //this is the connection of node which is just ahead on the deleted node.
        temp.next = node;
        size--;
        return val;     
    }

    //Inserting using recursion but we can't use tail and size.
    public void insertRecursively(int value, int idx) {
        head = insertRecursively(value, idx, head);
        System.out.println(head.value);
    }

    private Node insertRecursively(int value, int idx, Node node) {
        if(idx == 0) {
            Node temp = new Node(value, node);  //temp is the node which is to be inserted
            size++;
            return temp;
        }

        node.next = insertRecursively(value, idx-1, node.next); //when the base condition hits then the it returns from where it was called (i,e. the previous node now we do node.next and point it to temp done!)
        return node;  //after it will give the head bcz LIFO fuction call is returning (at first inserRecursively was called when node is pointing to head so at last obviously node will be again pointing to head after all fn calls gets removed)
    }

    // PRINT LINKED LIST
    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }

    class Node {
        private int value;
        private Node next;  //it will point something of type node thats why its type is also node.


        public Node(int value) {   //constructor
            this.value = value;
        }

        public Node(int value, Node next) {   //constructor
            this.value = value;
            this.next = next; //here rhs next will be the nodes to point to.
        }

        public Node() {   //Constructor

        }
    }

    public static void main(String args[]) {
        Merge2sortedLL list1 = new Merge2sortedLL();
        list1.insertLast(1);
        list1.insertLast(4);
        list1.insertLast(6);
        list1.insertLast(7);
        list1.display();
        
        Merge2sortedLL list2 = new Merge2sortedLL();
        list2.insertLast(1);
        list2.insertLast(1);
        list2.insertLast(1);
        list2.insertLast(2);
        list2.insertLast(4);
        list2.insertLast(4);
        list2.display();
        
        Node ans = list2.mergeTwoSortedLL(list1.head, list2.head);
        System.out.println("Now you can travese through this node till end to get the merged sorted linked list.");
        while(ans != null)  {
            System.out.print(ans.value + " -> ");
            ans = ans.next;
        } System.out.println("END");
    }

    //LeetCode 21 :
    public Node mergeTwoSortedLL(Node head1, Node head2) {
        Node dummyHead = new Node();  //a random node for now
        Node tail = dummyHead;
        //changes made in via tail will reflect to dummyHead too bcz initially 
        //they are pointing to same node
        while(head1 != null && head2 != null) {
            if(head2.value < head1.value) {
                tail.next = head2;
                tail = tail.next;   //remember to update the tail.
                head2 = head2.next;
            } else {
                tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
            }
        }
            //Now let's print the remaining elements if any
            if(head1 == null) { 
                while(head2 != null) {
                    tail.next = head2;
                    tail = tail.next;
                    head2 = head2.next;  
                }
                
            } else {
                while(head1 != null) {
                    tail.next = head1;
                    tail = tail.next;
                    head1 = head1.next;
                    
                }
            } 

        return dummyHead.next;  //this would be the head of the merged sorted LL.
    }
}
