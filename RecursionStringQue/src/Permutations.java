// Permutations of given sequence.
// p -> processed __and__ up -> unprocessed
// See Notes⭐⭐
public class Permutations {
    public static void main(String[] args) {
        permutations("" , "abc");
    }
    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        //<----substring shit---->:
        //beginIndex – the beginning index, inclusive.
        //endIndex – the ending index, exclusive.
        //NOTE:  When the starting index and ending index are the same, the substring() method returns an empty string.
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            permutations(f+ch+s, up.substring(1));

        }
    }
}
