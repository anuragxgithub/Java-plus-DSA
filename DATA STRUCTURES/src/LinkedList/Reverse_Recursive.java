package LinkedList;

import LinkedList.PracticeLL.Node;
//If you know recursion nothing new. Easy to understand. 
public class Reverse_Recursive {
    public static void main(String[] args) {
        PracticeLL l = new PracticeLL();
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertLast(4);
        l.insertLast(5);
        l.insertLast(6);
        
        l.display();

        Node head = reverseRecursive(l.head);
        while(head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        } System.out.println("End");
        
    }

    public static Node reverseRecursive(Node head) {
        if(head == null || head.next == null) { //for last node or only one node
            return head;
        }

        Node newHead = reverseRecursive(head.next); 
        head.next.next = head; //helps in connecting the next node to the current node.
        head.next = null;

        return newHead;
    } 
}
//EASYYYY PEASYYYY