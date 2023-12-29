//This is allowed you can use nested class's name before its declaration since it is a member of the 
// outer class.
package LinkedList;
//Creating a node is nothing but creating a Class, put all the the things you need in a node
//inside the class as field. Now use that class as your node Simpil.  
public class SLL {

    private Node head;   //intially head and tail point to null normal oops concept.
    private Node tail;   //head and tail points to first and last node respectively.
    private int size;

    public SLL() {
        this.size = 0;
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

    // PRINT LINKED LIST
    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }


    public static void main(String[] args) {
        SLL list = new SLL(); 
        list.insertFirst(12);
        list.insertFirst(34);
        list.insertFirst(58);

        list.display();

        list.insertLast(5);
        list.insertLast(6);

        list.display();

        list.insert(23, 3);
        list.display();

        list.delFirst();
        list.display();

        list.delLast();  //O(n)  bcz always worst case we measure in big O
        list.display();

        System.out.println(list.del(2));
        list.display();
    }
}
// Note garbage collector will take care of some values during deletion operations.

