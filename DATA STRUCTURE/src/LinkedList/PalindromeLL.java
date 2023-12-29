package LinkedList;
import LinkedList.PracticeLL.Node;

// LEETCODE 234 : Palindrome LL return true if yes otherwise false.
// The idea to solve this problem is get the middle node and reverse the list of second half
//now compare each element of first half with the second half if the elemnts keep matching 
//till end then it is palindromic ll.
//Now at the end rereverse the second half.
public class PalindromeLL {
    public static void main(String[] args) {
        PracticeLL l1 = new PracticeLL();
        l1.insertLast(1);
        l1.insertLast(2);
        l1.insertLast(3);
        l1.insertLast(2);
        l1.insertLast(1);
        
        l1.display();
        
        System.out.println(isPalindrome(l1.head));

    }


    public static boolean isPalindrome(Node head) {
        Node mid = middle(head);
        Node headToRereverse = mid;
        Node headSecond = reverse(mid);

        while(head != null && headSecond != null) {
            if(head.value != headSecond.value) {
                return false; //not a palindrome
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverse(headToRereverse);
        return true;  // is a palindrome.
        
    }

    public static Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        if(slow.next == null) {  //if there is only one element is the LL
            return head;
        }
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while(fast != null && fast.next != null);

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
            if(nxt != null) {  //to prevent NullPointerException
                nxt = nxt.next;
            }
        }
        return prev;  //head of reversed LL
    }
}
