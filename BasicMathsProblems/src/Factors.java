import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        int n = 36;
        factors1(n);
        factors2(n);
        factors3(n);

    }
    //METHOD 1: NOT OPTIMISED >>T.C. : O(N)
    static void factors1(int n) {
        for(int i = 1; i<= n; i++) {
            if(n%i==0) {
                System.out.print(i + " ");
            }
        }
    }
    //METHOD 2: OPTIMISED BUT ORDER IS NOT CORRECT >> T.C. O(sqrt(n))
    static void factors2(int n) {
        System.out.println();
        for(int i = 1; i<= Math.sqrt(n); i++) {
            if(n%i == 0) {
                if(i*i == n) {       //THIS CONDITION IS WRITTEN B/Z IF N = 36 THEN WHEN I = 6 IT GET PRINTED 2 TIMES (b/z of n/i)
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + n / i + " ");
                }
            }
        }
    }

    //METHOD 3: OPTIMISED AND ORDER IS ALSO CORRECT >>T.C. O(sqrt(n)) >> S.C. O(sqrt(n))
    static void factors3(int n) {
        System.out.println();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n%i == 0) {
                if(i*i == n) {          //THIS CONDITION IS WRITTEN B/Z IF N = 36 THEN WHEN I = 6 IT GET PRINTED 2 TIMES (b/z of n/i)
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for(int i = list.size() - 1; i >= 0; i--) {   //printing list item from last b/z bigger factors came first in list
            System.out.print(list.get(i) + " ");
        }
    }
}
