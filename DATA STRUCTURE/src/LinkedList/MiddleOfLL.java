package LinkedList;
//LEETCODE 876
//basically the idea is if two person runs with different speed one with the half speed of
//second one if the second one reaches the finish line the first one will be exactly at half of
//of the path. 
//NOTE: if there are even number of elements present then it will give the righ side middle 
//element.
import LinkedList.PracticeLL.Node;
public class MiddleOfLL {
    public static void main(String[] args) {
        PracticeLL list5 = new PracticeLL();  //created list from the PracticeLL class in this package.
        list5.insertFirst(12);
        list5.insertFirst(15);
        list5.insertFirst(18);
        list5.insertFirst(90);
        list5.insertFirst(67);
        list5.insertFirst(99);
        list5.display();
        Node node = middleNode(list5.head);
        System.out.println(node.value);
    }

    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        if(slow.next == null) {
            return slow;
        }

        do {
            slow = slow.next;
            fast = fast.next.next;
        }
        while(fast != null && fast.next != null);
        return slow; 
    }
}
 