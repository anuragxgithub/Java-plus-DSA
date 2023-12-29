public class Literals {
    public static void main(String[] args) {
        // Let's play with java literals
        int bin = 0b101;      // binary
        System.out.println(bin);      // decimal value will be printed

        int hex = 0xAE;  // hexadecimal
        System.out.println(hex);

        int zerooos = 10_00_00_000;  // whenever you are getting confused with the lots of zeros
        // java provides you a feature you can use underscore(as many) it won't give you error
        System.out.println(zerooos);

        double expo = 12e10;    // you can write exponents in this form too
        System.out.println(expo);   // it will adjust by itself if needed

        char ch = 'a';
        ch++;
        System.out.println(ch);
    }
}
