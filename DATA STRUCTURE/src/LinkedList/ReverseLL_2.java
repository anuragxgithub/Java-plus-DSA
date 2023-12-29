package LinkedList;

import LinkedList.PracticeLL.Node;
// https://leetcode.com/problems/reverse-linked-list-ii/
//Given the head of a singly linked list and two integers left and right where left <= right, 
//reverse the nodes of the list from position left to position right, and return the reversed 
//list.  1-based Indexing.
public class ReverseLL_2 {

    public static void main(String[] args) {
        PracticeLL l = new PracticeLL();
        l.insertLast(2);
        l.insertLast(4);
        l.insertLast(1);
        l.insertLast(3);
        l.insertLast(9);
        l.insertLast(6);
        l.insertLast(7);
        l.insertLast(8);

        l.display();

        Node head = reverseBetween(l.head, 2, 4);
        while(head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        } System.out.println("End");
    }
    
    public static Node reverseBetween(Node head, int left, int right) {
        if(left == right || head.next == null) {
            return head;
        }

        //skip left-1 nodes
        Node prev = null;
        Node current = head;
        for (int i = 0; current != null && i < left-1; i++) {  //to find the last nade(just prev node of the sublist)
            prev = current; //this previous will point to the last node
            current = current.next;  //current will point to the first node of the sublist.
        }

        Node last = prev;
        Node newEnd = current;  //newEnd means new end of sublist after the reversal

        //reverse b/w left and right
        Node nxt = current.next;
        for (int i = 0; current != null && i < right-left+1; i++) {  //right-left+1 bcz prev stops at last node while reversing
            current.next = prev;
            prev = current;
            current = nxt;
            if(nxt != null) {
                nxt = nxt.next;
            }
        }

        if(last != null) { //true when the left starts from the head of the LL (i.e, when left = 1)
            last.next = prev;
        } else {
            head = prev;
        }
        //If you know where these pointers stops after reversal you can understood things easily
        newEnd.next = current;
        return head;
    }
}
