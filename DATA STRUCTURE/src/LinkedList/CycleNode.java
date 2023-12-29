//So if you use Floyd's tortoise and hare algo / fast and slow pointer method
 //First check for the cycle traditionally now if you have fast and slow 
 //pointers together in the cycle now start moving the head pointer and slow ptr
 //together one one step and the place where both pointers(slow & head) meet is
 //the node where cycle begins.
 //you can prove this using pen and paper.
 //Note: while checking for the cycle move fast pointer twice the speed of slow ptr.

package LinkedList;
//Leet Code 142   : Return the node from where cycle begins.
// https://youtu.be/95ZfuoSAUPI
import LinkedList.PracticeLL.Node;
public class CycleNode {
    public static void main(String[] args) {
    PracticeLL l5 = new PracticeLL();
        l5.insertLast(39);
        l5.insertLast(75);
        l5.insertLast(23);
        l5.insertLast(56);
        l5.display();
        //Since in our linked list we can't provide cycle so it will here always give null.
        Node ans = detectCycle(l5.head);
        if(ans == null) {
            System.out.println("No cycle found.");
        } else {
            System.out.println(ans.value);
        }
    }
    
    public static Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                while(head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;  //or head as both point to same node (where cycle begins)
            }
        }
        
        return null;   

    }
}
