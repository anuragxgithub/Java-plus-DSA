public class Shadowing {
    static int x = 20; // this will be shadowed at line 7

    public static void main(String[] args) {
        System.out.println(x); // 20
        int x;  //The class lv. variable at line 4 is shadowed by it
//      System.out.println(x); // scope begins when variable is initialization
        x = 30;
        System.out.println(x);  // 30
        fun();
    }
    static void fun() {
        System.out.println(x); // 20  logical
    }
}

