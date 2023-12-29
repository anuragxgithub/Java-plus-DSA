// Imagine a 2d matrix where indexing starts from n to 1 not traditionally like 0 to n.
//Only going down and right  (vertical and horizontal)
//Taking our destination(final point to reach) to the most right down corner, it depends on the base
//condition you can set accordingly.
public class NoOfPaths {
    public static void main(String[] args) {
        System.out.println(countPaths(3,3));
    }

    static int countPaths(int r, int c) {
        if (r == 1 || c == 1) {    //base condition acts as our target i.e, where we need to go.
            return 1;
        }

        int left = countPaths(r-1, c); // Condition for down/vertical
        int right = countPaths(r, c-1); // Condition for right/horizontal
        return left + right;    //this sum value goes to the variable which calls this (left or right)
    }
}