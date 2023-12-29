public class PrimitiveDT {
    public static void main(String[] args) {
        byte a = 1;     // size 1 byte its name suggest the same
        short x = 1232;         // 2 byte
        int rollNo = 123;               // 4 byte
        long largeNumbers = 3174363478739L; // Remember L or l      8 byte
        float marks = 97.8f;  // Remember f            4 byte
        double largeDecimalNumbers = 879317.783;                // 8 byte
        char ch = 'a';              // 2 byte
        boolean check = true;           // 1 BIT ONLY NOT BYTE REMEMBER THIS
        System.out.println(x);

// why char is of 2 byte in java as it only stores a single character.. bcz java follows Unicode it
// supports character of all languages that's why the Unicode values of characters can go outside the
// 1 byte range that is -128 to 127.
        char anyChar = '♪';
        char anyChar2 = '❤';
        System.out.println(anyChar + " has a unicode value of " + (int)(anyChar));
        System.out.println(anyChar2 + " has a unicode value of " + (int)(anyChar2));

        // Now you must have understood why char in java is of 2 byte
// (Unicode is a character encoding standard) that aims to represent characters from all the world's
// writing systems. The original Unicode standard used a 16-bit encoding, which allowed for the
// representation of up to 65,536 different characters.
    }
}
// according to size increasing
// -> boolean < byte < short = char < int = float < double = long
// 8 primitive data types in java and 7 in js



