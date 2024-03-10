import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
// https://docs.oracle.com/javase/8/docs/api/java/io/File.html

public class FileClass {
    public static void main(String[] args) {

        //creating a new file
        try {
            File fo = new File("new-file.txt"); //(fo -> file object) and here it does not create the new file rather it creates the instance of that file
            fo.createNewFile();  //Atomically creates a new, empty file named by this abstract pathname if and only if a file with this name does not yet exist.
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //writing into the new file as we saw earlier
        try(FileWriter fw = new FileWriter("new-file.txt")) {
            fw.write("सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज। अहं त्वा सर्वपापेभ्यो मोक्षयिष्यामि मा शुचः।।18.66।।");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //reading from a text file/character stream data as we a know 
        try(BufferedReader br = new BufferedReader(new FileReader("new-file.txt"))) {
            while(br.ready()) {
                System.out.println(br.readLine()); //here it is not working idk why but working on replit
            } 
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //we can also delte a file 
        try {
            File fo = new File("Random.txt");
            fo.createNewFile();
            // fo.delete();  this returns true or false
            if(fo.delete()) {
                System.out.println(fo.getName());  //returning the deleted file name
            }
            
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
