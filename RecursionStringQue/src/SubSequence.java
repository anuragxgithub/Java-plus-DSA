//SEE NOTES ⭐⭐ EasyPeasy to understand recursion tree.
//2^n subSequences (n is no of elements)
public class SubSequence {
    public static void main(String[] args) {
        subSequence("abc", "");
    }

    static void subSequence(String str, String ans) {
        if(str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        subSequence(str.substring(1), ans+ch);
        subSequence(str.substring(1), ans);
        //also print the empty string
    }

    //see how we can return string ArrayList for this question in subS_returnArraylist
}
//The time complexity of the subSequence function is O(2^n), where n is the length of the input string str.
//This is because for each character in str, we have two choices: either include it in the subsequence or exclude it.
//Therefore, the function will make 2^n recursive calls in the worst case.

//The space complexity of the subSequence function is also O(2^n). This is because for each recursive call,
//we are creating a new string ans+ch that is passed as a parameter to the next recursive call. In the worst case,
//there will be 2^n such strings created on the call stack. However, note that the space used by the call stack
//itself is not included in this analysis.

//S.C.: O(n*2^n) including stack calls space too