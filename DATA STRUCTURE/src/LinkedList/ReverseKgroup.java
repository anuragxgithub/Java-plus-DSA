package LinkedList;

import LinkedList.PracticeLL.Node;
// https://leetcode.com/problems/reverse-nodes-in-k-group/

//Not completed yet comeplete it.
public class ReverseKgroup {
    public static void main(String[] args) {
        PracticeLL l = new PracticeLL();
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertLast(4);
        l.insertLast(5);
        l.insertLast(6);
        l.insertLast(7);
        l.insertLast(8);
        l.insertLast(9);

        l.display();

        Node newHead = reverseKGroup(l.head, 2);
        while(newHead != null) {
            System.out.print(newHead.value + "->");
            newHead = newHead.next;
        } System.out.println("End");
    }

    public static Node reverseKGroup(Node head, int k) {
        if(k == 1 || head.next == null) {
            return head;
        }

        Node prev = null;
        Node current = head;

        while(true) {
            // Check if there are at least k nodes remaining
            Node nxt = current;
            int count = 0;
            while (nxt != null && count < k) {
                nxt = nxt.next;
                count++;
            }

            if (count < k) {
                // Less than k nodes remaining, no more reversal is possible
                break;
            }
            
            Node last = prev;
            Node newEnd = current;  //newEnd means new end of sublist after the reversal

            //reverse b/w left and right
            nxt = current.next;
            for (int i = 0; current != null && i < k; i++) { 
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
            if(current == null) {
                break;
            }
        }

        return head;
    }
    
}
