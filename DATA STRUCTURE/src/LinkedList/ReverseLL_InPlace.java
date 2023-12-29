package LinkedList;

import LinkedList.PracticeLL.Node;

//LEETCODE : 206  Reverse linked list (In-Place).
//Here we will use three pointers to reverse the list. prev - which will initally point to null,
//then present - which will point head initally and next which will point to head.next.
//Done nothing much.
// we need to do this:    
//  1 -> 2 -> 3 -> 4 -> 5 -> null     to
//  null <- 1 <- 2 <- 3 <- 4 <- 5 
public class ReverseLL_InPlace {
    public static void main(String[] args) {
        PracticeLL list8 = new PracticeLL();
        list8.insertLast(1);
        list8.insertLast(2);
        list8.insertLast(3);
        list8.insertLast(4);
        list8.insertLast(5);
        list8.display();

        Node ansNode = reverse(list8.head);
        while(ansNode != null) {
            System.out.print(ansNode.value + "->");
            ansNode = ansNode.next;
        } 
        System.out.println("END");
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

        return prev;  //bcz it will be the head of reversed LL as 
    } 
}
