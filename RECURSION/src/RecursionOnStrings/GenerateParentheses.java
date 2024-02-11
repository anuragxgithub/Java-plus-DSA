/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed
parentheses.
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
 */

package RecursionOnStrings;

public class GenerateParentheses {

    public static void generateParentheses(int n, int leftCount, int rightCount, String curr) {
        if(curr.length() == n*2) {
            System.out.print(curr + " ");
            return;
        }

        // choosing left (opening bracket)
        if(leftCount < n) {
            generateParentheses(n, leftCount+1, rightCount, curr + '(');
        }
        // choosing right (closing bracket)
        if(leftCount > rightCount) {
            generateParentheses(n, leftCount, rightCount+1, curr + ')');
        }

    }

    public static void main(String[] args) {
        int n = 3;   // you can use 3 opening and 3 closing brackets
        String temp = "";
        generateParentheses(n,0, 0, temp);
    }
}
