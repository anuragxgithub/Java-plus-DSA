package Questions;
// https://www.geeksforgeeks.org/problems/implement-atoi/1
public class Que {
    public static int atoi(String s) {
        boolean negative = false;
        int startIndex = 0;
        if(s.charAt(0) == '-') {
            startIndex = 1;
            negative = true;
        }
        int numericValue = 0;

        for(int i = startIndex; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                int digit = ch - '0';    // gives the numeric value if we subtract any char by a character 0
                numericValue = (numericValue*10) + digit;
            } else {
                return -1;
            }
        }
        if(negative) {
            numericValue = numericValue*-1;
        }
        return numericValue;
    }

    public static void main(String[] args) {
        String s = "-2341";
        System.out.println(atoi(s));
    }
}
