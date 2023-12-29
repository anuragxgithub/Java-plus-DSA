package LinkedList;
//LEETCODE 202
public class HappyNumber {
    public static void main(String[] args) {
        int n = 12;
        int slow = n;
        int fast = n;

        do {
            slow = sqDigits(slow);   //move one step
            fast = sqDigits(sqDigits(fast));  //move two steps
        } while(slow != fast);

        if (slow == 1) {
            System.out.println("Happy Number");
        } else {
            System.out.println("Not a happy number");
        }
    }

    public static int sqDigits(int num) {
        int sum = 0;
        while(num > 0) {
            int rem = num%10;
            sum = sum + rem*rem;
            num = num/10;
        }
        return sum;
    }
}
//We followed the same approach here like we did in the detection of whether a linked list is having cycle/loop or not.
//if a number is not happy number it will start repeating the squares'' sum of digits
//and hence form a cycle that's why we are able to detect it.