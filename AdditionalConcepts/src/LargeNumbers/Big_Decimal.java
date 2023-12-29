package LargeNumbers;

import java.math.BigDecimal;

/*
https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html
So, BigDecimal is a class in Java's standard library that's used for precise arithmetic operations
with decimal numbers. Unlike primitive data types like double and float, which might suffer from
precision issues due to the way floating-point arithmetic works, BigDecimal provides a way to 
perform calculations without losing precision.

It's especially useful when you're dealing with financial or mathematical calculations where
accuracy is crucial. BigDecimal is part of the java.math package, and it allows you to represent
and manipulate arbitrary-precision decimal numbers.
 */
public class Big_Decimal {
    //here see whats the problem with primitive double and float
    public static void main(String[] args) {
        float x = 2.3f;
        float y = 2.4f;
        System.out.println(y-x); //ans should be only 0.1000


        BigDecimal X = new BigDecimal("2.3");
        BigDecimal Y = new BigDecimal("2.4");
        BigDecimal sub = Y.subtract(X);
        System.out.println(sub);  //see accurate

        BigDecimal a = new BigDecimal("34827479324.34783");
        BigDecimal b = new BigDecimal("427337757684.34783");

        //operations
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
        // System.out.println(b.divide(a));  //Note: will give ArithmeticException for
        //Non-terminating decimal expansion
        System.out.println(b.pow(2));
        System.out.println(b.negate());

        //Constants
        BigDecimal con = BigDecimal.ONE;
        BigDecimal con2 = BigDecimal.TEN;
        System.out.println(con);
        System.out.println(con2);
    }
}
//Find out the range of the BigDecimal. Just to know. Will not be asked in interview.