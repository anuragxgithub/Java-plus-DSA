

class Random {
    public static void printPattern(int n) {
        if(n == 1) {
            System.out.println(1);
            return;
        }

        for(int i = 1; i <=n; i++) {
            System.out.print(i);
        }
        System.out.println();

        printPattern(n-1);
        for(int i = 1; i <= n; i++) {
            System.out.print(i);
        }
        System.out.println();

    }
    public static void main(String[] args) {
        printPattern(5);
    }
}
