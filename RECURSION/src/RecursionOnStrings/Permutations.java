package RecursionOnStrings;

// RecursionOnStrings.Permutations of given sequence.
// p -> processed __and__ up -> unprocessed
// See Notes⭐⭐

/*

In permutations, all the characters of the original string are present,
but they can be arranged in any order. Each permutation contains all the characters of the
original string exactly once.
In general, for a string of length n, there are n! permutations, where n! denotes the factorial of n.

In permutations, we basically insert characters at different positions. ⭐
Take one char first and find out its possible positions.
Now take another char and find out the possible positions it can be present at (considering the first char) and so on.
 */
public class Permutations {
    public static void main(String[] args) {
        permutations("" , "abc");
    }
    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);             // for this we will find different possible positions

        //<----substring shit---->:
        //beginIndex – the beginning index, inclusive.
        //endIndex – the ending index, exclusive.
        //NOTE:  When the starting index and ending index are the same, the substring() method returns an empty string.
        for(int i = 0; i <= p.length(); i++) {  // finding the positions to insert the current char in processed string. Why <= ? bcz that many positions are possible for char to be inserted
            String f = p.substring(0,i);            // slicing processed string into first and second string so that we can put them before and after position of the char to be added
            String s = p.substring(i, p.length());
            permutations(f+ch+s, up.substring(1));
        }
    }
}
// Here the recursive calls are variable at different level. It depends on the size of the processed string
// no of calls is size of processed+1.