//Print numbers from n to 1
public class Nto1 {
    public static void main(String[] args) {
        int n = 5;
        printNum(n);
    }
    static void printNum(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printNum(n-1);
    }
}
//SPACE COMPLEXITY: O(n)