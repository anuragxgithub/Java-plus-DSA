public class Swap_function {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a +" "+ b); // Why the value of a and b didn't get swapped in main method
    }                                  // Why? b/z the copy of value is passed (see notes)

    static void swap(int a, int b) {
        int temp = a;
        a=b;
        b = temp;
    }
}
