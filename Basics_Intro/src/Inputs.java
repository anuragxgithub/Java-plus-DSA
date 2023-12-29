import java.util.Scanner;
public class Inputs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // To use scanner fn 1st import java.util.Scanner && here System.in tells that we want data from keyboard(not any img. etc)

//        $<---Integer input--->$
//        System.out.print("Enter any integer input please : ");
//        int x = input.nextInt(); // To input data input.nextDatatype() is used where 'input' is the object of Scanner class
//        System.out.println("Your output is : " + x);

//        $<---String Input--->$
        System.out.print("Enter a string : ");
        String str = input.nextLine(); // nextLine reads the entire line of text it keeps reading the characters until the new line '\n' appears while only next() reads first word only
        System.out.println("Your string is : " + str);

        System.out.println("Enter anything it will read only the first word : ");
        String s = input.next();       // keeps reading the characters form the input stream until it encounters whitespace (including spaces, tabs, and newline characters)
        System.out.println("The first word is : " + s);
        input.nextLine();
    }
}
// Now note some terms:
/*
Input Stream:   (sequence of data which is being read sequentially)

-> An input stream is a sequence of data that is being read sequentially from a source. It's often associated with reading data from a file, network socket, or other input sources.
-> Input streams are an abstraction that allows you to read data one piece at a time, and they provide a common interface for reading data from different sources.
-> In Java, for example, the InputStream and Reader classes are used for reading input streams, and they provide methods to read data byte-by-byte or character-by-character.

Input Buffer:       (storage area in memory for the data which will be processed(here data is what we're inputting) )

-> An input buffer is a temporary storage area in memory where data is temporarily held before it's processed. It's commonly used to improve efficiency when reading data from a source that may be slow compared to the processing speed of the program.
-> When data is read from an input source (e.g., a file or network socket), it's often read in chunks into an input buffer. This allows the program to access the data in the buffer as needed without having to repeatedly access the slower external source.
-> Input buffers help reduce the overhead of frequently reading small amounts of data from a source, as reading larger chunks of data at once is often more efficient.
 */
