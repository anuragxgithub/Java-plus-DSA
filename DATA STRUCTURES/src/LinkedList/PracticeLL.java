package LinkedList;
//NOTE: HERE ONLY NEW THING IS INSERTION USING RECURSION AND LEET CODE QUESTIONS AT BOTTOM⭐⭐
public class PracticeLL {
    public Node head;   //intially head and tail point to null normal oops concept.
    private Node tail;   //head and tail points to first and last node respectively.
    public int size;

    public PracticeLL() {
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

    public class Node {
         public int value;
         public Node next;  //it will point something of type node thats why its type is also node.


        public Node(int value) {   //constructor
            this.value = value;
        }

        public Node(int value, Node next) {   //constructor
            this.value = value;
            this.next = next; //here rhs next will be the nodes to point to.
        }

        public Node() {
            
        }
    }

    public static void main(String args[]) {
        PracticeLL list = new PracticeLL();
        list.insertFirst(12);
        list.insertFirst(34);
        list.insertFirst(58);


        list.insertLast(5);
        list.insertLast(6);


        list.insert(23, 3);

        list.display();

        list.insertRecursively(99, 2);
        list.display();

        
        PracticeLL list2 = new PracticeLL();
        list2.insertFirst(1);
        list2.insertFirst(1);
        list2.insertFirst(1);
        list2.insertFirst(2);
        list2.insertFirst(4);
        list2.insertFirst(4);
        list2.display();
        list2.deleteDuplicates();
        list2.display();
    }


    //QUESTIONS
    //leetCode 83

    public void deleteDuplicates() {
        Node temp = head;
        while(temp.next != null) {
            if(temp.value == temp.next.value) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null;
    }
}
