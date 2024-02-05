package RecursionOnStrings;//Returning permutations in array list by creating array list inside the method.
import java.util.ArrayList;
public class Permutations_Return {
    public static void main(String[] args) {
        ArrayList<String> ans = permutationsList("", "abc");
        System.out.println(ans);
        //Sasta method : passing array list to the method.
        //System.out.println(permutationsList_sasta("", "abc", new ArrayList<>()));
    }

    static ArrayList<String> permutationsList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);

        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(permutationsList(f+ch+s, up.substring(1)));
        }
        return ans;
    }


    //sasta one:
//    static ArrayList<String> permutationsList_sasta(String p, String up, ArrayList<String> list) {
//        if(up.isEmpty()) {
//            list.add(p);
//            return list;
//        }
//
//        char ch = up.charAt(0);
//        for(int i = 0; i <= p.length(); i++) {
//            String f = p.substring(0,i);
//            String s = p.substring(i,p.length());
//            permutationsList_sasta(f+ch+s, up.substring(1), list);
//        }
//        return list;
    }

