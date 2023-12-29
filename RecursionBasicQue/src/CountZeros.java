public class CountZeros {
    public static void main(String[] args) {
        int n = 200010;
        System.out.println(count(n));
        System.out.println(count2(n));
    }

    //METHOD 1:
    static int count = 0;

    static int count(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 10 == 0) {
            count++;
        }
        count(n / 10);
        return count;
    }

    // METHOD 2: using helper function  BETTER ONE
    static int count2(int n) {
        return helper(n, 0);
    }

    static int helper(int n, int count) {
        if (n == 0) {
            return count;                       //Count remember
        }
        if (n % 10 == 0) {
            return helper(n/10, count + 1);
        }
        return helper(n/10, count);
    }
}
