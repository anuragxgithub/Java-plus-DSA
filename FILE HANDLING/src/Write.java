import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Write {
    public static void main(String[] args) {
        // Write/output
        try(OutputStream os = System.out) {  //out must be static method that's why we can access it using class reference
            os.write(66); 
            //if you proivde a number it will take it as ascii value and prints its char equivalent
        } 
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //Note: To run this block you have to first comment the above try catch block idk why.
        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            osw.write("Hello World"); // The write method has 3 variations(through method overloading)
            osw.write(98);
            osw.write(10);  //newline character
            osw.write('A');
            osw.write('\n');
            char[] arr = "Hello World".toCharArray();
            osw.write(arr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
