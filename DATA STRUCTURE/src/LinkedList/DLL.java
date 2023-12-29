package LinkedList;

public class DLL {
    private Node head;   //this time making LL without using the tail and size variables.

    
    //INSERTION 
    public void addFirst(int value) {
        Node node = new Node(value);  
        node.next = head;
        node.prev = null;  //for the newly added node

        if(head != null) {
            head.prev = node;
        }             
        head = node;                  
    }

    public void addLast(int value) {
        if(head == null) {    //when there is no element in the DLL
            addFirst(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        while(temp.next != null) { //here temp.next to get the last node pretty logical
            temp = temp.next; 
        }
        temp.next = node;
        node.prev = temp;
        node.next = null;
    }

    public void insert(int value, int idx) {
        Node node = new Node(value);
        Node temp = head;
        for (int i = 0; i < idx -1; i++) {
            temp = temp.next;
        }

        if(temp.next != null) {  //to prevent null pointer exception bcz if temp.next will be null and you do temp.next.prev then it will raise the NullPointerException
            temp.next.prev = node;
        }

        node.next = temp.next;
        temp.next = node;
        node.prev = temp;

    }

    public void insertAfter(int x, int value) {
        Node node = new Node(value);
        Node target = findNode(x);
        if(target == null) {
            System.out.println("given value does not exist");
        }

        if(target.next != null) {  //to prevent null pointer exception bcz what if the next node after the given value is not a node instead null and when we try to access node.next.pre so it will raise that error.
            target.next.prev = node;
        }
        node.next = target.next;
        node.prev = target;
        target.next = node;
    }

    private Node findNode(int x) {
        Node temp = head;
        while(temp != null) {
            if(temp.value == x) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //PRINTING LINKED LIST
    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void displayInRev() {
        //If we have last node we can easily print list in reverse(using prev) since we don't have
        // tail so we have to iterate till the end and then find the next node.
        Node temp = head;
        Node last = null;
        while(temp != null) {
            last = temp;  //keep pointing to upcoming nodes until last node.
            temp = temp.next;
        }
        while(last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    
    }

    public static void main(String[] args) {
        DLL list = new DLL(); 
        list.addFirst(12);
        list.addFirst(34);
        list.addFirst(58);
        list.addFirst(98);
        list.display();
        list.displayInRev();
        list.addLast(49);
        list.addLast(8);
        list.addLast(76);
        list.display();

        list.insert(100,7);
        list.display();

        //Insert a node just after the given value.
        list.insertAfter(12, 99);
        list.display();

        //create delFirst delLast delGivenValue delelteIndex
    }

}

