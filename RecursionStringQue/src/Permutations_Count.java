// Count the total number of permutations possible of the given sequence.
public class Permutations_Count {
    public static void main(String[] args) {

        System.out.println(permutationsCount("", "abc"));
        System.out.println(permutationsCount2("", "abc", 0));
    }

    static int permutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }

    // SECOND EASY METHOD---->
    static int permutationsCount2(String p, String up, int count) {
        if (up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }
}
