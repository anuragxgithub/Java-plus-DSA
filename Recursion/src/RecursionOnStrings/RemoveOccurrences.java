package RecursionOnStrings;

public class RemoveOccurrences {

    static String removeA(String s, int idx) {
        String ans = "";
        if(idx == s.length()) return "";

        if(s.charAt(idx) == 'a') {
            return removeA(s, idx+1);
        }

        String smallAns = s.charAt(idx) + removeA(s, idx+1);
        ans += smallAns;
        return ans;
    }

    public static String removeA2(String s, int idx) {
        // Here we won't create a local "ans" variable rather we use whatever is given to us
        if(idx == s.length()) return "";

        String smallAns = removeA2(s, idx+1);

        char curr = s.charAt(idx);
        if(curr != 'a') {
            return curr + smallAns;
        }
        return smallAns;
     }

     static String removeA3(String s) {
        if(s.length() == 0) return "";

        String smallAns = removeA3(s.substring(1));

        char firstCh = s.charAt(0);
        if(firstCh != 'a') {
            return firstCh + smallAns;
        }
        return smallAns;
     }


    public static void main(String[] args) {
        //Bharo and bhejte raho technique will be used in such types of recursion questions

        // 1st method
        System.out.println(removeA("anuxyazrag", 0));

        // 2nd Method
        System.out.println(removeA2("anuxyazrag", 0));

        // 3rd Method using this string method substring(inclusive, exclusive) without passing idx
        System.out.println(removeA3("anuxyazrag"));
    }
}
// NOTE: CONCATENATION OF STRING TAKEN O(n+m) TIME. SO ALL THE ABOVE CODE TIME COMPLEXITY WOULD BE
// O(n^2).
// SPACE COMPLEXITY : O(n + n), but it simplifies to O(n)