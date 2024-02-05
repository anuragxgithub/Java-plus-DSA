package BasicQuestions;

public class SumOfNnums {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(sum(n));
    }
    static int sum(int n) {
        if(n == 1) {
            return 1;
        }
        return sum(n-1) + n;
    }
}
