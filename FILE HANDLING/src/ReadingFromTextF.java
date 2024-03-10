//Here we will read data from another file. So here we will be reading from text file
//so we will use charater stream class here. Note as we know we can also use byte stream classes
//too to read from a text file but that is not much suitable.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingFromTextF {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("C:\\Users\\DELL\\Documents\\#Java\\FileHandling\\src\\n" +
                "ote.txt")) {  //The class contain Reader in its name so obviously it is a CharacterStream's subclass
            int letters = fr.read();
            while(fr.ready()) {
                System.out.println((char) letters);  //converting the unicode to its equivalent character
                letters = fr.read();
            }
            // fr.close()
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------------------------------");

        //BufferedReader class (BufferedReader and FileReader both are used to read the character stream
        //data in java but there are some differences like BufferedReader class is more efficient and
        //come with various useful methods like readLine() method. Find out other differences.)
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) { //since it(BufferedReader) is used for character stream data we need to provide the InputStream(System.in) in the consntructor but we can't directly do that bcz it is for Character stream data and System.in is for byte data so we use the bridge which is InputStreamReader here
            System.out.print("Enter word/numbers: ");
            int letters = br.read();
            while(br.ready()){
                System.out.println((char) letters);
                letters = br.read();
            }
            // br.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //reading comeplete line from a file using BufferedReader
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DELL\\Documents\\#Java\\FileHandling\\src\\n" +
                "ote.txt"))) {
            while(br.ready()) {
                System.out.println(br.readLine());
            }
            // br.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
