package LinkedList;
import LinkedList.PracticeLL.Node;
//You won't believe I solved this on my own without any help and it worked in the
//first attempt without any error. ⭐⭐  //O(n+k) Use pen and paper. EasyPeasy
// https://leetcode.com/problems/rotate-list/

// so the idea is as k can be as any large number so if the length of linked list lets say is 4
// and k is 1000 there will be unnecessary roatations in this case so to avoid this we need to 
// find the len of LL so that we can overcome unnecessary rotaion by (k= k%len).
// After that we will reverse the LL from head.next. So that we can rotate the list by only moving
// forward(as we can't move backward bcz SLL). Now after reversing we will rotate the list k times
// now if there is any remaining elements in right side re reverse that part to get the original
//placing of those nodes. And if no node present after the rotation on right side that means all
//other elements are rotated and the tail would be our Very first head so point it to the null.  


public class RotateList {
    public static void main(String[] args) {
        PracticeLL l9 = new PracticeLL();
        l9.insertLast(1);
        l9.insertLast(2);
        l9.insertLast(3);
        l9.insertLast(4);
        l9.insertLast(5);

        l9.display();
        Node ansHead = rotateRight(l9.head, 4);
        while(ansHead != null) {
            System.out.print(ansHead.value + "->");
            ansHead = ansHead.next;
        } System.out.println("End");

    }

    public static Node rotateRight(Node head, int k) {
        Node initialHead = head;
        if(head == null || head.next == null) {
            return head;
        }
        int len = length(head);
        k = k%len;  //so that we don't need to do unnecessary rotations again & again
        Node h2 = reverse(head.next);

        //rotation
        for (int i = 0; i < k; i++) {
            Node temp = h2.next;  //to store the connection of h2
            h2.next = head;
            head = h2;
            h2 = temp;
        }
        if(h2 != null) {
            //reverse the remaining elements to its original place
            reverse(h2);
        } else {
            initialHead.next = null;
        }
        return head;
    }

    public static int length(Node head) {
        int len = 0; Node temp = head;
        while(temp != null) {
            len++;
            temp = temp.next; 
        }
        return len;
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
        return prev;
    } 
}
