//Imagine a 2d matrix where indexing starts from n to 1 not traditionally like 0 to n.
//Only going down and right  (vertical and horizontal)
import java.util.ArrayList;
public class ReturningPath {
    public static void main(String[] args) {
        returnPath("", 3,3);
        System.out.println(returnPathArrayList("", 3,3, new ArrayList<>()));
        System.out.println(returnPathArrayList2("", 3,3));
    }

    // Method 1) Printing only not returning.
    static void returnPath(String p, int r, int c) {
        if(r == 1 && c == 1) {
            System.out.println(p);
        }
        if(r > 1) {   // Condition for down/vertical
            returnPath( p + 'D',r-1, c);
        }
        if(c > 1) {   // Condition for right/horizontal
            returnPath(p + 'R', r, c-1);
        }
    }

    //Method 2) Returning ans in ArrayList. By taking arraylist in argument.
    static ArrayList<String> returnPathArrayList(String p, int r, int c, ArrayList<String> list) {
        if (r == 1 && c == 1) {
            list.add(p);
        }

        if(r>1) {
            returnPathArrayList(p + 'D', r-1, c, list);
        }
        if(c>1) {
            returnPathArrayList(p + 'R', r, c-1, list);
        }

        return list;
    }


    //Method 3) Returning ans in ArrayList. By creating new arraylist inside the method.
    static ArrayList<String> returnPathArrayList2(String p, int r, int c) {
        if(r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r>1) {
            ans.addAll(returnPathArrayList2(p + 'D', r-1, c));
        }
        if(c>1) {
            ans.addAll(returnPathArrayList2(p + 'R', r, c-1));
        }

        return ans;
    }
}
