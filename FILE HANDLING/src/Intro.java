//SEE FILEGUIDE FOR BETTER VERSION OF BELOW NOTES.
//https://chat.openai.com/share/be31d252-37c3-4156-84d9-d803a125b2f4
/*   stream : sequence of data.
Byte Stream : Used to handle raw binary data. It is suitable for reading and writing non-text
files such as image, audio, video or any other binary files. Byte input and output in java are 
generally handled using classes derived from the "InputStream" and "OutputStream" abstract classes
means these classes have differnt subclasses and we use these subclasses to read or write
different types of data especially non textual data.
    InputStream: and its SUBCLASSES (FileInputStream, ByteArrayInputStream, etc.) for reading binary data.
    OutputStream: and its SUBCLASSES (FileOutputStream, ByteArrayOutputStream, etc.) for writing binary data.

Character Stream : Used to read and write text data. The stream is particularly useful when dealing
with text files such as .txt files. Character input and output in Java are generally handled using
classes derived from the "Reader" and "Writer" abstract classes means these classes have differnt
subclasses and we use these subclasses to read or write different text data.
    Reader: and its SUBCLASSES (FileReader, BufferedReader, etc.) for reading text data.
    Writer: and its SUBCLASSES (FileWriter, BufferedWriter, etc.) for writing text data.


>> Both byte and character stream classes in Java are part of the java.io package. <<

-> If the class name is having InputStream for reading or OutputStream for writing then that class
is used to represent the Byte streams.
Eg: 

-> If th class name is having Reader for reading or Writer for writing then that class is used to
represent Character streams.
Eg: 


Note: whenever we are working with these streams at the end we need to close them bcz they hold
some resources until they are closed.
Any class that implements autocloseable interface that means we can consider it as a resourse
so we need to close that after the work is done.

Check out the documentation.
*/

import java.io.InputStreamReader;
import java.io.IOException;
public class Intro {
    public static void main(String[] args) {
        // InputStreamReader and OutputStreamReader are a bridge from character stream to byte stream. You can check more details about them.
        try (InputStreamReader isr = new InputStreamReader(System.in)) {  //the InputStreamReader class in Java is not a class for byte streams. It is actually a class for character streams. It's used to bridge the gap between byte streams and character streams by converting bytes from an underlying byte stream (like InputStream) into characters using a specified character encoding.
            System.out.print("Enter letters/numbers: "); 
            int letters = isr.read();  //Reads a single character.
            //Note: character stream means it holds the unincode/ascii value of data that means you read or write any language's character using character stream. So the above letter variable will hold the ascii value of whatever we enter.
            while(isr.ready()) {       //ctrl+click on ready() to know what it is about
                System.out.println((char) letters);
                letters = isr.read();
            }
            // isr.close();  //note: after java 7 we don't need to write the close() bcz try catch block will automatically closes it
            System.out.println();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
/*
 Note:
We can also use byte stream classes to read or write the text files too but they are not as
suitable as charater stream classes.
Eg: of this thing is :
System.in -> standard InputStream -> means it is a byte stream but we use it to read characters (keyboard)
System.out -> standard OutputStream -> again it is a byte stream we use it to write characters (console)
System.err -> standard error -> byte stream (console)

Overall we can also handle textual data using byte stream classes but we usually don't do it bcz
mostly character stream classes are more suitable for this.
 */