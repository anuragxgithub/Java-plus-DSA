package BasicQuestions;

public class Concept_PostPreIncr {
    public static void main(String[] args) {
        int n = 5;
        nTo1(n);
    }
    static void nTo1(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
//      nTo1(n--);   NOTE: GIVE INFINITE RECURSION B/Z LOOP IS FIRST passing value and then decrementing n
        nTo1(--n); //This is correct
    }
}
