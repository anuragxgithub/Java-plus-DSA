//Now here we will consider diagonal as a path too. Previously we are considering only down and right
//i.e, (vertical and horizontal).
//NOTE: V -> for vertical(down) , D -> for diagonal , H -> for horizontal(right)

import java.util.ArrayList;
public class ReturningPathDiagonal {
    public static void main(String[] args) {
        returnPathDiagonal("", 3, 3);
        System.out.println(returnPathDiagonal2("", 3, 3));
    }

    static void returnPathDiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
        }

        if (r > 1 && c > 1) {  // Condition for diagonal
            returnPathDiagonal(p + 'D', r - 1, c - 1);
        }
        if (r > 1) {  // Condition for down/vertical
            returnPathDiagonal(p + 'V', r - 1, c);
        }
        if (c > 1) {   // Condition for right/horizontal
            returnPathDiagonal(p + 'H', r, c - 1);
        }
    }

    //Method 2) Returning ans in array list by creating the array list inside the method itself.
    static ArrayList<String> returnPathDiagonal2(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        if (r > 1 && c > 1) {  // Condition for diagonal
            ans.addAll(returnPathDiagonal2(p + 'D', r - 1, c - 1));
        }
        if (r > 1) {  // Condition for down/vertical
            ans.addAll(returnPathDiagonal2(p + 'V', r - 1, c));
        }
        if (c > 1) {   // Condition for right/horizontal
            ans.addAll(returnPathDiagonal2(p + 'H', r, c - 1));
        }

        return ans;
    }
}