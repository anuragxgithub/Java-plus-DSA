package FibonacciClassic;

import java.util.HashMap;

public class SumPossible {

    public static boolean  isSumPossible(int[] nums, int amount, HashMap<Integer, Boolean> memo) {
        if(amount == 0) return true;
        if(amount < 0) return false;

        if(memo.containsKey(amount)) {
            memo.get(amount);
        }
        for(int i = 0; i < nums.length; i++) {
            int subAmount = amount-nums[i];
            if(isSumPossible(nums, subAmount, memo)) {      // using if statement and then returning true like this helps us check all the values of amount available it will not return false until all possible numbers from nums are checked
                memo.put(amount, true);  // bcz amount is changing so obviously it is going to be our key and value is return type
                return true;
            }
        }
        memo.put(amount, false);
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {4,6,10,3};
        int amount = 15;
        //HERE YOU ARE GIVEN A NUMS ARRAY WHICH CONTAINS SOME NUMBERS
        // AND A AMOUNT.
        // YOUR JOB IS TO FIND OUT WHETHER WITH THE HELP OF NUMBERS IN nums IS IT POSSIBLE TO 
        // GENERATE SUM OF NUMBERS WHICH IS EQUAL TO THE AMOUNT. 
        // NOTE : YOU CAN USE AS ANY NUMBER IN nums AS MANY TIMES AS YOU WANT.

        // here the intuition should say that smaller amounts are easier to calculate so lets 
        // shrink the amount as much as possible till a trivially small amount for which i know the answer.

      /* 
                                4
                           /    |   \
                         1/     |2   \3
                         /      |     \
                        3       2      1
                      / | \   1/\2      \
                    1/ 2| 3|  1  0       \1
                    /   |  |  |1          \ 
                   2    1  0  0            0
                 /  \   |
               1/    \2 |1
               1     0  |
               |        0 
               |1
               |
               0
               Edge wt represent the value which we used from numbers i am subtracting the all possible numbers
               from the current amount until i got zero if i am able to get to zero that means sum is possible for the
               givne amount from given numbers in nums.
               
               You can see the repetition pattern jo just simply use dp and optimise it.
    */
        HashMap<Integer, Boolean> map = new HashMap<>();
        System.out.println(isSumPossible(nums, amount, map));

    }
}
// Tip: first solve it using brute force recursion and then memoize it.