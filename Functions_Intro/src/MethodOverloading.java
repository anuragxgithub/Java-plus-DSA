// Method overloading basically means you can create multiple methods under a class with same name but with different parameters
public class MethodOverloading {
    public static void main(String[] args) {
        fun(1);
        fun(1,2);
//      fun(); but this will give ambiguous error b/z unable to identify which method to call

        name("Anurag");
    }
    static void fun(int x) {
        System.out.println("1st function");
        System.out.println(x);
    }
    static void fun(int x, int y) {
        System.out.println("2nd function");
        System.out.println(x);
    }
    static void name(String x) {
        System.out.println(x);
    }
//    static void name(String x) { this will not be allowed b/z parameters will become same
//        System.out.println(x);
//    }

}
