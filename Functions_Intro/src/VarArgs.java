import java.util.Arrays;
//See notes for details
//Also known as variable length argument
public class VarArgs { // Used when total no. of inputs is not definite
    public static void main(String[] args) {
    fun(12,34,4,5,56,6,4); //You can provide any no of elements
    multiple(12, 8, "Anurag", "Shivanshu", "Aman")  ;
    }
    static void fun(int ...x) { // Internally it will be taken as array of integers same goes with other data types
        System.out.println(Arrays.toString(x));
    }
    static void multiple(int a, int b, String ...str) {
        System.out.println(a+" "+b+" "+ Arrays.toString(str));
    }

}
