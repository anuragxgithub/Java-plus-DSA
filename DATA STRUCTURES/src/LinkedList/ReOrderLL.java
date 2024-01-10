package LinkedList;

import LinkedList.PracticeLL.Node;

// https://leetcode.com/problems/reorder-list/

//If we are able to move backward and known the tail it would be literally very easy to solve
//but since we can't move backward and tail is not given initially. So what we can do is 
//reverse the list from the middle(as per the question) so that we can reorder the list
//while moving forward and in one go.
//NOTE: You will only know what's happening if you understand properly how everything every method
//working and pointer thing use pen and paper.
public class ReOrderLL {
    public static void main(String[] args) {
        PracticeLL l = new PracticeLL();
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertLast(4);
        l.insertLast(5);
        l.insertLast(6);
        l.insertLast(7);

        l.display();

        reorderList(l.head);
        Node temp = l.head;
        while(temp != null) {
            System.out.print(temp.value +"->");
            temp = temp.next;
        } System.out.println("End");
    }

    public static void reorderList(Node head) {
        if(head == null || head.next == null) {  //in case list has 0 or 1 element
            return;
        }

        Node headOne = head;
        Node mid = mid(head);
        Node headTwo = reverse(mid);

        while(headOne != null && headTwo != null) {
            // rearrange
            Node temp = headOne.next;  //to hold the next node of the fisrt node.
            headOne.next = headTwo;
            headOne = temp;

            temp = headTwo.next;
            headTwo.next = headOne;
            headTwo = temp;
        }

        //next of tail to null
        if(headOne != null) {
            headOne.next = null;
        }

        return;
    }

    public static Node mid(Node head) {
        Node slow = head;
        Node fast = head;
        if(slow.next == null) {  //if there is only one element is the LL
            return head;
        }

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node present = head;
        Node nxt = head.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = nxt;

            if(nxt != null) {
                nxt = nxt.next;
            }
        }
        return prev;  //This is head of reversed LL 
    }
}
