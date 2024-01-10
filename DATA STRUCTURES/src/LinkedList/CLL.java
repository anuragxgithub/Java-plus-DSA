package LinkedList;

public class CLL {
    Node head;
    Node tail;

    //INSERTION
    public void addFirst(int value) {
        Node node = new Node(value);
        if(head == null) {  //no elements
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head = node;
        tail.next = head;
    }

    public void addLast(int value) {
        if(head == null) {
            addFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        tail.next = head;
    }
    
    public void insert(int value, int idx) {
        if(head == null) {
            addFirst(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        for (int i = 0; i < idx -1; i++) {
            temp = temp.next;
        }

        node.next = temp.next; 
        temp.next = node;
    }

    public void delete(int val) {
        if(head == null) {
            System.out.println("Empty list.");
            return;
        }

        Node node = head;  //new node created pointing to head
        if(node.value == val) {   //if the value is at first index
            head = node.next;
            tail.next = head;
            return;
        }
        //Otherwise iterate over each node to see if any node contain that value

        do {
            Node n = node.next;  //this n will be ahead one node to the 'node' this prevents us from loosing the link of previous node. IMP. to understand easypeasy
            if(n.value == val) {
                node.next = n.next; //beech wala node del ho gaya
            }
            node = node.next;
        } while(node != head);
    } 

    //DISPLAY
    public void display() {
        Node temp = head;
        if(head != null) {
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while(temp != head);
        }
        System.out.println("START");
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        CLL list = new CLL();
        list.addFirst(34);
        list.addFirst(69);
        list.addFirst(46);
        list.addFirst(29);
        list.display();

        list.addLast(99);
        list.addLast(77);
        list.display();

        list.insert(56, 6);
        list.display();

        //create delFirst and delLast

        //here this delete means del the index whose value is given.
        list.delete(69);
        list.delete(34);
        list.display();
    }
}
