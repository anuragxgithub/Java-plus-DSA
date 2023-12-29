package LargeNumbers;
import java.math.BigInteger;
// https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/math/BigInteger.html#%3Cinit%3E(java.lang.String)
// Biginteger is a class that extends Number class and implements Comparable<> Interface.
// Normal range of int is (-2147483648(-2^31), +2147483647(2^31)) 
// Integer.MAX_VALUE = 2^31(2147483647)
public class Big_Integer {
    public static void main(String[] args) {
        BigInteger A = BigInteger.valueOf(2100000000);
        //here(above) we are directly(using class reference without creating obj) accessing the 
        //.valueOf() method bcz it is static method. Creates an integer of BigInteger type.
        //Note: but here we can pass the value withing the range of integer
        BigInteger B = BigInteger.valueOf(2100000000);

        BigInteger s = A.add(B);
        System.out.println(s);

        BigInteger C = new BigInteger("3937488344924"); 
        //here(above) in this constructor we can enter any value large intger value from range
        // (-2^Integer.MAX_VALUE to 2^Integer.MAX_VALUE)  exclusive both sides will be a realy huge large number
        BigInteger D = new BigInteger("9372474434283");

        //addition
        BigInteger s1 = C.add(D);
        System.out.println(s1);

        //subtraction
        BigInteger sub = C.subtract(D);
        System.out.println(sub);

        //multiplication
        BigInteger m = C.multiply(D);
        System.out.println(m);
        System.out.println(m.getClass().getName());

        //divide
        BigInteger d = D.divide(C);
        System.out.println(d);

        //remainder
        BigInteger rem = C.remainder(D);
        System.out.println(rem);

        //comparison (note they are object not primitive types)
        if(D.compareTo(C) > 0) {
            System.out.println("D is greater");
        }

        // Constants
        BigInteger con1 = BigInteger.ONE;   //obviously ONE will be static instanace var.
        BigInteger con2 = BigInteger.TWO;
        BigInteger con3 = BigInteger.TEN;
        System.out.println(con1);
        System.out.println(con2);
        System.out.println(con3);
    }
}
