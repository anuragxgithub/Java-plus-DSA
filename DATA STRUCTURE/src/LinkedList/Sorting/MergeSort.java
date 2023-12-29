package LinkedList.Sorting;
// https://leetcode.com/problems/sort-list/
import LinkedList.PracticeLL;
import LinkedList.PracticeLL.Node;
// AS I AM HERE THAT MEANS I KNOW HOW TO FIND THE MIDDLE NODE OF A LL AND HOW TO MERGE TWO
// LL IN SORTED MANNER.(AND THESE BOTH ARE ALREADY COVERED)  ⭐⭐
//T: O(n logn) & S: O(1)
public class MergeSort {
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

        Node head = sortList(l.head);
        while(head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        } 
        System.out.println("END");
        
    }

    public static Node sortList(Node head) {
        if(head == null || head.next == null) { // base case
            return head;
        }

        Node mid = getMid(head);  //to find the middle element/node
        Node left = sortList(head);
        Node right = sortList(mid);

        return mergeInSortedWay(left, right);
    }

    //Some modifications here bcz we have to keep breaking the LL from middle
    public static Node getMid(Node head) {
        Node midPrev = null;
        while(head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;  //if midPrev is equal to null then midPrev == head; else midPrev = midPrev.next;
            head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    //Now you may ask it merges two sorted lists but here we are not given sortedLL.. You are right but think again it starts with one element initially both lists will have one element and then it returns them in sorted way
    public static Node mergeInSortedWay(Node head1, Node head2) {
        PracticeLL instance = new PracticeLL();
        Node dummyHead = instance.new Node(); //we can't directly write new Node(); bcz this is subclass of another class  
        Node tail = dummyHead;

        while(head1 != null && head2 != null) {
            if (head1.value > head2.value) {
                tail.next = head2;
                tail = tail.next;
                head2 = head2.next;
            } else {
                tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
            }
        }

        //Now lets print the remaining elements if any from either of the lists
        if(head1 != null) {
            while(head1 != null) {
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;
            }
        } else {
            while(head2 != null) {
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
        }

        return dummyHead.next;
    }
}
