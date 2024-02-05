public class Kmultiples {
    static void printMultiples(int num, int k) {  // given number num print k multiples of num
        if(k == 0) return;

        printMultiples(num, k-1);
        System.out.println(num*k);
    }
    public static void main(String[] args) {
        int num = 12;
        int k = 5;
        printMultiples(num, k);
    }
}
