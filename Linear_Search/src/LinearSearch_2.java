import java.util.Arrays;

// Linear search in STRING
public class LinearSearch_2 {
    public static void main(String[] args) {
        String name = "Anurag";
        char target = 'r';
        System.out.println(Arrays.toString(name.toCharArray())); // to tell u how can string gets converted to character array (this print fn has two fns. combined first to print any array as string and second one is toCharArray.)
        boolean ans1 = search1(name, target); // fn 1 gives T or F for whether element exist or not.
        int ans2 = search2(name, target);  // fn 2 gives the index of the target element in array.
        System.out.println("Does element exist ? : "+ans1);
        System.out.println("Index is : "+ans2);
    }
//----------------fn1----------------------------------------------//
    static boolean search1(String naam, char target) {
        if(naam.length() == 0) {
            return false;
        }
        for(int element : naam.toCharArray()){  // this is for each loop isko istemal krne ke liye string ko character array me convert kiya wrna normally bhi ho jata.
            if(element == target) {
                return true;
            }
        }
        return false; //if any of the above condition not matched means elem. does not exist
    }
//----------------------fn2-----------------------------------------//
    static int search2(String name, char target) {
        if(name.length() == 0) {
            return -1;
        }
        for (int i = 0; i < name.length(); i++) {
            if(target == name.charAt(i)) {
                return i;
            }
        }
        return -1; // i.e, not found.
    }
}
