public class BinarySearchSqrt {
    public static void main(String[] args) {
        int n = 48;
        int precision = 3;
        System.out.printf("%.3f", sqrt(n, precision));

    }

    static double sqrt(int n, int p) {
        int s = 0, e = n, m;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (m * m == n) {
                return m;
            } else if (m * m > n) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        double root = e;
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return root;
    }
}
// TIME COMPLEXITY:
//the overall time complexity of the algorithm is O(log n + p).
//However, since p is typically a small constant, the time complexity
//can be approximated as O(log n).
