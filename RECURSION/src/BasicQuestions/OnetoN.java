package BasicQuestions;

public class OnetoN {
    public static void main(String[] args) {
        int n = 13;
        printNumbers(n);
    }

    static void printNumbers(int n) {
        if (n == 0) {
            return;
        }
        printNumbers(n - 1);
        System.out.println(n);  // WHEN FN. CALL IS RETURNING BACK THEN NUMBERS ARE GETTING PRINTED
    }
}
